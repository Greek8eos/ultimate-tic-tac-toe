import java.util.*;

public class UltimateBoard
{

	// Nine LocalBoard components of the ultimate board.
	private LocalBoard boardArr[][];

	/*
	 * Ultimate Board constructor
	 * Default: construct an empty [3][3] board
	*/ 
	public UltimateBoard()
	{
		this.boardArr = new LocalBoard[3][3];
		int count = 0;
		for (int i = 0; i < boardArr.length; i++)
		{
			for (int j = 0; i < boardArr[i].length; j++)
			{
				this.boardArr[i][j] = new LocalBoard(count);
				count++;
			}
		}
	}

	/**
	* Change turns between players after a player plays.
	*/
	public boolean setTurn();

	/*
  	 * Returns a string representation of the board.
  	*/
	public String toString()
	{
		StringBuilder ultimateStr = new StringBuilder();
		for (int i = 0; i < boardArr.length; i++)
		{
			for (int j = 0; i < boardArr[i].length; j++)
			{
				String localStr = boardArr[i][j].toString();
				ultimateStr.append(localStr + "  ");
			}
			ultimateStr.append("\n\n");
		}

    return ultimateStr.toString();
	}

	// public static void main(String[] args)
  // {
  //   UltimateBoard testBoard = new UltimateBoard();
  // }
}
