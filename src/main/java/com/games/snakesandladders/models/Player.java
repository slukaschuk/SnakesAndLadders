package com.games.snakesandladders.models;

public class Player {

    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void moveToken(int spaces) {
        int currentPosition = token.getPosition();
        token.setPosition(currentPosition + spaces);
    }
}
