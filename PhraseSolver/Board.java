package PhraseSolver;
import java.util.Scanner;
import java.io.File;
public class Board{

  private String word = loadPhrase(), checkedString = word; 
  int guessedCount;
  private String guessCharacter;
  String emptyString = "";



  public Board(){
    guessCharacter = "";
    for(int i = 0; i < word.length(); i++){
      if(word.substring(i, i+1).equals(" ")){
        emptyString += " ";
      } else {
        emptyString += "_";
      }
    }
  }


  public void setGuess(String guess){
    guessCharacter = guess;
  }

  public String getGuess(){
    return guessCharacter;
  }

  public int getCounter(){
    return guessedCount;
  }

  public void setCounter(int count){
    guessedCount = count;
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
  public Boolean end(){
    if(checkedString.length() == 0){
      return true;
    }
    return false;
  }

  public String toString(){
    
    int counter = 0;
    if(checkedString.contains(guessCharacter)){
      for(int i = 0; i < emptyString.length(); i++){
        if(word.substring(i, i+1).equals(guessCharacter)){
          emptyString = emptyString.substring(0, i) + guessCharacter + emptyString.substring(i + 1);
          counter++;
        }
      }
      checkedString = checkedString.replace(guessCharacter, "");
      guessedCount = counter;
    }
    return emptyString; 
  }
}


