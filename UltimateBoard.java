import java.util.*;

public class UltimateBoard
{
	// Nine UltimateBoard components of the ultimate board.
	private LocalBoard[][] boardArr;
	// Indicates if a UltimateBoard has been won
	private String winner = null;
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
			for (int j = 0; j < boardArr.length; j++)
			{
				this.boardArr[i][j] = new LocalBoard(count, playOne, playTwo);
				count++;
			}
		}
	}
	
	public String getWinner()
	{
		return this.winner;
	}
	
	public Player getPlayerOne()
	{
		return playOne;
	}
	
	public Player getPlayerTwo()
	{
		return playTwo;
	}
	
	//Num  = 0 through 8
	public LocalBoard getBoardArr(int num)
	{
		LocalBoard lb = new LocalBoard(num, this.playOne, this.playTwo);
		switch(num)
		{
			case 0:
				lb = this.boardArr[0][0];
				break;
			case 1:
				lb = this.boardArr[0][1];
				break;
			case 2:
				lb = this.boardArr[0][2];
				break;
			case 3:
				lb = this.boardArr[1][0];
				break;
			case 4:
				lb = this.boardArr[1][1];
				break;
			case 5:
				lb = this.boardArr[1][2];
				break;
			case 6:
				lb = this.boardArr[2][0];
				break;
			case 7:
				lb = this.boardArr[2][1];
				break;
			case 8:
				lb = this.boardArr[2][2];
				break;
		}
		return lb;
	}

	/**
	* Change turns between players after a player plays.
	*/
	public void setTurn()
	{
		playOne.switchTurn();
		playTwo.switchTurn();
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
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[0][2].isWon() &&  boardArr[0][2].getWinner().equals(playOne.getSymbol()))) ||
		     
		    ((boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][2].isWon() &&  boardArr[1][2].getWinner().equals(playOne.getSymbol()))) ||
		      
		    ((boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][1].isWon() &&  boardArr[2][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][2].isWon() &&  boardArr[2][2].getWinner().equals(playOne.getSymbol()))) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playOne.getSymbol()))) ||
		     
		    ((boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][1].isWon() &&  boardArr[2][1].getWinner().equals(playOne.getSymbol()))) ||
		     
		    ((boardArr[0][2].isWon() &&  boardArr[0][2].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][2].isWon() &&  boardArr[1][2].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][2].isWon() &&  boardArr[2][2].getWinner().equals(playOne.getSymbol()))) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][2].isWon() &&  boardArr[2][2].getWinner().equals(playOne.getSymbol()))) ||
		      
		    ((boardArr[0][2].isWon() &&  boardArr[0][2].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playOne.getSymbol()))  &&
		     (boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playOne.getSymbol()))))
		  {
		    	this.isWon = true;
		    	winner = "playOne";
		   }
		
		//Testing if PlayerTwo Won the Game
		if(
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[0][2].isWon() &&  boardArr[0][2].getWinner().equals(playTwo.getSymbol()))) ||
		      
		    ((boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[1][1].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[1][2].isWon() &&  boardArr[1][2].getWinner().equals(playTwo.getSymbol()))) ||
		     
		    ((boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[2][1].isWon() &&  boardArr[2][1].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[2][2].isWon() &&  boardArr[2][2].getWinner().equals(playTwo.getSymbol()))) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[1][0].isWon() &&  boardArr[1][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[2][0].isWon() &&  boardArr[2][0].getWinner().equals(playTwo.getSymbol()))) ||
		      
		    ((boardArr[0][1].isWon() &&  boardArr[0][1].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[2][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))) ||
		      
		    ((boardArr[0][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[1][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[2][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))) ||
        
		    ((boardArr[0][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))  &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) &&
		     (boardArr[2][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))) ||
		      
		    ((boardArr[0][2].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) &&
		     (boardArr[1][1].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol())) &&
		     (boardArr[2][0].isWon() &&  boardArr[0][0].getWinner().equals(playTwo.getSymbol()))))
		{
			this.isWon = true;
			winner = "playOne";
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
				ultimateStr.append(localStr + "");
				ultimateStr.append("\n");
			}
			ultimateStr.append("\n");
		}
    return ultimateStr.toString();
	}
}
