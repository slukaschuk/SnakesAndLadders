package com.games.snakesandladders.services;

import java.util.Random;

public class HexDice implements Dice {

    private final static Integer MIN_VALUE = 1;
    private final static Integer MAX_VALUE = 6;

    @Override
    public Integer roll() {
        return new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
    }
}
