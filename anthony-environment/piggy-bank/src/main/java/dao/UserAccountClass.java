package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connection.Utility;
import model.UserAccount;

public class UserAccountClass implements UserAccountInterface {
    @Override
    public boolean insertIntoUsers(UserAccount user) {
        PreparedStatement ps = null;
        try (Connection conn = Utility.connect()) {
            String query = "INSERT INTO piggybank.useraccounts VALUES (DEFAULT,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassHash());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserAccount selectUser(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserAccount user = null;

        try (Connection conn = Utility.connect()) {
            String query = "SELECT * FROM piggybank.useraccounts WHERE email=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UserAccount> selectAllUsers() {
        Statement st = null;
        ResultSet rs = null;
        List<UserAccount> users = new ArrayList<UserAccount>();

        try (Connection conn = Utility.connect()) {
            String query = "SELECT * FROM piggybank.useraccounts";
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                UserAccount user = new UserAccount();
                user.setUid(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassHash(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setStatus(rs.getString(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean updateUser(UserAccount user) {
        PreparedStatement ps = null;
        Boolean result = null;
        try (Connection conn = Utility.connect()) {
            String query = "UPDATE piggybank.useraccounts SET \"email\"=?, \"passHash\"=?, \"firstName\"=?, \"lastName\"=?, \"status\"=? WHERE \"uid\"=?";
            ps = conn.prepareStatement(query);

            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassHash());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getStatus());
            ps.setInt(6, user.getUid());

            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteUser(UserAccount user) {
        PreparedStatement ps = null;
        Boolean result = null;
        try (Connection conn = Utility.connect()) {
            String query = "DELETE FROM piggybank.useraccounts WHERE uid=?";
            ps = conn.prepareStatement(query);

            ps.setInt(1, user.getUid());

            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public UserAccount selectUserByUid(Integer uid) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserAccount user = null;

        try (Connection conn = Utility.connect()) {
            String query = "SELECT * FROM piggybank.useraccounts WHERE uid=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
