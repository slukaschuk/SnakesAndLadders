package com.games.snakesandladders.services;

import com.games.snakesandladders.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Game {

    @Autowired
    PlayerFactory playerFactory;

    public Player addPlayer() {
        return playerFactory.createPlayer();
    }

}
