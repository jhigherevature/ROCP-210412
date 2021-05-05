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
			
			String query = "INSERT INTO project.donor VALUES (default, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
//			ps.setInt(1, null);										//id_donor int
			ps.setInt(1, donor.getId_account());		//id_account integer													
			ps.setString(2, donor.getTitle()); 	//title varchar
			ps.setString(3, donor.getFirst_name());	//first_name varchar
			ps.setString(4, donor.getLast_name());	//last_name varchar
			ps.setString(5, donor.getAddress());	//address varc
			ps.setString(6, donor.getCity());	//city varchar
			ps.setString(7, donor.getState());	//state varchar
			ps.setInt(8, donor.getZip());			//zip intege
			ps.setString(9, donor.getPhone());	//phone varcha
			ps.setString(10, donor.getEmail());	//email varcha
			ps.setString(11, donor.getEmail_alt());	//email_alt
			ps.setString(12, donor.getSoc_sec());	//soc_sec
			ps.setString(13, donor.getNotes());	//notes	
			ps.setBoolean(14, donor.isAllow_school_contact());	//allow_school_contact
			ps.setBoolean(15, donor.isDonor_status());	//donor_status boolean
			ps.setInt(16, donor.getId_userpass());
			
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
						rs.getBoolean(16),
						rs.getInt(17)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	@Override
	public Donor selectDonorByid_userpass(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Donor d = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "SELECT * FROM project.donor WHERE id_userpass=?";
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
						rs.getBoolean(16),
						rs.getInt(17)
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
				d.setId_userpass(rs.getInt(17));
				dlist.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;
	}

	@Override
	public boolean updateDonor(Donor donor) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.donor SET id_account=?, title=?, first_name =?, last_name =?, address =?, city=?, state =?, zip=?, phone=?, email=?, email_alt=?, soc_sec=?, notes=?, allow_school_contact=?, donor_status=?, id_userpass=? WHERE id_donor =?;";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, donor.getId_account());
			ps.setString(2, donor.getTitle());
			ps.setString(3, donor.getFirst_name());
			ps.setString(4, donor.getLast_name());
			ps.setString(5, donor.getAddress());
			ps.setString(6, donor.getCity());
			ps.setString(7, donor.getState());
			ps.setInt(8, donor.getZip());
			ps.setString(9, donor.getPhone());
			ps.setString(10, donor.getEmail());
			ps.setString(11, donor.getEmail_alt());
			ps.setString(12, donor.getSoc_sec());
			ps.setString(13, donor.getNotes());						
			ps.setBoolean(14, donor.isAllow_school_contact());
			ps.setBoolean(15, donor.isDonor_status());
			ps.setInt(16, donor.getId_userpass());
			ps.setInt(17, donor.getId_donor());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteDonor(Donor donor) {
		System.out.println("Donors may not be deleted...instead set donor status to inactive");
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.donor SET donor_status='false' WHERE id_donor =?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, donor.getId_donor());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean deleteDonor(Integer x) {

		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.donor SET donor_status='false' WHERE id_donor =?;";
			ps = conn.prepareStatement(query);
			ps.setInt(1, x);
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public Donor selectDonorByLoginId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Donor donor = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.donor WHERE id_userpass=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				donor = new Donor(
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
						rs.getBoolean(16),
						rs.getInt(17)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return donor;
	}
	
	@Override
	public List<Donor> selectAllActiveDonors() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Donor> dlist = new ArrayList<Donor>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.donor WHERE donor_status='true';";
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
				d.setId_userpass(rs.getInt(17));
				dlist.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;
	}
	
	@Override
	public List<Donor> selectAllInactiveDonors() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Donor> dlist = new ArrayList<Donor>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.donor WHERE donor_status='false';";
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
				d.setId_userpass(rs.getInt(17));
				dlist.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dlist;
	}
	
	@Override
	public int getDonorActiveNumber() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer x = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT count(donor_status) FROM project.donor WHERE donor_status = 'true'";
			ps = conn.prepareStatement(query);
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
	public int getDonorInactiveNumber() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer x = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT count(donor_status) FROM project.donor WHERE donor_status = 'false'";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();				
			while (rs.next()) {
				x = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return x;
	}
}
