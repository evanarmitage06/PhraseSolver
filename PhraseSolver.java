/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;
  /* your code here - constructor(s) */ 
  public PhraseSolver(){
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }
  /* your code here - accessor(s) */
 
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    //System.out.println(board.getPhrase());
    while (!solved) 
    { 
      String phrase  = board.getSolvedPhrase();
      
      /* your code here - game logic */
    
      System.out.println(phrase);
      board.setLetterValue();
      int currentpoints = board.getLetterValue();

      if (currentPlayer == 1){
        System.out.print(player1.getName());
      } else{
        System.out.print(player2.getName());
      }
      System.out.println(" , guess a letter, or guess the entire phrase.");
      System.out.println(currentpoints +" is on the line");
      String guess = input.nextLine();
      if(currentPlayer == 1){
        if(guess.length() == 1){
          board.guessLetter(guess);
          if(board.guessLetter(guess)== true){
          player1.addToPoints(currentpoints);
          }
        } else{
            if(board.isSolved(guess)){
              solved = true;
              System.out.println("You got the whole phrase");
            }
        }
        System.out.println("You have "+player1.getPoints()+" points");
      } else{
        if(guess.length() == 1){
          board.guessLetter(guess);
          if(board.guessLetter(guess)== true){
            player2.addToPoints(currentpoints);
            }
        } else{
            if(board.isSolved(guess)){
              solved = true;
              System.out.println("You got the whole phrase");
            }
        }
        System.out.println("You have "+player2.getPoints()+" points");
      }
      /*
      }
       your code here - determine how game ends */
      //solved = true; 
      if(board.getSolvedPhrase().indexOf("_") == -1){
        solved = true;
      }
      if(currentPlayer == 1){
        currentPlayer = 2;
      }else {
        currentPlayer = 1;
      }

    } 
   
  }
  
}