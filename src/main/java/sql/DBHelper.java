package sql;

import models.User;
import org.sqlite.JDBC;

import java.sql.*;

public class DBHelper {

    private Statement stmt;
    private Connection conn;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(JDBC.PREFIX + "chat");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(User user) throws SQLException {
        String insertQuery = String.format("insert into users values('%s', '%s');",
                user.getLogin(), user.getPassword());
        stmt.execute(insertQuery);
    }

    public void delete(int userId) {
    }

    public void init() throws SQLException {
        String createTable = "create table if not exists users(id INTEGER, login TEXT, password TEXT);";
        stmt.execute(createTable);
    }

    public void update(User user) {

    }

    public User select(String login) throws SQLException {
        String query = String.format("select * from users where login = '%s';", login);
        ResultSet rs = stmt.executeQuery(query);
        User user = null;
        while (rs.next()) {
            String password = rs.getString("password");
            user = new User(login, password);
        }
        return user;
    }
}
