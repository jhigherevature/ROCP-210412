package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.Network;
import model.User;

public class Users {
    public boolean insertIntoUsers(User user) {
        PreparedStatement ps = null;
        try (Connection conn = Network.connect()) {
            String query = "INSERT INTO piggybank.users VALUES (DEFAULT,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassHash());
            ps.setString(3, user.getPassSalt());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setString(6, user.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public User selectUser(String email) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try (Connection conn = Network.connect()) {
            String query = "SELECT * FROM piggybank.users WHERE email=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers() {
        Statement st = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();

        try (Connection conn = Network.connect()) {
            String query = "SELECT * FROM piggybank.users";
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setPassHash(rs.getString(3));
                user.setPassSalt(rs.getString(4));
                user.setFirstName(rs.getString(5));
                user.setLastName(rs.getString(6));
                user.setStatus(rs.getString(7));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean updateUser(User user) {
        PreparedStatement ps = null;
        Boolean result = null;
        try (Connection conn = Network.connect()) {
            String query = "UPDATE piggybank.users SET email=?, pass_hash=?, first_name=?, last_name=?, status=? WHERE id=?";
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

    public boolean deleteUser(User user) {
        PreparedStatement ps = null;
        Boolean result = null;
        try (Connection conn = Network.connect()) {
            String query = "DELETE FROM piggybank.users WHERE id=?";
            ps = conn.prepareStatement(query);

            ps.setInt(1, user.getUid());

            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User selectUserByUid(Integer uid) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try (Connection conn = Network.connect()) {
            String query = "SELECT * FROM piggybank.users WHERE id=?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
