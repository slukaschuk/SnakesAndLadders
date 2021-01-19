package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Snake;
import com.games.snakesandladders.models.Token;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnakeChecker implements PositionChecker {

    @Override
    public int checkPosition(List<Snake> snakes, Token token) {
        int currentPosition = token.getPosition();
        int finalCurrentPosition = currentPosition;
        Optional<Snake> snake = snakes.stream()
                .filter(s -> checkHeadPosition(s, finalCurrentPosition))
                .findFirst();
        if (snake.isPresent()) {
            currentPosition = snake.get().getTale();
        }
        return currentPosition;
    }


    private boolean checkHeadPosition(Snake s, int currentPosition) {
        boolean result = false;
        if (s.getHead() == currentPosition) {
            result = true;
        }
        return result;
    }
}
