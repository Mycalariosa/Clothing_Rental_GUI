package config;

import java.sql.*;

public class config {
    public Connection connect;

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

    // Prepare statements properly
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        if (connect != null) {
            return connect.prepareStatement(sql);
        } else {
            throw new SQLException("Database connection is not established.");
        }
    }

    // Insert data safely with parameters
    public int insertData(String sql, Object... params) {
        int result = 0;
        try (PreparedStatement pst = prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            result = pst.executeUpdate();
            System.out.println("Inserted successfully!");
        } catch (SQLException ex) {
            System.err.println("Insert error: " + ex.getMessage());
        }
        return result;
    }

    // Retrieve data safely
    public ResultSet getData(String sql, Object... params) throws SQLException {
        PreparedStatement pst = prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            pst.setObject(i + 1, params[i]);
        }
        return pst.executeQuery();
    }

    // Close connection method
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

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
}
