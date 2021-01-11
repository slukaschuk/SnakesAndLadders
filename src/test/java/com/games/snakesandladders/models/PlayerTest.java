package com.games.snakesandladders.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerTest {

    @Mock
    private Token token;

    @InjectMocks
    private Player player;

    @Captor
    ArgumentCaptor<Integer> tokenPositionCaptor;

    @Test
    public void shouldGetFourWhenMovedThree() {
        when(token.getPosition()).thenReturn(1);
        Integer expectedResult = 4;

        player.moveToken(3);
        verify(token).setPosition(tokenPositionCaptor.capture());

        Assert.assertEquals(expectedResult, tokenPositionCaptor.getValue());
    }
}