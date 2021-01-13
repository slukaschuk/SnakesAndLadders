package com.games.snakesandladders.models;

public class JsonApiPlayerData {
    public Player attributes;

    public JsonApiPlayerData() {
    }

    public JsonApiPlayerData(Player attributes) {
        this.attributes = attributes;
    }

    public Player getAttributes() {
        return attributes;
    }

    public void setAttributes(Player attributes) {
        this.attributes = attributes;
    }
}
