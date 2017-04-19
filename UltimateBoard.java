import java.util.*;

public class UltimateBoard
{
	// Nine UltimateBoard components of the ultimate board.
	private LocalBoard[][] boardArr;
	// Indicates if a UltimateBoard has been won
  	private boolean isWon;
	private Player playOne;
  	private Player playTwo;
	private boolean turn;

	/**
	* Ultimate Board constructor
	* Default: constructs an empty [3][3] array of UltimateBoard objects.
	*/ 
	public UltimateBoard()
	{
		this.boardArr = new LocalBoard[3][3];
		this.isWon = false;
		this.playOne = new Player("X");
		this.playTwo = new Player("O");
		this.playOne.setPlayerTurn();

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
	public void setTurn()
	{
		playOne.setTurn();
		playTwo.setTurn();
		return;
	}

	/**
 	 * Returns a boolean indicating whether a UltimateBoard has been won or not.
 	 */
  	public boolean isWon()
	{
		return this.isWon;
  	}

	public void checkWon()
	{
		//Testing if PlayerOne Won the Game
		if (
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		    (boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playOne.getSymbol()) &&
		    (boardArr[0][2].isWon() &&  boardArr[0][2].getWinner().equals(playOne.getSymbol())) ||
		     
		    ((boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playOne.getSymbol()) &&
		    (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playOne.getSymbol()) &&
		    (boardArr[1][2].isWon() &&  boardArr[1][2].getWinner().equals(playOne.getSymbol())) ||
		      
		    ((boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playOne.getSymbol()) &&
		    (boardArr[2][1].isWon() &&  boardArr[2][1].getWinner().equals(playOne.getSymbol()) &&
		    (boardArr[2][2].isWon() &&  boardArr[2][2].getWinner().equals(playOne.getSymbol())) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playOne.getSymbol())) ||
		     
		    ((boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[2][1].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol())) ||
		     
		    ((boardArr[0][2].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[1][2].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[2][2].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol())) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol())) &&
		     (boardArr[2][2].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol())) ||
		      
		    ((boardArr[0][2].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()) &&
		     (boardArr[2][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol())))
		{
			this.isWon = true;
		}
		
		//Testing if PlayerTwo Won the Game
		if (
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[0][2].isWon() &&  boardArr[0][2].getWinner().equals(playTwo.getSymbol())) ||
		      
		    ((boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playTwo.getSymbol()) &&
		    (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playTwo.getSymbol()) &&
		    (boardArr[1][2].isWon() &&  boardArr[1][2].getWinner().equals(playTwo.getSymbol())) ||
		     
		    ((boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[2][1].isWon() &&  boardArr[2][1].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[2][2].isWon() &&  boardArr[2][2].getWinner().equals(playTwo.getSymbol())) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playTwo.getSymbol())) ||
		      
		    ((boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[2][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) ||
		      
		    ((boardArr[0][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[1][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[2][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) &&
		     (boardArr[2][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) ||
		      
		    ((boardArr[0][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()) &&
		     (boardArr[2][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())))
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
}
