package com.games.snakesandladders.models;

import com.games.snakesandladders.services.Dice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PlayerTest {

    private static final int START_POSITION = 1;

    private Token token = new Token();

    @InjectMocks
    private Player player;

    @Mock
    private Dice dice;

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