package com.games.snakesandladders.services;

import com.games.snakesandladders.models.MoveStatus;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GameTest {

    private static final  int START_POSITION = 1;

    @Mock
    private PlayerFactory playerFactory;
    @Mock
    private ProgressChecker progressChecker;
    @Mock
    private Player player;

    private Token token = new Token();
    @Mock
    private Dice dice;

    @InjectMocks
    private Game game;

    @Before
    public void setUp() {
        when(playerFactory.createPlayer()).thenReturn(player);
        when(player.getToken()).thenReturn(token);
        player.setToken(token);
        token.setPosition(START_POSITION);
    }

    @Test
    public void shouldReturnStartedPositionWhenPlayerAddedToGame() {
        Player player = game.addPlayer();
        int expectedResult = 1;

        int tokenPosition = player.getToken().getPosition();

        Assert.assertEquals(expectedResult, tokenPosition);
    }

    @Test
    public void playerMustWinWhenHeReachesTheFinalSquare() {
        int resultOfDiceRoll = 3;
        when(progressChecker.checkMove(any(), anyInt())).thenReturn(MoveStatus.WIN);

        MoveStatus moveStatus = game.checkMoveStatus(player, resultOfDiceRoll);

        Assert.assertEquals(MoveStatus.WIN, moveStatus);
    }

    @Test
    public void shouldGetFourWhenMovedThree() {
        int expectedResult = 4;
        when(dice.roll()).thenReturn(3);
        when(progressChecker.checkMove(any(), anyInt())).thenReturn(MoveStatus.MOVE);
        game.moveToken(player);
        int result = token.getPosition();

        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldGetEightWhenMovedThreeAndFour() {
        int expectedResult = 8;
        when(dice.roll()).thenReturn(3, 4);
        when(progressChecker.checkMove(any(), anyInt())).thenReturn(MoveStatus.MOVE);
        game.moveToken(player);
        game.moveToken(player);

        int result = token.getPosition();
        assertEquals(expectedResult, result);
    }

    @Test
    public void shouldMoveFourSpacesWhenRollIsFour() {
        int expectedResult = 5;
        when(progressChecker.checkMove(any(), anyInt())).thenReturn(MoveStatus.MOVE);
        when(dice.roll()).thenReturn(4);

        game.moveToken(player);

        int result = token.getPosition();
        assertEquals(expectedResult, result);
    }

}
