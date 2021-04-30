package postgredataaccessobjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bankerlogin.BankerLogin;
import connectionutility.ConnectionUtility;

public class BankerLoginDAOImplementation implements BankerLoginDAO{
	
	Scanner input = new Scanner(System.in);
	
	String accessLevel;
	
	public BankerLoginDAOImplementation() {}
	
	public BankerLoginDAOImplementation (String accessLevel){
		
		this.accessLevel = accessLevel;
		
	}

	@Override
	public boolean insertIntoBankerLogin() {
		
		System.out.print("Enter a username: ");
		String username = input.nextLine();
		System.out.print("Enter a password: ");
		String password = input.nextLine();
		
		PreparedStatement ps = null;
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
			String query = "INSERT INTO bank_template.banker_login VALUES (DEFAULT,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public BankerLogin selectBankerLogin(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		BankerLogin e = null;
		
		try(Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.banker_login WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			e = new BankerLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
		}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return e;
		}
		
		return e;
		
	}

	@Override
	public List<BankerLogin> selectAllBankerLogin() {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BankerLogin> l = new ArrayList<BankerLogin>();
		
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "SELECT * FROM bank_template.banker_login";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while (rs.next()) {
			
			BankerLogin b = new BankerLogin(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3)
					);
				
				l.add(b);
			
		}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		return l;
		
	}

	@Override
	public BankerLogin updateUsername(Integer id, BankerLogin bl) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new username: ");
		String username = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.banker_login SET login_username = ? WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, username);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return bl;
		}
		
		bl.setUsername(username);
		
		return bl;
		
	}

	@Override
	public BankerLogin updatePassword(Integer id, BankerLogin bl) {
		
		PreparedStatement ps = null;
		
		System.out.print("Enter the new password: ");
		String password = input.nextLine();
				
		try (Connection conn = ConnectionUtility.getConnection(accessLevel)) {
		
		String query = "UPDATE bank_template.banker_login SET login_password = ? WHERE login_id = ?";
		ps = conn.prepareStatement(query);
		ps.setString(1, password);
		ps.setInt(2, id);
		ps.execute();
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			return bl;
		}
		
		bl.setPassword(password);
		
		return bl;
		
	}

	
	
}
