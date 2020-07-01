package chat;

import models.MessagesHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame implements Thread.UncaughtExceptionHandler, ActionListener {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;
    private  final JTextArea log = new JTextArea();
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private static MessagesHistory messagesHistory;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Chat();
            }
        });

         messagesHistory = new MessagesHistory();
    }

    public Chat() throws HeadlessException {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat");

        JScrollPane scrollLog = new JScrollPane(log);
        scrollLog.setPreferredSize(new Dimension(100, 0));


        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        btnSend.addActionListener(this);
        tfMessage.addActionListener(this);
        showHistoryChat();

        add(panelBottom, BorderLayout.SOUTH);
        add(scrollLog, BorderLayout.CENTER);

        setVisible(true);
    }

    private void showHistoryChat() {
        log.append(messagesHistory.getLastMessages());
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnSend || src == tfMessage){
            sendMessage();
        } else {
            throw new RuntimeException("Unknown sourse");
        }
    }

    private void sendMessage() {
        String msg = tfMessage.getText();
        if(!msg.equals("")){
            messagesHistory.readMessageHistory(msg);
            tfMessage.setText("");
            tfMessage.requestFocusInWindow();
            socketThread.sendMessage(msg);
        }
    }
}
