import java.util.*;

public class PlayGame
{
  //Declare and Initialize variables
  static UltimateBoard gameBoard;
  static String newG;
  static boolean newGame;
  static int chosenMode;
  
  
  //Driver for Playing the Game
  public static void main(String[] args)
  {
    //Choose gamemodes, Play games, etc.
    gameBoard = new UltimateBoard();
    
    // read mode from python
    
    switch(chosenMode)
    {
      /*Player One begins game, with turn equals true
      Allow Player one to pick any spot on UltimateBoard
      The position chosen dictates the next local board to be used
      Whenever a local board is won, the game ends
      */
      case 1:
        
        //Player One picks a position (A local board and local board position)
        //How is this represented? Are we receiving a string or input from the click in the UI
        //Player Two picks a position in a local board dictated by the previous position
        //This should continue in a loop until one local board is won
        int localBoardNumber = 0;
        gameBoard.playOne.setPlayerTurn();
        while(!gameBoard.getBoardArr(localBoardNumber).checkWon())
        {
         //  receive player input
         // lnum= local board number from python;

          if(gameBoard.getBoardArr(localBoardNumber).isSpotEmpty(row, col))
          {
            int[] nextLBArr = gameBoard.getBoardArr(localBoardNumber).setSpot(row,col))
       
            if(gameBoard.getBoardArr(localBoardNumber).checkWon())
            {
             //send to python playerOne won
             //receive whether NewGame or Quit
             
             //Check newG if it equals 'Y' or any other answer
             
              if(newGame)
              {
              // If input is 'Y' for "Yes" than this results in a new game
              //    main();
              //    exit();
              }
              else
              {
                 System.exit(0);
              }

              int nextLBnum = 3 * nextLBArr[0] + nextLBArr[1];
            }
          }
        }
        
        
        break;
      case 2:
        //Player On picks a position (A local board and local board position)
        //Player Two picks a position in a local board dictated by the previous position
        //This should continue in a loop until three local boards are won in a row
        
        
        break;
      default:
        while(chosenMode != 1 || chosenMode != 2)
        {
          System.out.println("Error: Chosen mode number not recognized. Enter new input:");
          chosenMode = sc.nextInt();
        }
        
    }
  }
}
