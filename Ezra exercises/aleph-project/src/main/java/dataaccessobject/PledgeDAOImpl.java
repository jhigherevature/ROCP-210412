package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectutil.ConnectUtil;
import main.CUR;
import model.Donor;
import model.Pledge;

public class PledgeDAOImpl implements PledgeDAO {

	@Override
	public boolean insertIntoPledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "INSERT INTO project.pledge VALUES (default,?,?,(?::numeric::money),?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getId_account());
			ps.setInt(2, pledge.getYear_pledge());
			ps.setDouble(3, pledge.getPledge_amt());
			ps.setInt(4, pledge.getId_school());
			ps.setDate(5, pledge.getDate_pledged());
			ps.setString(6, pledge.getStatus_pledge());
			ps.setDate(7, pledge.getSubmission_date());
			ps.setDate(8, pledge.getApproval_date());
//System.out.println(pledge.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deletePledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "DELETE FROM project.pledge WHERE id_pledge=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getId_pledge());
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deletePledge(Pledge pledge, Integer account_id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "DELETE FROM project.pledge WHERE id_pledge=? AND id_account=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getId_pledge());
			ps.setInt(2, account_id);
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deletePledge(Integer pledge_id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "DELETE FROM project.pledge WHERE id_pledge="+pledge_id+";";
			ps = conn.prepareStatement(query);
//			ps.setInt(1, pledge.getId_pledge());
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Pledge selectPledge(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pledge p = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "SELECT * FROM project.pledge WHERE id_pledge=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Pledge(
						rs.getInt("id_pledge"),
						rs.getInt("id_account"),
						rs.getInt("year_pledge"),
						rs.getDouble("pledge_amt"),
						rs.getInt("id_school"),
						rs.getDate("date_pledged"),
						rs.getString("status_pledge"),
						rs.getDate("submission_date"),
						rs.getDate("approval_date")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public Pledge selectPledgebyDonor(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pledge p = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "SELECT * FROM project.pledge WHERE id_pledge=? AND id_account=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.setInt(2, CUR.getCUR().getAcc().getId_account());
			rs = ps.executeQuery();
			while (rs.next()) {
				p = new Pledge(
						rs.getInt("id_pledge"),
						rs.getInt("id_account"),
						rs.getInt("year_pledge"),
						rs.getDouble("pledge_amt"),
						rs.getInt("id_school"),
						rs.getDate("date_pledged"),
						rs.getString("status_pledge"),
						rs.getDate("submission_date"),
						rs.getDate("approval_date")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public List<Pledge> selectPledgesByYear(Integer account, Integer year){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Pledge> plist = new ArrayList<Pledge>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.pledge where year_pledge=? AND id_account=?;";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, year);
			ps.setInt(2, account);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pledge pledge = new Pledge();
			
				pledge.setId_pledge(rs.getInt("id_pledge"));
				pledge.setId_account(rs.getInt("id_account"));
				pledge.setYear_pledge(rs.getInt("year_pledge"));
				pledge.setPledge_amt(rs.getDouble("pledge_amt"));
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
	
	@Override
	public List<Pledge> selectPledges(Integer id_pledge){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Pledge> plist = new ArrayList<Pledge>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.pledge where id_pledge=?;";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id_pledge);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pledge pledge = new Pledge();
			
				pledge.setId_pledge(rs.getInt("id_pledge"));
				pledge.setId_account(rs.getInt("id_account"));
				pledge.setYear_pledge(rs.getInt("year_pledge"));
				pledge.setPledge_amt(rs.getDouble("pledge_amt"));
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

	@Override
	public List<Pledge> selectPledgesByYear(Integer year){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Pledge> plist = new ArrayList<Pledge>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.pledge where year_pledge=?;";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, year);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				Pledge pledge = new Pledge();
			
				pledge.setId_pledge(rs.getInt("id_pledge"));
				pledge.setId_account(rs.getInt("id_account"));
				pledge.setYear_pledge(rs.getInt("year_pledge"));
//				get double currently trying others
				pledge.setPledge_amt(rs.getDouble("pledge_amt"));
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
	
	@Override
	public boolean updatePledge(Pledge pledge) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.pledge SET year_pledge=?, pledge_amt=?, id_school=?, date_pledged=?, status_pledge=?, submission_date=?, approval_date=? WHERE id_pledge=?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, pledge.getYear_pledge());
			ps.setDouble(2, pledge.getPledge_amt());
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
	
	@Override
	public int getPledgeNumber(Integer account_id, int pledge_year) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer x = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "SELECT count(id_pledge) FROM project.pledge WHERE id_account = ? AND year_pledge = ?;";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, account_id);
			ps.setInt(2, pledge_year);

			
			rs = ps.executeQuery();
						
			while (rs.next()) {
				x = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	@Override
	public Double getPledgeValue(Integer account_id, int pledge_year) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Double x = null;

		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "SELECT sum(pledge_amt::NUMERIC) FROM project.pledge WHERE id_account = ? AND year_pledge=?;";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, account_id);
				ps.setInt(2, pledge_year);

				
				rs = ps.executeQuery();
							
				while (rs.next()) {
					x = rs.getDouble("sum");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return x;
		}
	
	@Override
	public int getPledgeNumberAll(int pledge_year) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer x = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "SELECT count(id_pledge) FROM project.pledge WHERE year_pledge = ?;";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, pledge_year);

			
			rs = ps.executeQuery();
						
			while (rs.next()) {
				x = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
	
	@Override
	public Double getPledgeValueAll(int pledge_year) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Double x = null;

		try (Connection conn = ConnectUtil.getConnection()) {

			String query = "SELECT sum(pledge_amt::NUMERIC) FROM project.pledge WHERE year_pledge=?;";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, pledge_year);

				
				rs = ps.executeQuery();
							
				while (rs.next()) {
					x = rs.getDouble("sum");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return x;
		}
}

//					rs.getDate(query)   take in as a long or String

