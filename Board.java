/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue;

  /* your code here - constructor(s) 
  Board()- creates a board for players to use
  */ 
  public Board(){
    solvedPhrase = "";
    phrase = loadPhrase();
    setLetterValue();
  }
 
  /* your code here - accessor(s) 
  All three accsess get the phrase from the private so they can be accsessed.
  */
  public String getPhrase(){
    return phrase;
  }
  public String getSolvedPhrase(){
  return solvedPhrase;
  }
  public int getLetterValue(){
  return currentLetterValue;
  }

   
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {//sets a random number to currentLetterValue
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {//checks if the phrase is correct to the guess and if so the isSolved becomes true
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {//sets default values
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {/* Creates a scanner that is used for the tempPhrase */
      Scanner sc = new Scanner(new File("phrases.txt"));
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
      Scanner sc = new Scanner(new File("phrases.txt"));
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
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
/* Guesses if the guess letter matches up with the chosen phrase.
  Precondition:
  the chosen String guess
  Postcondition:
  SolvedPhrase is set to the newSolvedPhrase
  it returns foundletter
*/
  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false; //sets the found letter to false
    String newSolvedPhrase = ""; //defount string blank string
    
    for (int i = 0; i < phrase.length(); i++)//iterates through each letter in phrase
    {
      if (phrase.substring(i, i + 1).equals(guess))//if any letter of phrase is equal to guess it sets foundletter 
      //to true and shows you your guess
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;//sets to true becuase your precondition was true
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  //
      }
    }
    solvedPhrase = newSolvedPhrase;//makes sure that solved phrase is the same as the new solved phrase
    return foundLetter;//returns either true or false
  } 
} 