public class Coord
{
  public final int row;
  public final int col;

  public Coord(int ir, int ic)
  {
    this.row = ir;
    this.col = ic;
  }

  public boolean equals(Coord c)
  {
    return this.row==c.row && this.col==c.col;
  }

  public String toString()
  {
    return String.format("(%d,%d)",row,col);
  }
}