package com.games.snakesandladders.services;

import com.games.snakesandladders.models.MoveStatus;
import com.games.snakesandladders.models.Player;
import com.games.snakesandladders.models.Token;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class GameProgressCheckerTest {

    @Mock
    private Player player;
    @Mock
    private Token token;
    @Mock
    private Dice dice;

    @InjectMocks
    private GameProgressChecker progressChecker;

    @Test
    public void playerMustWinWhenHeReachesTheFinalSquare() {
        when(player.getToken()).thenReturn(token);
        when(token.getPosition()).thenReturn(97);
        int resultOfDiceRoll = 3;
        when(dice.roll()).thenReturn(resultOfDiceRoll);
        player.roll();

        MoveStatus moveStatus = progressChecker.checkMove(player, resultOfDiceRoll);

        assertEquals(MoveStatus.WIN, moveStatus);
    }

    @Test
    public void playerMustStayInPlaceWhenHeExceedsTheBoardLimit() {
        when(player.getToken()).thenReturn(token);
        when(token.getPosition()).thenReturn(97);
        int resultOfDiceRoll = 4;
        when(dice.roll()).thenReturn(resultOfDiceRoll);
        player.roll();

        MoveStatus moveStatus = progressChecker.checkMove(player, resultOfDiceRoll);

        assertEquals(MoveStatus.CANNOT_MOVE, moveStatus);
    }

}