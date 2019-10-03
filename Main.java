package ru.podule.lone.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class Main extends JFrame {

    private static final int POS_X = 600;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    Sprite[] sprites = new Sprite[10];


    private Background background = new Background();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });


    }

    private Main() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");


        GameCanvas gameCanvas = new GameCanvas(this);

        gameCanvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                sprites = Arrays.copyOf(sprites, sprites.length+1);
                sprites[sprites.length-1] = new Ball();
            }
        });

        add(gameCanvas, BorderLayout.CENTER);
        initApplication();

        setVisible(true);
    }

    private void initApplication() {
        System.out.println("ball");
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas gameCanvas, Graphics g, float deltaTime){
        background.setColor(background.setColorCanvas());
        gameCanvas.setBackground(background.getBackColor());
        update(gameCanvas, deltaTime);
        render(gameCanvas, g);
    }

    private void update(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++){
            sprites[i].update(gameCanvas, deltaTime);
        }
    }

    private void render(GameCanvas gameCanvas, Graphics g){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(gameCanvas, g);
        }

    }
}
