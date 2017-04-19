public class Player
{
  private final String symbol;
  private boolean isTurn;
  private boolean isWinner;
  private int lastMove;
  
  public Player(String symbol)
  {
    this.symbol = symbol;
    this.isTurn = false;
    this.isWinner = false;
    this.lastMove = 0;
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
  public String getSymbol()
  {
    return this.symbol;
  }
}
