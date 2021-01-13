package com.games.snakesandladders.services;

import com.games.snakesandladders.models.MoveStatus;
import com.games.snakesandladders.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game {

    private PlayerFactory playerFactory;

    private ProgressChecker progressChecker;

    public Player addPlayer() {
        return playerFactory.createPlayer();
    }

    @Autowired
    public void setPlayerFactory(PlayerFactory playerFactory) {
        this.playerFactory = playerFactory;
    }

    @Autowired
    public void setProgressChecker(ProgressChecker progressChecker) {
        this.progressChecker = progressChecker;
    }

    public MoveStatus checkMoveStatus(Player player, int numberOfMoves) {
        return progressChecker.checkMove(player, numberOfMoves);
    }

    public Player moveToken(Player player, int numberOfMoves) {
        int currentPosition = player.getToken().getPosition();
        player.getToken().setPosition(currentPosition + numberOfMoves);
        return player;
    }
}
