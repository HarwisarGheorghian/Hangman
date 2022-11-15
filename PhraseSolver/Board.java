package PhraseSolver;
import java.util.Scanner;
import java.io.File;
public class Board{

  String word = loadPhrase(); 
  int guessedCount;
  private String guessCharacter;


  public Board(){
    
  }

  public void setGuess(String guess){
    guessCharacter = guess;
  }

  public String getGuess(){
    return guessCharacter;
  }

  private String loadPhrase(){
      String tempPhrase = "";
    
      int numOfLines = 0;
      tempPhrase = "how are you";
    
      try 
      {
      
        Scanner sc = new Scanner(new File("/workspace/Hangman/PhraseSolver/phrases.txt"));
        while (sc.hasNextLine())
        {
          tempPhrase = sc.nextLine().trim();
          numOfLines++;
        }
      } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		  int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
      try 
      {
        int count = 0;
        Scanner sc = new Scanner(new File("/workspace/Hangman/PhraseSolver/phrases.txt"));
        while (sc.hasNextLine())
        {
          count++; 
          String temp = sc.nextLine().trim();
          if (count == randomInt)
          {
            tempPhrase = temp;
          }
        }
      } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

      return tempPhrase;
  }

  public String toString(){
    String emptyString = "";
    for(int i = 0; i < word.length(); i++){
      if(word.substring(i, i+1).equals(" ")){
        emptyString += " ";
      } else {
        emptyString += "_";
      }
    }

    if(word.contains(guessCharacter)){
      for(int i = 0; i < word.length(); i++){
        System.out.println("");
      }
    }
      return emptyString; 
  }
}
