package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Snake;
import com.games.snakesandladders.models.Token;

import java.util.List;

public interface PositionChecker {

    int checkPosition(List<Snake> snakes, Token token);
}
