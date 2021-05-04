package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String pass = "Hamster01";
        return DriverManager.getConnection(url, user, pass);
    }

    public static void main(String[] args) {
        try (Connection conn = Utility.connect()) {
            System.out.println("Successful connection!");
        } catch (SQLException e) {
            System.out.println("Failed connection!");
            e.printStackTrace();
        }
    }
}
