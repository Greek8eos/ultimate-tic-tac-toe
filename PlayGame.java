import java.util.*;

public class PlayGame
{
  //Declare and Initialize variables
  UltimateBoard gameBoard;
  char newG;
  boolean newGame;
  int chosenMode;
  
  //Driver for Playing the Game
  public static void main(String[] args)
  {
    //Choose gamemodes, Play games, etc.
    this.ub = new UltimateBoard();
    
    //Start new Game
    System.out.println("Start a new game? (Y/N)");
    Scanner sc = new Scanner(System.in);
    newG = sc.nextChar();
    
    //Check newG if it equals 'Y' or any other answer
    if(newG.equals('Y'))
    {
      //If input is 'Y' for "Yes" than this results in a new game
      newGame = true;
    }
    else
    {
      //Anything other than 'Y' for "Yes" results in no new game
      newGame = false;
      //if no, exit();
      System.out.println("Exiting...");
      System.exit(0);
    }
    
    //Get new gamemode
    System.out.println("Please select a game mode. \n Gamemodes: \n 1) Winner when one local board is won \n 2) Winner when three local boards are won in a row");
    chosenMode = sc.nextInt();
    //Checking the game mode number occurs in the while loop below
    
    //Play Game
    System.out.println("Start playing!");
    
    switch(chosenMode)
    {
      /*Player One begins game, with turn equals true
      Allow Player one to pick any spot on UltimateBoard
      The position chosen dictates the next local board to be used
      Whenever a local board is won, the game ends
      */
      case 1:
        gameboard.playOne.setPlayerTurn();
        //Player One picks a position (A local board and local board position)
        //How is this represented? Are we receiving a string or input from the click in the UI
        //Player Two picks a position in a local board dictated by the previous position
        //This should continue in a loop until one local board is won
        
        
        break;
      case 2:
        //Player On picks a position (A local board and local board position)
        //Player Two picks a position in a local board dictated by the previous position
        //This should continue in a loop until three local boards are won in a row
        
        
        break;
      default:
        while(chosenMode != 1 || chosenMode != 2)
        {
          System.out.println("Error: Chosen mode number not rcognized. Enter new input:");
          chosenMode = sc.nextInt();
        }
    }
  }
}
