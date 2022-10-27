package com.java.SnakeLadder.model;

import lombok.Data;

import java.util.Random;

@Data
public class Dice {
    private int noOfDice;

    public Dice(int noOfDice){
        this.noOfDice = noOfDice;
    }

    public int rollDice(){
        Random random = new Random();
        return random.nextInt(6*noOfDice);
    }
}
