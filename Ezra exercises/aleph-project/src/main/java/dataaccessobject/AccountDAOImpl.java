package dataaccessobject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectutil.ConnectUtil;
import model.Account;
import model.Donor;

public class AccountDAOImpl implements AccountDAO{
	
	@Override
	public boolean insertIntoAccount(Account account) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "INSERT INTO project.account VALUES (null,?,?)";
			ps = conn.prepareStatement(query);
//			ps.setInt(1, account.getId_account());
			ps.setString(1, account.getStatus());
			ps.setString(2, account.getTax_filing_status());
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean insertIntoAccount(int account_id, String tfs) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "INSERT INTO project.account VALUES ("+account_id+",'unconfirmed', '"+tfs+"');";
			ps = conn.prepareStatement(query);
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public Account selectAccount(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.account WHERE id_account=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				account = new Account(
						rs.getInt("id_account"),
						rs.getString("Status"),
						rs.getString("Tax_filing_status")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	@Override
	public List<Account> selectAllAccounts() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> alist = new ArrayList<Account>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.account;";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Account account = new Account();
	
				account.setId_account(rs.getInt("id_account"));
				account.setStatus(rs.getString("status"));
				account.setTax_filing_status(rs.getString("Tax_filing_status"));
			
				alist.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alist;
	}
	
	@Override
	public List<Account> selectAllActiveAccounts() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> alist = new ArrayList<Account>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.account WHERE status='confirmed';";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Account account = new Account();
	
				account.setId_account(rs.getInt("id_account"));
				account.setStatus(rs.getString("status"));
				account.setTax_filing_status(rs.getString("Tax_filing_status"));
			
				alist.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alist;
	}
	
	@Override
	public List<Account> selectAllInactiveAccounts() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> alist = new ArrayList<Account>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.account WHERE status='unconfirmed';";
			stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Account account = new Account();
	
				account.setId_account(rs.getInt("id_account"));
				account.setStatus(rs.getString("status"));
				account.setTax_filing_status(rs.getString("Tax_filing_status"));
			
				alist.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return alist;
	}
	
	@Override
	public int selectAccount() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Account account = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.account ORDER BY id_account DESC LIMIT 1";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				account = new Account(
						rs.getInt("id_account"),
						rs.getString("Status"),
						rs.getString("Tax_filing_status")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account.getId_account();
	}
	@Override
	public List<Donor> selectDonorbyAccount(Integer id_account) {
		PreparedStatement ps = null;
//		Statement stmt = null;
		ResultSet rs = null;
		List<Donor> dlist = new ArrayList<Donor>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.donor WHERE id_account=?";
//			stmt = conn.createStatement();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id_account);
			
			rs = ps.executeQuery();
			
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
	public boolean EditAccount(Account account) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "UPDATE project.account SET status=? , tax_filing_status =? WHERE id_account =? ;";
			ps = conn.prepareStatement(query);
			ps.setInt(3, account.getId_account());
			ps.setString(1, account.getStatus());
			ps.setString(2, account.getTax_filing_status());
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public int getAccountActiveNumber() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer x = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT count(status) FROM project.account WHERE status = 'confirmed';";
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
	public int getAccountInactiveNumber() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer x = null;
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT count(status) FROM project.account WHERE status = 'unconfirmed';";
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
