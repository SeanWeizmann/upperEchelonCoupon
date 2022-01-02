package coupon_project.db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ConnectionPool {
    private static final int NUM_OF_CONS = DataBaseManager.MAX_CONNECTION;
    private static ConnectionPool instance = null;
    private final Stack<Connection> connections = new Stack<>();

    private ConnectionPool() throws SQLException {
        //open all connections
        openAllConnections();
    }

    public static ConnectionPool getInstance() {
        //before locking the critical code...
        if (instance == null) {
            //create the connection pool
            synchronized (ConnectionPool.class) {
                //before creating the code.....
                if (instance == null) {
                    try {
                        instance = new ConnectionPool();
                    } catch (SQLException throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException {
        synchronized (connections) {
            if (connections.isEmpty()) {
                //wait until we will get a connection back
                connections.wait();
            }
            return connections.pop();
        }
    }

    public void returnConnection(Connection connection) {
        synchronized (connections) {
            connections.push(connection);
            //notify that we got back a connection from the user...
            connections.notify();
        }
    }

    /*
        this method will open 10 connection in advanced
        @throws SQLException
     */

    private void openAllConnections() throws SQLException {
        for (int index = 0; index < NUM_OF_CONS; index += 1) {
            Connection connection = DriverManager.getConnection(DataBaseManager.URL, DataBaseManager.USER_NAME, DataBaseManager.USER_PASS);
            connections.push(connection);
        }
    }

    public void closeAllConnection() throws InterruptedException {
        synchronized (connections) {
            while (connections.size() < NUM_OF_CONS) {
                connections.wait();
            }
            connections.removeAllElements();
        }
    }
}
