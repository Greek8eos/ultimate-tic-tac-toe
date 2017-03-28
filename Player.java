public class Player
{
  private boolean isTurn;
  private final char symbol;
  private int lastMove;
  
  public Player(char symbol)
  {
    this.symbol = symbol;
    this.isTurn = false;
    this.lastMove = 0;
  }
  
  /**
  * Sets this players lastMove.
  */
  public void setLastMove(int last)
  {
    this.lastMove = last;
  }
  
  /**
  * Returns this players lastMove.
  */
  public int getLastMove()
  {
    return this.lastMove;
  }
  
  /**
  * Changes this players turn.
  */
  public void setTurn()
  {
    if (this.isTurn == false)
    {
      this.isTurn = true;
    }
    else
    {
      this.isTurn = false;
    }
    return;
  }
  
  public boolean getTurn()
  {
    return this.isTurn;
  } 
  
  /**
  * Returns this players symbol.
  */
  public char getSymbol()
  {
    return this.symbol;
  }
}
