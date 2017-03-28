import java.util.*;

public class UltimateBoard
{
	// Nine LocalBoard components of the ultimate board.
	private LocalBoard boardArr[][];
	private Player playOne;
  	private Player playTwo;

	/**
	* Ultimate Board constructor
	* Default: constructs an empty [3][3] array of LocalBoard objects.
	*/ 
	public UltimateBoard()
	{
		this.boardArr = new LocalBoard[3][3];
		this.playOne = new Player('X');
		this.playTwo = new Player('O');
		
		int count = 0;
		for (int i = 0; i < boardArr.length; i++)
		{
			for (int j = 0; i < boardArr[i].length; j++)
			{
				this.boardArr[i][j] = new LocalBoard(count, playOne, playTwo);
				count++;
			}
		}
	}

	/**
	* Change turns between players after a player plays.
	*/
	public boolean setTurn();

	/**
  	* Returns a string representation of the board.
  	*/
	public String toString()
	{
		StringBuilder ultimateStr = new StringBuilder();
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				String localStr = boardArr[i][j].toString();
				ultimateStr.append(localStr + "  ");
			}
			ultimateStr.append("\n\n");
		}
    		return ultimateStr.toString();
	}

	/**
  	* Main method used for testing UltimateBoard methods.
  	*/
	// public static void main(String[] args)
  	// {
  	//   UltimateBoard testBoard = new UltimateBoard();
  	// }
}

