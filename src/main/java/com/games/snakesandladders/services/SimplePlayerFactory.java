package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Player;
import com.games.snakesandladders.models.Token;
import org.springframework.stereotype.Service;

@Service
public class SimplePlayerFactory implements PlayerFactory {

    @Override
    public Player createPlayer() {
        Token token = new Token();
        Player addedPlayer = new Player();
        addedPlayer.setToken(token);
        return addedPlayer;
    }
}
