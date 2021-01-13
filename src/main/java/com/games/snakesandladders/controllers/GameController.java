package com.games.snakesandladders.controllers;

import com.games.snakesandladders.models.Player;
import com.games.snakesandladders.services.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private Game game;

    @PostMapping("/player")
    public ResponseEntity<Player> makePlayerMove(@RequestBody Player player) {
        return ResponseEntity.ok(game.moveToken(player));
    }
}
