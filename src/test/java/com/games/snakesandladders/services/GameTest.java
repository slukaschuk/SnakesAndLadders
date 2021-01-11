package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private final PlayerFactory playerFactory = new SimplePlayerFactory();

    private Game game = new Game();

    @Before
    public void setUp() {
        game.setPlayerFactory(playerFactory);
    }

    @Test
    public void shouldReturnStartedPositionWhenPlayerAddedToGame() {
        Player player = game.addPlayer();
        int expectedResult = 1;

        int tokenPosition = player.getToken().getPosition();

        Assert.assertEquals(expectedResult, tokenPosition);
    }
}
