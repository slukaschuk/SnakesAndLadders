package com.games.snakesandladders.services;

import com.games.snakesandladders.models.MoveStatus;
import com.games.snakesandladders.models.Player;

public interface ProgressChecker {

    MoveStatus checkMove(Player player, int numberOfMoves);
}
