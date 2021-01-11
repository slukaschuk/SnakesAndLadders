package com.games.snakesandladders.models;

import com.games.snakesandladders.services.Dice;
import org.springframework.beans.factory.annotation.Autowired;

public class Player {

    private Token token;

    private Dice dice;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Autowired
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void moveToken(int spaces) {
        int currentPosition = token.getPosition();
        token.setPosition(currentPosition + spaces);
    }

    public int roll() {
        return dice.roll();
    }
}
