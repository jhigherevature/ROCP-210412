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
import model.Employee;

public class AccountDAOImpl implements AccountDAO{
	
	@Override
	public boolean insertIntoAccount(Account account) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "INSERT INTO project.employee VALUES (null,?,?)";
			ps = conn.prepareStatement(query);
//			ps.setInt(1, account.getId_account());
			ps.setString(2, account.getStatus());
			ps.setString(3, account.getTax_filing_status());
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
	public List<Account> selectAllAccount() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> alist = new ArrayList<Account>();
		
		try (Connection conn = ConnectUtil.getConnection()) {
			String query = "SELECT * FROM project.account";
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
	
}
