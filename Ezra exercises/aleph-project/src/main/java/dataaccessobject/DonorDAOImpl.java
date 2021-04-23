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

public class DonorDAOImpl implements DonorDAO {

	@Override
	public boolean insertIntoDonors(Donor donor) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "INSERT INTO project.donor VALUES (default, null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
													//id_donor int
													//id_account integer													
			ps.setString(1, donor.getTitle()); 	//title varchar
			ps.setString(2, donor.getFirst_name());	//first_name varchar
			ps.setString(3, donor.getLast_name());	//last_name varchar
			ps.setString(4, donor.getAddress());	//address varc
			ps.setString(5, donor.getCity());	//city varchar
			ps.setString(6, donor.getState());	//state varchar
			ps.setInt(7, donor.getZip());			//zip intege
			ps.setString(8, donor.getPhone());	//phone varcha
			ps.setString(9, donor.getEmail());	//email varcha
			ps.setString(10, donor.getEmail_alt());	//email_alt
			ps.setString(11, donor.getSoc_sec());	//soc_sec
			ps.setString(12, donor.getNotes());	//notes	
			ps.setBoolean(13, donor.isAllow_school_contact());	//allow_school_contact
			ps.setBoolean(14, donor.isDonor_status());	//donor_status boolean
			
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Donor selectDonor(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Donor d = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "SELECT * FROM project.donor WHERE id_donor=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				d = new Donor(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getString(14),						
						rs.getBoolean(15),
						rs.getBoolean(16)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public List<Donor> selectAllDonors() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Donor> dlist = new ArrayList<Donor>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.donor";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Donor d = new Donor();
				d.setId_donor(rs.getInt(1));
				d.setId_account(rs.getInt(2));
//				set all of these for all 14
				d.setTitle(rs.getString(3));
//				add d.set...
				d.setFirst_name(rs.getString(4));
				d.setLast_name(rs.getString(5));
				d.setAddress(rs.getString(6));
				d.setCity(rs.getString(7));
				d.setState(rs.getString(8));
				d.setZip(rs.getInt(9));
				d.setPhone(rs.getString(10));
				d.setEmail(rs.getString(11));
				d.setEmail_alt(rs.getString(12));
				d.setSoc_sec(rs.getString(13));
				d.setNotes(rs.getString(14));						
				d.setAllow_school_contact(rs.getBoolean(15));
				d.setDonor_status(rs.getBoolean(16));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;
	}

	@Override
	public boolean updateDonor(Donor donor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDonor(Donor donor) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
