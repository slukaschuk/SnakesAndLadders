package com.games.snakesandladders.models;

import com.games.snakesandladders.services.Dice;
import com.games.snakesandladders.services.HexDice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private static final int START_POSITION = 1;

    private final Token token = new Token();

    private final Player player = new Player();

    private final Dice dice = new HexDice();

    @Before
    public void setUp() {
        player.setToken(token);
        token.setPosition(START_POSITION);
    }

    @Test
    public void shouldGetFourWhenMovedThree() {
        int expectedResult = 4;

        player.moveToken(3);
        int result = token.getPosition();

        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldGetEightWhenMovedThreeAndFour() {
        int expectedResult = 8;

        player.moveToken(3);
        player.moveToken(4);

        int result = token.getPosition();
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldMoveFourSpacesWhenRollIsFour() {
        int expectedResult = 5;
        when(dice.roll()).thenReturn(4);

        Integer dieRoll = player.roll();
        player.moveToken(dieRoll);

        int result = token.getPosition();
        assertEquals(expectedResult, result);
    }
}