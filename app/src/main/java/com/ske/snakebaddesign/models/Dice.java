package com.ske.snakebaddesign.models;

import java.util.Random;

/**
 * Created by Chinthiti Wisetsombat on 17-Mar-16.
 */
public class Dice {

    private final int FACES = 6;
    private int numberOfDice;
    private int maxValue;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
        maxValue = numberOfDice * FACES;
    }

    public int roll(){
        return 1 + new Random().nextInt(maxValue);
    }
}
