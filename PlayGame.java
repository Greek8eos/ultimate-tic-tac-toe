import java.util.*;

public class PlayGame
{
  //Declare and Initialize variables
  Player one;
  Player two;
  UltimateBoard gameBoard;
  
  
  //Driver for Playing the Game
  public static void main(String[] args)
  {
    //Choose gamemodes, Play games, etc.
    this.one = new Player('X'); 
    this.two = new Player('O');
    this.ub = new UltimateBoard();
    
  }
}
