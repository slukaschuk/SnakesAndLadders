package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTest {

    private Game game = new Game();

    @Test
    public void shouldReturnStartedPositionWhenPlayerAddedToGame() {
        Player player = game.addPlayer();
        int expectedResult = 1;

        int tokenPosition = player.getToken().getPosition();

        Assert.assertEquals(expectedResult, tokenPosition);
    }
}
