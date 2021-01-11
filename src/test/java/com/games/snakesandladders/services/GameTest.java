package com.games.snakesandladders.services;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTest {

    @Mock
    private Player firstPlayer;

    @Mock
    private Token token;

    @InjectMocks
    private Game game;

    public void shouldReturnStartedPositionWhenPlayerAddedToGame() {
        when(game.addPlayer()).thenReturn(firstPlayer);
        when(firstPlayer.getToken()).thenReturn(token);
        int expectedResult = 0;

        int tokenPosition = token.getPositionOnBoard();

        Assert.assertEquals(expectedResult, tokenPosition);
    }
}
