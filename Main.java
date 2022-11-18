import java.util.Scanner;
import PhraseSolver.*;
public class Main {
    //static boolean playerHasMissedTooMuch = false;
    //static String loserWhoSkippedTooMuch;
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
        //while(true){ //game loop
            System.out.println("Here is the board!");
            //System.out.println("If you miss more than 5 it's game over!");
            System.out.println(board);
            boolean gameend = false;
            while(!gameend){

                for(int i = 0; i < players.length; i++){ //we need to iterate through all the players somehow
                    if(board.end()){
                        gameend = true;
                        break;
                    } /*else if(players[i].getMissed() >= 5){
                        gameend = true;
                        //playerHasMissedTooMuch = true;
                        //loserWhoSkippedTooMuch = players[i].getName();
                        break;
                    }*/
                    System.out.println(players[i].getName() + ": Call your guess!");
                    String guess = players[i].guess();
                    board.setGuess(guess);
                    System.out.println(board.updateBoard());
                    System.out.println(players[i].getName() + " guessed " + guess + " and got " + board.getCounter() + " points!");

                    /*if(board.getCounter() == 0){
                        players[i].setMissed(i);
                        System.out.println(players[i].getName() + " also missed. They have " + players[i].getMissed() + " misses.");
                    }*/

                    players[i].setScore(players[i].getScore() + board.getCounter());
                }
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

    /*public static void gameEndScreen(){
        if(playerHasMissedTooMuch){
            System.out.println("Uh Oh! " + loserWhoSkippedTooMuch + " had too many wrong guesses. They Lost the Game!")
        }
    }*/

}
