package com.java.SnakeLadder;

import com.java.SnakeLadder.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class StartGame {

    private static Scanner s = new Scanner(System.in);

    public static Board initializeBoard(int size) {

        Board board = new Board(size);

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board.getCells()[i][j]= new Cell(new Jump());
            }
        }

        System.out.print("Enter no of Snakes for the board: ");
        int noOfSnakes = s.nextInt();

        System.out.print("Enter no of Ladders for the board: ");
        int noOfLadder = s.nextInt();

        Random random = new Random();
        while(noOfSnakes>0){
            int startCellNo = random.nextInt(size*size);
            int endCellNo = random.nextInt(size*size);
            if(startCellNo<=endCellNo){
                continue;
            }
            Jump jump = new Jump(startCellNo,endCellNo);
            int row = startCellNo/size;
            int col = endCellNo%size;
            board.getCells()[row][col].setJump(jump);
            noOfSnakes--;
        }

        while(noOfLadder>0){
            int startCellNo = random.nextInt(size*size);
            int endCellNo = random.nextInt(size*size);
            if(startCellNo>=endCellNo){
                continue;
            }
            Jump jump = new Jump(startCellNo,endCellNo);
            int row = startCellNo/size;
            int col = startCellNo%size;
            board.getCells()[row][col].setJump(jump);
            noOfLadder--;
        }
        return board;
    }

    public static Deque<Player> playerInput() {
        System.out.print("Enter no of Player: ");
        int noOfPlayers = s.nextInt();
        Deque<Player> players = new LinkedList<>();
        while(noOfPlayers>0){
            System.out.print("Enter player name: ");
            String playerName = s.next();
            System.out.print("Choose your favourite piece color: ");
            String pieceColor = s.next();
            Player player = new Player(playerName,pieceColor,0);
            players.add(player);
            noOfPlayers--;
        }
        return players;

    }

    public static void startGame(Board board, Deque<Player> players, Dice dice) {

        boolean noWinner = true;
        while(noWinner) {
            Player player = players.getFirst();
            System.out.println(player.getName() + " is playing with " + player.getPieceColor() + " color piece");

            int rollNo = dice.rollDice();

            int playerNewPosition = player.getCurrentPosition() + rollNo;

            playerNewPosition = jumpCheck(board,playerNewPosition);

            player.setCurrentPosition(playerNewPosition);

            System.out.println(player.getName() + " new position is " + player.getCurrentPosition());

            if(playerNewPosition>board.getSize()* board.getSize()){
                System.out.println(player.getName() + " with " + player.getPieceColor() +" won the game");
                noWinner=false;
            }
            players.add(player);
        }




    }

    private static int jumpCheck(Board board , int playerNewPosition) {
        if(playerNewPosition>board.getSize() *board.getSize()){
            return playerNewPosition;
        }

        int row = playerNewPosition/board.getSize();
        int col = playerNewPosition%board.getSize();

        Cell cell = board.getCells()[row][col];
        if(cell.getJump()!=null && playerNewPosition == cell.getJump().getStart()){
            System.out.println("Reached on Snake or Ladder");
            int jumpEnd = cell.getJump().getEnd();
            int jumpStart = cell.getJump().getStart();
            if(jumpStart>jumpEnd){
                System.out.print("Jump using ladder: "+jumpEnd);
            }else{
                System.out.print("Jump using snake: "+jumpEnd);
            }
            return jumpEnd;
        }
        return playerNewPosition;
    }
}
