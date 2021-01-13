package com.games.snakesandladders.models;

public class JsonApiPlayerData {
    public Player player;

    public JsonApiPlayerData() {
    }

    public JsonApiPlayerData(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
