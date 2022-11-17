import java.util.Scanner;
import PhraseSolver.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players will be playing?");
        int playerCount = sc.nextInt();
        Player[] players = new Player[playerCount]; 
        for(int i = 1; i <= playerCount; i++){
            System.out.println("What is your name Player " + i);
            String name = sc.next();

            players[i - 1] = new Player(name);
        }


        Board board = new Board();
        while(true){ //game loop
            System.out.println("Here is the board!");
            System.out.println(board);
            for(int i = 0; i < players.length; i++){ //we need to iterate through all the players somehow
                if(board.end()){
                    break;
                }
                System.out.println(players[i].getName() + ": Call your guess!");
                String guess = players[i].guess();
                board.setGuess(guess);
                System.out.println(board);
                System.out.println(players[i].getName() + " guessed " + guess + " and got " + board.getCounter() + " points!");
                players[i].setScore(players[i].getScore() + board.getCounter());
            }
            System.out.println("Final Score: ");
            int max = 0;
            String winner = "";
            for(int i = 0; i < players.length; i++){
                System.out.println(players[i].getName() + ": " + players[i].getScore());
                if(players[i].getScore() > max){
                    max = players[i].getScore();
                    winner = players[i].getName();
                }
            }
            System.out.println("The winner is " + winner);

        }        
    }

}
