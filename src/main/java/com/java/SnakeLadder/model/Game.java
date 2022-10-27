package com.java.SnakeLadder.model;

import lombok.Data;

import java.util.Deque;

@Data
public class Game {
    private Deque<Player>players;
    private Board board;
    private Dice dice;
}
