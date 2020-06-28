package sqlClient;

import core.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSqlClient extends SqlClient {

    public static boolean isAuth(User user) {
        String query = String.format("select nickname from users where login='%s' and password='%s'", user.getLogin(), user.getPassword());

        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
