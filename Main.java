import java.util.Scanner;
import PhraseSolver.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many players will be playing?");
        int playerCount = sc.nextInt();
        Player[] players = new Player[playerCount];
        for(int i = 0; i < playerCount; i++){
            System.out.println("What is your name Player " + i);
            String name = sc.nextLine();
            players[i] = new Player(name);
        }

        
    }
}
