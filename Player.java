public class Player
{
  private final char symbol;
  private boolean isTurn;
  private boolean isWinner;
  private int lastMove;
  
  public Player(char symbol)
  {
    this.symbol = symbol;
    this.isTurn = false;
    this.isWinner = false;
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
  
  /* Used to set First player's turn */
  public void setPlayerTurn()
  {
    this.isTurn = true;
  }
  
  /**
  * Changes this players turn.
  */
  public void switchTurn()
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

  /**
  * Returns whether it's this players turn or not.
  */
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
