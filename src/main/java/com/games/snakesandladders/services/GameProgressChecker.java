package com.games.snakesandladders.services;

import com.games.snakesandladders.models.MoveStatus;
import com.games.snakesandladders.models.Player;
import org.springframework.stereotype.Service;

import static com.games.snakesandladders.models.MoveStatus.*;

@Service
public class GameProgressChecker implements ProgressChecker {

    public static final int BOARD_SIZE = 100;

    @Override
    public MoveStatus checkMove(Player player, int numberOfMoves) {
        MoveStatus status = CANNOT_MOVE;
        int tokenPosition = player.getToken().getPosition();
        if (tokenPosition + numberOfMoves == BOARD_SIZE) {
            status = WIN;
        } else if (tokenPosition + numberOfMoves < BOARD_SIZE) {
            status = MOVE;
        }

        return  status;
    }
}
