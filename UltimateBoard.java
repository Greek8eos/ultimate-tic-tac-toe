import java.util.*;

public class UltimateBoard
{
	// Nine LocalBoard components of the ultimate board.
	private LocalBoard[][] boardArr;
	// Indicates if a LocalBoard has been won
	private boolean isWon;
	private Player playOne;
  	private Player playTwo;

	/**
	* Ultimate Board constructor
	* Default: constructs an empty [3][3] array of LocalBoard objects.
	*/ 
	public UltimateBoard()
	{
		this.boardArr = new LocalBoard[3][3];
		this.isWon = false;
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

	// public UltimateBoard()
	// {
	// 	this.boardArr = new LocalBoard[9];
	// 	this.isWon = false;
	// 	this.playOne = new Player('X');
	// 	this.playTwo = new Player('O');

	// 	for (int i = 0; i < boardArr.length; i++)
	// 	{
	// 		this.boardArr[i] = new LocalBoard(i, playOne, playTwo);
	// 	}
	// }

	/**
	* Change turns between players after a player plays.
	*/
	public void setTurn()
	{
		if(int turn == 0 || turn%2 == 0)
		{
			turn++;
			return;
		}
		else 
		{
			turn++;
			return;
		}
	}

	/**
	* Returns a boolean indicating whether a LocalBoard has been won or not.
	*/
	public boolean isWon()
	{
		return this.isWon;
	}
	
	//Checks if any local board is won in the Ultimate Board
	public void checkAnyWon()
	{
		if(boardArr[0][0].isWon() || boardArr[0][1].isWon() || boardArr[0][2].isWon() || 
			boardArr[1][0].isWon() || boardArr[1][1].isWon() || boardArr[1][2].isWon() ||
			boardArr[2][0].isWon() || boardArr[2][1].isWon() || boardArr[2][2].isWon())
		{
			this.isWon = true;
		}
		return;
	}

	//Checks if three local boards are won in the Ultimate Board
	public void checkWon()
	{
		if ((boardArr[0][0].isWon() && boardArr[0][1].isWon() && boardArr[0][2].isWon()) ||
			(boardArr[1][0].isWon() && boardArr[1][1].isWon() && boardArr[1][2].isWon()) ||
			(boardArr[2][0].isWon() && boardArr[2][1].isWon() && boardArr[2][2].isWon()) ||

			(boardArr[0][0].isWon() && boardArr[1][0].isWon() && boardArr[2][0].isWon()) ||
			(boardArr[0][1].isWon() && boardArr[1][1].isWon() && boardArr[2][1].isWon()) ||
			(boardArr[0][2].isWon() && boardArr[1][2].isWon() && boardArr[2][2].isWon()) ||

			(boardArr[0][0].isWon() && boardArr[1][1].isWon() && boardArr[2][2].isWon()) ||
			(boardArr[0][2].isWon() && boardArr[1][1].isWon() && boardArr[2][0].isWon()))
		{
			this.isWon = true;
		}
		return;
	}

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
