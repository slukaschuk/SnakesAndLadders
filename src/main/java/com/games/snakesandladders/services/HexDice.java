package com.games.snakesandladders.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HexDice implements Dice {

    private final static Integer MIN_VALUE = 1;
    private final static Integer MAX_VALUE = 6;

    @Override
    public Integer roll() {
        return new Random().nextInt((MAX_VALUE - MIN_VALUE) + 1) + MIN_VALUE;
    }
}
