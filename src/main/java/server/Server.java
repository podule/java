package server;

import auth.AuthHandler;
import sql.DBHelper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Server {

    private ServerSocket srv;
    private DBHelper helper;
    private static Logger logger = Logger.getLogger(Server.class.getName());

    public DBHelper getHelper() {
        return helper;
    }


    public Server() throws IOException, SQLException {
        srv = new ServerSocket(8189);
        logger.info("server started!");
        helper = new DBHelper();
        helper.connect();
        helper.init();
        Socket socket = null;
        while (true) {
            try {
                socket = srv.accept();
                logger.info("Client accepted!");
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
