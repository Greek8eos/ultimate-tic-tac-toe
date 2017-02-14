import java.util.*;

public class LocalBoard
{
  // Each local boards number
  private int boardNum;
  // Indicates if a local board has been won
  private boolean isWon;
  // 2D String array that stores boards symbols.
  private String boardArr[][];
  
  /*
   * Local Board Costructor
   * Parameters: num (value to store as the board number in the [3][3] array)
   * Sets condition isWon to false (game is not won)
   * declares board array[3][3]
  */
  public LocalBoard(int num)
  {
    this.boardNum = num;
    this.isWon = false;
    this.boardArr = new String[3][3];
    
    return;
  }
  
  /**
  * Returns this boards number.
  */
  public int boardNum()
  {
    return boardNum;
  }
  
  /**
  * Returns a boolean indicating whether a board has been won or not.
  */
  public boolean isWon()
  {
    return this.isWon;
  }

  /**
  * Checks if the board has been won and sets isWon to true if the board has 
  * been won.
  */
  private void checkWon()
  {
    // Some type of conditional to test is the board has been won.
    if ()
    {
      this.isWon = true;
      return;
    }

    return;
  }

  /**
  * Checks if a spot on the board is empty.
  */
  public boolean isSpotEmpty(Coord spot)
  {
    return (boardArr[row][col] == null);
  }

  /**
  * Sets a given spot on the board to the current players symbol.
  */
  public void setSpot(Coord spot)
  {
    if (isSpotEmpty(row, col) == false)
    {
      return;
    }

    // Code to set spot

    return;    
  }

  /**
  * Returns a string representation of the board.
  */
  public String toString()
  {
    StringBuilder localStr = new StringBuilder();
    return localStr.toString();
  }

  /**
  * Main method used for testing board methods.
  */
  // public static void main(String[] args)
  // {
  //   LocalBoard testBoard = new LocalBoard(2);
  // }
}
