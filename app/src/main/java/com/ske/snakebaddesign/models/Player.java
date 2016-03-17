package com.ske.snakebaddesign.models;

/**
 * Created by Chinthiti Wisetsombat on 17-Mar-16.
 */
public class Player {

    private String name;
    private int position, color;

    public Player (String name, int color){
        this.name = name;
        this.color = color;
        this.position = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void move(int value){
        position += value;

    }
}
