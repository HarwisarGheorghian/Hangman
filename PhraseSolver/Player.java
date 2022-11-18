package PhraseSolver;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    //private int missedCount; 

    public Player(String Name){
        name = Name;
        score = 0;
       // missedCount = 0;
    }

    public void setScore(int scores){
        score = scores;
    }

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    /*public void setMissed(int miss){
        missedCount = miss;
    }

    public int getMissed(){
        return missedCount;
    }*/
    public String guess(){
        Scanner sc = new Scanner(System.in);
        String Guess = sc.nextLine();
        return Guess;    
    }
}
