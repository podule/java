package ru.podule.lone.circles;

import java.awt.*;

public class Ball extends Sprite {
    private  float vx = (float) (150 + (Math.random()*200f));
    private  float vy = (float) (150 + (Math.random()*200f));

    private final Color color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
    );

    Ball(){
        halfHeight = (float) (20 * Math.random() + 50f);
        halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas gameCanvas, float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
        if(getLeft() < gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }
        if(getRight() > gameCanvas.getRight()){
            setRight(gameCanvas.getRight());
            vx = -vx;
        }
        if(getTop() < gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy = -vy;
        }
        if(getBottom() > gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }
    }

    @Override
    void render(GameCanvas gameCanvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}
