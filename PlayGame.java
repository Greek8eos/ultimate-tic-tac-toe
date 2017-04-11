import java.util.*;

public class PlayGame
{
  //Declare and Initialize variables
  Player one;
  Player two;
  UltimateBoard gameBoard;
  char newG;
  boolean newGame;
  int chosenMode;
  
  //Driver for Playing the Game
  public static void main(String[] args)
  {
    //Choose gamemodes, Play games, etc.
    this.one = new Player('X'); 
    this.two = new Player('O');
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
    
    //While game mode is not won
    while(!gameBoard.isWon)
    {
      switch(chosenMode)
      {
        case 1:
          //When a local board is won
          
          break;
        case 2:
          //When three local boards are won in a row
          
          break;
        default:
          System.out.println("ERROR: GameMode not recognized. Enter new gamemode information: ");
          //Read in new game mode input to follow game mode 1 or 2
          
          break;
      }
    }
    
    
  }
}
