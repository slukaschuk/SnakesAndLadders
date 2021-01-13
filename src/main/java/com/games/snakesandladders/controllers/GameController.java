package com.games.snakesandladders.controllers;

import com.games.snakesandladders.models.JsonApiPlayerData;
import com.games.snakesandladders.models.JsonApiPlayerPayload;
import com.games.snakesandladders.models.Player;
import com.games.snakesandladders.services.Game;
import org.springframework.beans.factory.annotation.Autowired;
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
    public JsonApiPlayerPayload makePlayerMove(@RequestBody JsonApiPlayerPayload jsonApiPlayerPayload) {
        Player player = jsonApiPlayerPayload.getData().getAttributes();
        return new JsonApiPlayerPayload(new JsonApiPlayerData(game.moveToken(player)));
    }
}
