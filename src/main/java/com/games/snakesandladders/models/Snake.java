package com.games.snakesandladders.models;

public class Snake {
    private int tale;
    private int head;

    public Snake(int tale, int head) {
        this.tale = tale;
        this.head = head;
    }

    public int getTale() {
        return tale;
    }

    public void setTale(int tale) {
        this.tale = tale;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }
}
