package com.java.SnakeLadder;

import com.java.SnakeLadder.model.Board;
import com.java.SnakeLadder.model.Dice;
import com.java.SnakeLadder.model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

@SpringBootApplication
public class SnakeLadderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SnakeLadderApplication.class, args);
		Scanner s = new Scanner(System.in);
		System.out.print("Enter Board Size: ");
		int size = s.nextInt();
		Board board = StartGame.initializeBoard(size);
		System.out.print("Enter no of dice with which want you play game: ");
		int noOfDices = s.nextInt();
		Dice dice = new Dice(noOfDices);
		Deque<Player> players = StartGame.playerInput();
		StartGame.startGame(board,players,dice);

	}

}
