package com.example.challenge.javaspringdiceroller.controllers;

import java.util.Random;

public class Dice{
    private int rolledValue;

    public Dice(){
        this.rolledValue = randomNumber();
    }
    private int randomNumber(){
        Random random = new Random();
        int intRoll = random.nextInt(6) + 1;
        return intRoll;
    }
    public int getRolledValue(){
        return this.rolledValue;
    }
}
