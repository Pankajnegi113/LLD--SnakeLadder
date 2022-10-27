package com.java.SnakeLadder.model;

import lombok.Data;

@Data
public class Player {
    private String name;
    private String pieceColor;
    private int currentPosition;

    public Player(String name, String pieceColor, int currentPosition) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.currentPosition = currentPosition;
    }
}
