package com.games.snakesandladders.models;

public class JsonApiPlayerPayload {
    public JsonApiPlayerData data;

    public JsonApiPlayerPayload() {
    }

    public JsonApiPlayerPayload(JsonApiPlayerData data) {
        this.data = data;
    }

    public JsonApiPlayerData getData() {
        return data;
    }

    public void setData(JsonApiPlayerData data) {
        this.data = data;
    }
}
