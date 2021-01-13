package com.games.snakesandladders.services;

import com.games.snakesandladders.models.MoveStatus;
import com.games.snakesandladders.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game {

    private PlayerFactory playerFactory;

    private ProgressChecker progressChecker;

    private Dice dice;

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

    @Autowired
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public MoveStatus checkMoveStatus(Player player, int numberOfMoves) {
        return progressChecker.checkMove(player, numberOfMoves);
    }

    public Player moveToken(Player player) {
        int rollResult = dice.roll();
        MoveStatus moveStatus = checkMoveStatus(player, rollResult);
        if (!moveStatus.equals(MoveStatus.CANNOT_MOVE)) {
            int currentPosition = player.getToken().getPosition();
            player.getToken().setPosition(currentPosition + rollResult);
        }
        return player;
    }
}
