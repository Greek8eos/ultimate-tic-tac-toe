import static org.junit.Assert.*;
import org.junit.Test;

public class UltimateBoardTest {
	
	public static void main(String args[])
	{
		org.junit.runner.JUnitCore.main("UltimateBoardTest");
	}
	
	@Test //Ultimate Constructor
	public void UltimateBoardConstructor1() 
	{
		UltimateBoard ub = new UltimateBoard();
		assertEquals(ub.getPlayerOne().getSymbol(), "X");
		assertEquals(ub.getPlayerTwo().getSymbol(), "O");
		assertEquals(ub.isWon(), false);
	}
	
	@Test //Ultimate Constructor
	public void UltimateBoardConstructor()
	{
		//Any additional Constructor Checks
	}
	
	@Test //Set turns at beginning of game, switch turns, and check turns
	public void setTurn1()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		ub.setTurn();
		assertEquals(ub.getPlayerOne().getTurn(), false);
		assertEquals(ub.getPlayerTwo().getTurn(), true);
	}
	
	@Test //Change turns back to original 
	public void setTurn2()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		ub.setTurn();
		ub.setTurn();
		assertEquals(ub.getPlayerOne().getTurn(), true);
		assertEquals(ub.getPlayerTwo().getTurn(), false);
	}
	
	@Test //getBoardArr - Check if spot is set
	public void getBoardArr1()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		//Get local board from local board array
		LocalBoard lb = ub.getBoardArr(0);
		lb.setSpot(0, 0);
		
		//Check board Num, if spot was set, and if board isWon
		assertEquals(lb.boardNum(), 0);
		assertEquals(lb.isSpotEmpty(0,0), false);
		assertEquals(lb.isWon(), false);
	}
	
	@Test //getBoardArr - Check if spot is set
	public void getBoardArr2()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		//Get Local board from local board array
		LocalBoard lb = ub.getBoardArr(0);
		lb.setSpot(0, 0);
		//Switch Local Boards
		lb = ub.getBoardArr(1);
		lb = ub.getBoardArr(0);
		
		assertEquals(lb.isSpotEmpty(0, 0), false);
	}
	
	@Test //Check if board is won at beginning of initialization
	public void isWon1()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		assertEquals(ub.isWon(), false);
	}
	
	@Test //UltimateBoard is not won, but a local board is won (Horizontal) by Player One
	public void isWon2()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		LocalBoard lb = ub.getBoardArr(4);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		
		lb.checkWon();
		ub.checkWon();
		
		assertEquals(lb.boardNum(), 4);
		assertEquals(lb.isWon(), true);
		assertEquals(ub.isWon(), false);
	}
	
	@Test //UltimateBoard is Won (uses isWon and checkWon)
	public void isWon3()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		LocalBoard lb = ub.getBoardArr(4);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		lb.checkWon();
		
		lb = ub.getBoardArr(3);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		lb.checkWon();
		
		lb = ub.getBoardArr(5);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		lb.checkWon();
		ub.checkWon();
		
		assertEquals(lb.isWon(), true);
		assertEquals(ub.isWon(), true);
		assertEquals(ub.getWinner(), "playOne");
	}
	
	@Test //UltimateBoard - checkWon 
	public void checkWon1()
	{
		UltimateBoard ub = new UltimateBoard();
		ub.getPlayerOne().setPlayerTurn();
		LocalBoard lb = ub.getBoardArr(0);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		lb.checkWon();
		
		ub.setTurn();
		lb = ub.getBoardArr(1);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		lb.checkWon();
		
		ub.setTurn();
		lb = ub.getBoardArr(2);
		lb.setSpot(0, 0);
		lb.setSpot(0, 1);
		lb.setSpot(0, 2);
		lb.checkWon();
		
		ub.checkWon();
		System.out.println(ub.toString());
		assertEquals(ub.getWinner(), null);
		assertEquals(ub.getBoardArr(0).getWinner(), "X");
		assertEquals(ub.getBoardArr(1).getWinner(), "O");
		assertEquals(ub.getBoardArr(2).getWinner(), "X");
	}
}
