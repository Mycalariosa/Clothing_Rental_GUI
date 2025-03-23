
package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.*;

public class config {
    private Connection connect;

    public config() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbatelier", "root", "");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connect;
    }

    // ✅ Fix: Implement prepareStatement properly
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connect.prepareStatement(sql);
    }

    // Function to insert data
    public int insertData(String sql) {
        int result = 0;
        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted successfully!");
            result = 1;
        } catch (SQLException ex) {
            System.err.println("Insert error: " + ex.getMessage());
        }
        return result;
    }

    // Function to retrieve data
    public ResultSet getData(String sql) throws SQLException {
        Statement stmt = connect.createStatement();
        return stmt.executeQuery(sql);
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (connect != null && !connect.isClosed()) {
                connect.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException ex) {
            System.err.println("Error closing connection: " + ex.getMessage());
        }
    }
}
