import java.util.*;

public class PlayGame
{
  //Declare and Initialize variables
  Player one;
  Player two;
  UltimateBoard gameBoard;
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
    
    //if no, exit();
    
    //Get new gamemode
    System.out.println("Gamemodes: \n 1) Winner when one local board is won \n 2) Winner when three local boards are won in a row");
    
    
    //Play Game
    System.out.println("Start playing!");
    
    //While game mode is not won
    while()
    {
      switch(chosenMode){
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
