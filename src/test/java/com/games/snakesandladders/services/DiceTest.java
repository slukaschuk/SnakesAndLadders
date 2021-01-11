package com.games.snakesandladders.services;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiceTest {

    private final static Integer MIN_VALUE = 1;
    private final static Integer MAX_VALUE = 6;

    private Dice dice = new HexDice();


    @Test
    public void shouldReturnBetweenOneAndSixWhenRoll() {
        Integer result = dice.roll();

        assertTrue("The result is too high", result > MAX_VALUE);
        assertTrue("The result is too low",  result < MIN_VALUE);
    }

}
