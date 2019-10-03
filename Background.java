package ru.podule.lone.circles;

import java.awt.*;

public class Background {

    private Color color;
    private boolean isDarkening = true;

    public Background() {
        color = new Color(
            (int)(Math.random() * 255),
            (int)(Math.random() * 255),
            (int)(Math.random() * 255)
        );
    }

    public Color setColorCanvas(){

        if(color.toString().equals(Color.BLACK.toString())){
            isDarkening = false;
        }
        if(color.toString().equals(Color.WHITE.toString())){
            isDarkening = true;
        }
        return (isDarkening) ? color.darker(): color.brighter();

    }

    public Color getBackColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
