package utils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
public class CommonDatabaseUtility {
  // Get single column value
	    public static String getSingleValue(String query, Object... params) {
	        try {
	            ResultSet rs = DatabaseUtility.executeSelectQuery(query, params);
	            if (rs.next()) {
	                return rs.getString(1); // first column
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException("Failed to fetch single DB value", e);
	        }
	        return null;
	    }

	    // Get multiple column values (single row)
	    public static Map<String, String> getSingleRow(String query, Object... params) {
	        Map<String, String> result = new HashMap<>();
	        try {
	            ResultSet rs = DatabaseUtility.executeSelectQuery(query, params);
	            int columnCount = rs.getMetaData().getColumnCount();
	            if (rs.next()) {
	                for (int i = 1; i <= columnCount; i++) {
	                    result.put(
	                        rs.getMetaData().getColumnLabel(i),
	                        rs.getString(i)
	                    );
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException("Failed to fetch DB row data", e);
	        }
	        return result;
	    }
}




