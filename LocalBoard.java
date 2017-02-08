import java.util.*;

public class LocalBoard
{
  private int boardNum;
  private boolean isWon;
  private String boardArr[][];
  
  public LocalBoard(int num)
  {
    this.boardNum = num;
    this.isWon = false;
    this.boardArr = new String[3][3];
    
    return;
  }
  
  public int boardNum()
  {
    return boardNum;
  }
  
  public void setWon()
  {
    this.isWon = true;
    return;
  }
  
  public boolean isWon()
  {
    return this.isWon;
  }

  public boolean isSpotEmpty(int row, int col)
  {
    return (boardArr[row][col] == null);
  }

  public void setSpot(int row, int col)
  {
    if (isSpotEmpty(row, col) == false)
    {
      return;
    }


    return;    
  }

  public String toString()
  {
    StringBuilder localStr = new StringBuilder();
    return localStr.toString();
  }

  // public static void main(String[] args)
  // {
  //   LocalBoard testBoard = new LocalBoard(2);
  // }
}

