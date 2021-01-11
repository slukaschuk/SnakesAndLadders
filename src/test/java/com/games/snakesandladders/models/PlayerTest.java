package com.games.snakesandladders.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlayerTest {

    @Mock
    Token token;

    @InjectMocks
    Player player;

    @Test
    public void shouldGetFourWhenMovedThree() {
        when(player.getToken()).thenReturn(token);
        token.setPosition(1);
        int expectedResult = 4;

        player.moveToken(3);
        int tokenPosition = player.getToken().getPosition();

        Assert.assertEquals(expectedResult, tokenPosition);
    }
}