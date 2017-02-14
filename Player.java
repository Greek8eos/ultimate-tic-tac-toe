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
  
  public void setLastMove(int last)
  {
    this.lastMove = last;
  }
  
  public int getLastMove()
  {
    return this.lastMove;
  }
  
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
  
  public char getSymbol()
  {
    return this.symbol;
  }
}
