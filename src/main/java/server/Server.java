package server;

import auth.AuthHandler;
import sql.DBHelper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {

    private ServerSocket srv;
    private DBHelper helper;

    public DBHelper getHelper() {
        return helper;
    }


    public Server() throws IOException, SQLException {
        srv = new ServerSocket(8189);
        System.out.println("server started!");
        helper = new DBHelper();
        helper.connect();
        helper.init();
        Socket socket = null;
        while (true) {
            try {
                socket = srv.accept();
                System.out.println("Client accepted!");
                AuthHandler handler = new AuthHandler(this, socket);
                new Thread(handler).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        new Server();
    }

}
