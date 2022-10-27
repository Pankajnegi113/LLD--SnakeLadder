package com.java.SnakeLadder.model;

import lombok.Data;

@Data
public class Board {
    private int size;
    private Cell[][] cells;

    public Board(int size){
        this.size=size;
        this.cells = new Cell[size][size];
    }
}
