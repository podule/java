package core;

import sqlClient.UserSqlClient;


public class AuthUser {


    private User user;

    public AuthUser(String login, String password) {
        this.user = new User(login, password);
    }

    public boolean auth() {
        return UserSqlClient.isAuth(user);
    }

}
