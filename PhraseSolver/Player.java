package PhraseSolver;

public class Player {
    private String name;
    private int score;

    public Player(String Name){
        name = Name;
        score = 0;
    }nn,n

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
}
