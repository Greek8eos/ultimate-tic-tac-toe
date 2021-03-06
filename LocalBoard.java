import java.util.*;

public class LocalBoard
{
  // Each LocalBoard's number
  private int boardNum;
  // 2D String array that stores the LocalBoard's symbols.
  private String[][] boardArr;
  // Indicates if a LocalBoard has been won
  private boolean isWon;
  private Player playOne;
  private Player playTwo;
  private String winner;
  
  /**
   * Local Board Constructor
   * Parameters: num (value to store as the board number in the [3][3] array)
   * Sets condition isWon to false (game is not won)
   * declares board array[3][3]
  */
  public LocalBoard(int num, Player playOne, Player playTwo)
  {
    this.boardNum = num;
    this.isWon = false;
    this.boardArr = new String[3][3];
    this.playOne = playOne;
    this.playTwo = playTwo;
    this.winner = null;
    
    for(int a = 0; a < boardArr.length; a++)
    {
    	for(int b = 0; b < boardArr.length; b++)
    	{
    		this.boardArr[a][b] = "_";
    	}
    }
  }
  
  /**
  * Returns this LocalBoard's number.
  */
  public int boardNum()
  {
    return boardNum;
  }
  
  /**
  * Returns a boolean indicating whether a LocalBoard has been won or not.
  */
  public boolean isWon()
  {
    return this.isWon;
  }

  /**
  * Checks if the board has been won and sets isWon to true if the LocalBoard 
  * has been won.
  */
  public void checkWon()
  {
    String symbol = null;
    if (playOne.getTurn())
    {
      symbol = playOne.getSymbol();
    }
    else
    {
      symbol = playTwo.getSymbol();
    }
    
    //All Possible combinations in a local board for a win
    if ((boardArr[0][0].equals(symbol) && boardArr[0][1].equals(symbol) && boardArr[0][2].equals(symbol)) ||
        (boardArr[1][0].equals(symbol) && boardArr[1][1].equals(symbol) && boardArr[1][2].equals(symbol)) ||
        (boardArr[2][0].equals(symbol) && boardArr[2][1].equals(symbol) && boardArr[2][2].equals(symbol)) ||
        
        (boardArr[0][0].equals(symbol) && boardArr[1][0].equals(symbol) && boardArr[2][0].equals(symbol)) ||
        (boardArr[0][1].equals(symbol) && boardArr[1][1].equals(symbol) && boardArr[2][1].equals(symbol)) ||
        (boardArr[0][2].equals(symbol) && boardArr[1][2].equals(symbol) && boardArr[2][2].equals(symbol)) ||
        
        (boardArr[0][0].equals(symbol) && boardArr[1][1].equals(symbol) && boardArr[2][2].equals(symbol)) ||
        (boardArr[0][2].equals(symbol) && boardArr[1][1].equals(symbol) && boardArr[2][0].equals(symbol)))
    {
      this.isWon = true;
      this.winner = symbol;
      for(int a = 0; a < 3; a++)
      {
    	  for(int b = 0; b < 3; b++)
    	  {
    		  if(isSpotEmpty(a, b))
    		  {
    			  boardArr[a][b] = "R";
    		  }
    	  }
      }
    }
    return;
  }
  
  public String getWinner()
  {
    //Comparing Strings. Changed from "==" to .equals
    if (playOne.getSymbol().equals(this.winner))
    {
      return playOne.getSymbol();
    }
    else if (playTwo.getSymbol().equals(this.winner))
    {
      return playTwo.getSymbol();
    }
    return null;
  }

  /**
  * Checks if a spot on the LocalBoard is empty.
  */
  public boolean isSpotEmpty(int row, int col)
  {
    return (boardArr[row][col].equals("_"));
  }

  /**
  * Sets a given spot on the LocalBoard to the current players symbol.
  */
  public int[] setSpot(int row, int col)
  { 
    //Check if spot is taken
    int[] spotArray = new int[2];
    if (isSpotEmpty(row, col) == false)
    {
      return null;
    }

    if(playOne.getTurn())
    {
      boardArr[row][col] = playOne.getSymbol();
    }
    else
    {
      boardArr[row][col] = playTwo.getSymbol();
    }
    spotArray[0] = row;
    spotArray[1] = col;
    return spotArray;    
  }

  /**
  * Returns a string representation of the LocalBoard.
  */
  public String toString()
  {
    StringBuilder localStr = new StringBuilder();
    for (int i = 0; i < 3; i++)
    {
      localStr.append("|");
      for (int j = 0; j < 3; j++)
      {
        localStr.append(" " + boardArr[i][j]);
      }
      localStr.append(" |\n");
    }
    return localStr.toString();
  }
}
