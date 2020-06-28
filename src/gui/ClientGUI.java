package gui;


import core.AuthUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private static final String STR_TITLE = "Chat Client";

    private final String tfIPAddress = "127.0.0.1"; //85.172.91.187
    private final String tfPort = "8189";

    private final JPanel panel = new JPanel(new GridLayout(4, 1));
    private final JTextField tfLogin = new JTextField("");
    private final JPasswordField tfPassword = new JPasswordField("");
    private final JButton btnLogin = new JButton("Login");
    private final JTextArea log = new JTextArea("Введите логин и пароль");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });


    }

    private ClientGUI() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle(STR_TITLE);

        panel.add(tfLogin);
        panel.add(tfPassword);
        panel.add(btnLogin);
        panel.add(log);

        btnLogin.addActionListener(this);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnLogin) {
            connect();
        } else {
            throw new RuntimeException("Unknown sourse");
        }
    }

    private void connect() {
        Socket socket = null;
        try {
            socket = new Socket(tfIPAddress, Integer.parseInt(tfPort));
        } catch (IOException e) {
            showException(e);
            return;
        }
        socketThread = new SocketThread(this, "Client", socket);
    }


    @Override
    public void onSocketThreadStart(SocketThread thread, Socket socket) {

    }

    @Override
    public void onSocketThreadStop(SocketThread thread) {
    }

    @Override
    public void onReseiveString(SocketThread thread, Socket socket, String msg) {

        // вызывается из SocketThread который обрабатывает DataInputStream
        String[] arr = msg.split(Library.DELIMITER);

        String login = arr[0];
        String password = arr[1];
        AuthUser authUser = new AuthUser(login, password);
        if (authUser.auth()) {
            // переход в полный функционал чата
        } else {
            log.setText("Неверные логин и пароль");
        }
    }

    @Override
    public void onSocketReady(SocketThread thread, Socket socket) {
        String login = tfLogin.getText();
        String pass = new String(tfPassword.getPassword());
        thread.sendAuth(login + Library.DELIMITER + pass); // обрабатывается out.writeUTF(msg);
    }

    @Override
    public void onSocketThreadException(SocketThread thread, Exception e) {

    }

}
