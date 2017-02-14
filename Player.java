public class Player
{
  private boolean isTurn;
  private final Char symbol;
  private int lastMove;
  
  public Player(Char symbol)
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
  
  public Char getSymbol()
  {
    return this.symbol;
  }
}
