package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtility {

    private static Connection connection;

    // Connect once
    public static void connectToDatabase(String dbURL, String username, String password) {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(dbURL, username, password);
                System.out.println("Database connected successfully!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("DB Connection failed", e);
        }
    }

    // Execute SELECT query
    public static ResultSet executeSelectQuery(String query, Object... params) {
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            return ps.executeQuery();

        } catch (SQLException e) {
            //throw new RuntimeException("DB Select Query failed", e);
        	e.printStackTrace();
        }
		return null;
    }

    // Close connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
