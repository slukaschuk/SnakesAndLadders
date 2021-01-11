package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Player;
import com.games.snakesandladders.models.Token;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GameTest {

    @Mock
    private PlayerFactory playerFactory;
    @Mock
    private ProgressChecker progressChecker;
    @Mock
    private Player player;
    @Mock
    private Token token;
    @Mock
    private Dice dice;

    @InjectMocks
    private Game game;

    @Before
    public void setUp() {
        when(playerFactory.createPlayer()).thenReturn(player);
        when(player.getToken()).thenReturn(token);

    }

    @Test
    public void shouldReturnStartedPositionWhenPlayerAddedToGame() {
        Player player = game.addPlayer();
        when(token.getPosition()).thenReturn(1);
        int expectedResult = 1;

        int tokenPosition = player.getToken().getPosition();

        Assert.assertEquals(expectedResult, tokenPosition);
    }

    @Test
    public void playerMustWinWhenHeReachesTheFinalSquare() {
        when(token.getPosition()).thenReturn(97);
        int resultOfDiceRoll = 3;
        when(dice.roll()).thenReturn(resultOfDiceRoll);
        player.roll();

        MoveStatus moveStatus = progressChecker.checkMove(player, resultOfDiceRoll);

        Assert.assertEquals(MoveStatus.WIN, moveStatus);

    }

}
