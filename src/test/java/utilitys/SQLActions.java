package utilitys;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
 * SQL Actions
 */
public class SQLActions {
    private String connectionUrl;

    public SQLActions() {
        //TODO Connection information should recover from a config file.
        connectionUrl =
                  "jdbc:sqlserver://url;"
                + "database=DTBase;"
                + "user=UserName;"
                + "password=Password;"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";
    }

    /**
     * Get one row of data from database
     * @param SQLQuery SQL Query
     * @return Data recover from database. Can deal with only one row
     */
    public List<Map<String, Object>> getDataFromTable(String SQLQuery) {
        ResultSet resultSet;
        List<Map<String, Object>> rows = new ArrayList<>();
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(this.connectionUrl);
            Statement statement = conn.createStatement();

            // Create and execute a SELECT SQL statement.
            resultSet = statement.executeQuery(SQLQuery);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            // Recover data from the database.
            while(resultSet.next())
            {
                // Represent a row in DB. Key: Column name, Value: Column value
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    // Note that the index is 1-based
                    String colName = resultSetMetaData.getColumnName(i);
                    Object colVal = resultSet.getObject(i);
                    row.put(colName, colVal);
                }
                rows.add(row);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally {
            if (conn != null)
            {
                try
                {
                    conn.close ();
                }
                catch (Exception ex)
                {
                    System.out.println ("Error in connection termination!");
                }
            }
        }

        return rows;
    }
}
