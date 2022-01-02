package coupon_project.db_util;

//import com.mysql.cj.protocol.Resultset;



import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DataBaseUtil {

    private static Connection connection;

    public static void runQuery(String query){
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException | InterruptedException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    public static void runQuery(String query, Map<Integer, Object> params){
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            params.forEach((key, value) -> {
                try {
                    if (value instanceof Integer) {
                        statement.setInt(key, (Integer) value);
                    } else if (value instanceof String) {
                        statement.setString(key, String.valueOf(value));
                    } else if (value instanceof Date) {
                        statement.setDate(key, (Date) value);
                    } else if (value instanceof Double) {
                        statement.setDouble(key, (Double) value);
                    } else if (value instanceof Boolean) {
                        statement.setBoolean(key, (Boolean) value);
                    } else if (value instanceof Float) {
                        statement.setFloat(key, (Float) value);
                    }
                } catch (SQLException err) {
                    System.out.println(err.getMessage());
                }

            });
            statement.execute();
        } catch (SQLException | InterruptedException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
    }

    public static ResultSet runQueryForResult(String query){
        ResultSet resultset = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            resultset = (ResultSet) statement.executeQuery();
        } catch (SQLException | InterruptedException err) {
            System.out.println(err.getMessage());
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
        }
        return resultset;
    }
}
