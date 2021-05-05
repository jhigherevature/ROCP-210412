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
import model.Pledge;
import model.School;

public class SchoolDAOImpl implements SchoolDAO {

	@Override
	public boolean insertIntoSchool(School school) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "INSERT INTO project.school VALUES (default, ?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
//			ps.setInt(1, null);										//id_donor int
//			ps.setInt(1, school.getId_school());		//id_school integer													
			ps.setString(1, school.getName_school());	
			ps.setString(2, school.getAddress());	//address varc
			ps.setString(3, school.getCity());	//city varchar
			ps.setString(4, school.getState());	//state varchar
			ps.setInt(5, school.getZip());			//zip intege
			ps.setString(6, school.getWebsite());	
			ps.setString(7, school.getId_tax());	
			
			ps.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public School selectSchool(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		School s = null;

		
		try (Connection conn = ConnectUtil.getConnection()) {
			
			String query = "SELECT * FROM project.school WHERE id_school=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				s = new School(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7),
						rs.getString(8)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<School> selectAllSchools() {
		Statement stmt = null;
		ResultSet rs = null;
		List<School> slist = new ArrayList<School>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.school";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				School s = new School();
				s.setId_school(rs.getInt("id_school"));
				s.setName_school(rs.getString("name_school"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setZip(rs.getInt("zip"));
				s.setWebsite(rs.getString("website"));
				s.setId_tax(rs.getString("id_tax"));
				slist.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public boolean updateSchool(School school) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSchool(School school) {
		// TODO Auto-generated method stub
		return false;
	}

}
