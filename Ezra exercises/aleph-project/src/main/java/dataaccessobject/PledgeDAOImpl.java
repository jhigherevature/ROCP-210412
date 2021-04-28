package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectutil.ConnectUtil;
import model.Donor;
import model.Employee;
import model.Pledge;

public class PledgeDAOImpl implements PledgeDAO {

	public boolean insertIntoPledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "INSERT INTO project.pledge VALUES (default,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getYear_pledge());
			ps.setInt(2, pledge.getPledge_amt());
			ps.setInt(3, pledge.getId_school());
			ps.setDate(4, pledge.getDate_pledged());
			ps.setString(5, pledge.getStatus_pledge());
			ps.setDate(6, pledge.getSubmission_date());
			ps.setDate(7, pledge.getApproval_date());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deletePledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "DELETE FROM project.pledge WHERE pledge_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getId_pledge());
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public List<Pledge> selectPledgesByYear(Integer account, Integer year){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Pledge> plist = new ArrayList<Pledge>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.pledge where year_pledge=?, id_account=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, year);
			ps.setInt(2, account);

			rs = ps.executeQuery(query);
			
			while (rs.next()) {
				Pledge pledge = new Pledge();
			
				pledge.setId_pledge(rs.getInt("id_pledge"));
				pledge.setId_account(rs.getInt("id_account"));
				pledge.setYear_pledge(rs.getInt("year_pledge"));
				pledge.setPledge_amt(rs.getInt("pledge_amt"));
				pledge.setId_school(rs.getInt("id_school"));
				pledge.setDate_pledged(rs.getDate("date_pledged"));
				pledge.setStatus_pledge(rs.getString("status_pledge"));
				pledge.setSubmission_date(rs.getDate("submission_date"));
				pledge.setApproval_date(rs.getDate("approval_date"));
				plist.add(pledge);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return plist;
	}

	public boolean updatePledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.pledge SET year_pledge=?, pledge_amt=?, id_school=?, date_pledged=?, status_pledge=?, submission_date=?, approval_date=? where id_pledge=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getYear_pledge());
			ps.setInt(2, pledge.getPledge_amt());
			ps.setInt(3, pledge.getId_school());
			ps.setDate(4, pledge.getDate_pledged());
			ps.setString(5, pledge.getStatus_pledge());
			ps.setDate(6, pledge.getSubmission_date());
			ps.setDate(7, pledge.getApproval_date());
			
			ps.setInt(8, pledge.getId_pledge());
	//	does this line work? It will 1. print the number of lines updated and 2. execute the update
			System.out.println("The number of pledges successfully updated: " + ps.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}

//					rs.getDate(query)   take in as a long or String

