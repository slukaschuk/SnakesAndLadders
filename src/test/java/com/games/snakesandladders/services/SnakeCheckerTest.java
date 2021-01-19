package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Snake;
import com.games.snakesandladders.models.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SnakeCheckerTest {

    private SnakeChecker snakeChecker = new SnakeChecker();
    private List<Snake> snakes;

    @BeforeEach
    public void setUp() {
        Snake snakeOne = new Snake(2, 12);
        Snake snakeTwo = new Snake(10, 20);
        snakes = new ArrayList<>();
        snakes.add(snakeOne);
        snakes.add(snakeTwo);
    }

    @Test
    public void playerShouldGoToTwoSquareWhenStandOnHeadOfSnakesInTwelveSquare() {
        Token token = new Token();
        token.setPosition(12);
        int expectedPosition = 2;

        int position = snakeChecker.checkPosition(snakes, token);

        assertEquals(expectedPosition, position);
    }

    @Test
    public void playerShouldStayOnSquareNumberTwoWhenStandOnTailOfSnakes() {
        Token token = new Token();
        token.setPosition(12);
        int expectedPosition = 2;

        int position = snakeChecker.checkPosition(snakes, token);

        assertEquals(expectedPosition, position);
    }

    @Test
    public void playerShouldGoToSquareNumber10WhenStandOnHeadOfSnakesInTwentySquare() {
        Token token = new Token();
        token.setPosition(20);
        int expectedPosition = 10;

        int position = snakeChecker.checkPosition(snakes, token);

        assertEquals(expectedPosition, position);
    }


}
