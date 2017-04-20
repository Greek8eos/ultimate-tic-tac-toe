import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
* Class to unit test methods in the LocalBoard class.
*
* To run in Terminal use: 
* javac -cp .:junit.jar *.java
* java -cp .:junit.jar LocalBoardTests
*/
public class LocalBoardTests
{
  public static void main(String args[])
  {
    org.junit.runner.JUnitCore.main("LocalBoardTests");
  }
  /*----------------------------------------------------------------------------------------------------
 * Tests LocalBoard(int num, Player playOne, Player playTwo) CONSTRUCTOR
 * Uses boardNum() isWon() getWinner() complementarily
 */
 @Test public void localBoardConstructor()
 {
	 Player playOne= new Player("X");
	 Player playTwo= new Player("O");
	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
	 assertEquals(lb.boardNum(),0);
	 assertEquals(lb.isWon(),false);
	 assertEquals(lb.getWinner(),null);
  }
/*----------------------------------------------------------------------------------------------------
 * Tests if a spot is empty when it is actually empty
 */
 @Test public void isSpotEmptyTest1()
 {
	 Player playOne= new Player("X");
	 Player playTwo= new Player("O");
	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
	 assertEquals(lb.isSpotEmpty(1,1), true);
 }
/*----------------------------------------------------------------------------------------------------
 * Test to set spot in an empty spot
 */
 @Test public void setSpotTest1()
 {
	 Player playOne= new Player("X");
	 Player playTwo= new Player("O");
	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
	  
	 assertEquals(lb.setSpot(1,1),true);
 }
/*----------------------------------------------------------------------------------------------------
 * Test to isSpotEmpty when it isnt
 */
 @Test public void isSpotEmptyTest2()
 {
	 Player playOne= new Player("X");
	 Player playTwo= new Player("O");
	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
	 playOne.switchTurn();
	 lb.setSpot(1, 1);
	  
	 assertEquals(lb.isSpotEmpty(1,1), false);
 }
/*----------------------------------------------------------------------------------------------------
 * Test setting a spot that is taken
 */
 @Test public void setSpotTest2()
 {
	 Player playOne= new Player("X");
	 Player playTwo= new Player("O");
	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
	 playOne.switchTurn();
	 lb.setSpot(1, 1);
	 playOne.switchTurn();
	 playTwo.switchTurn();
	  
	 assertEquals(lb.setSpot(1, 1), false);
	  
 }
/*----------------------------------------------------------------------------------------------------
 * Test if toString works
 */
 @Test public void toStringTest()
  {
	 Player playOne= new Player("X");
	 Player playTwo= new Player("O");
	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
	 playOne.setPlayerTurn();
	 lb.setSpot(1, 1);
	 assertEquals(lb.isSpotEmpty(1, 1),false);
	 playOne.switchTurn();
	 playTwo.switchTurn();
	 lb.setSpot(1, 1);
	 assertEquals(lb.setSpot(1, 1),false);
	 lb.setSpot(0, 0);
	 assertEquals(lb.isSpotEmpty(0, 0), false);
	 assertEquals("| O null null |\n| null X null |\n| null null null |\n", lb.toString());
  }
/*----------------------------------------------------------------------------------------------------
 * Test if turn switching with spot setting is correct
 */
 @Test public void flowTest1()
 {
	 Player playOne= new Player("X");
 	 Player playTwo= new Player("O");
 	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
 	 playOne.setPlayerTurn();
 	 lb.setSpot(1, 1);
 	 assertEquals(lb.isSpotEmpty(1, 1),false);
 	  
 	 playOne.switchTurn();
 	 playTwo.switchTurn();
 	 lb.setSpot(0, 2);
 	 assertEquals(lb.isSpotEmpty(0, 2),false);
 	  
 	 playOne.switchTurn();
 	 playTwo.switchTurn();
 	 lb.setSpot(2, 2);
 	 assertEquals(lb.isSpotEmpty(2, 2),false);
 	  
 	 playOne.switchTurn();
 	 playTwo.switchTurn();
 	 lb.setSpot(1,2);
 	 assertEquals(lb.isSpotEmpty(1, 2),false);
 	  
 	 playOne.switchTurn();
 	 playTwo.switchTurn();
 	 lb.setSpot(0, 0);
 	 assertEquals(lb.isSpotEmpty(0, 0),false);
 	 assertEquals("| X null O |\n| null X O |\n| null null X |\n",lb.toString());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if diagonal win condition is true top left to bottom right
 */
 @Test public void diagonalWinTest1()
 {
	 Player playOne= new Player("X");
  	 Player playTwo= new Player("O");
  	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
  	 playOne.setPlayerTurn();
  	 lb.setSpot(1, 1);
  	 assertEquals(lb.isSpotEmpty(1, 1),false);
  	  
  	 playOne.switchTurn();
  	 playTwo.switchTurn();
  	 lb.setSpot(0, 2);
  	 assertEquals(lb.isSpotEmpty(0, 2),false);
  	  
  	 playOne.switchTurn();
  	 playTwo.switchTurn();
  	 lb.setSpot(2, 2);
  	 assertEquals(lb.isSpotEmpty(2, 2),false);
  	  
  	 playOne.switchTurn();
  	 playTwo.switchTurn();
  	 lb.setSpot(1,2);
  	 assertEquals(lb.isSpotEmpty(1, 2),false);
  	  
  	 playOne.switchTurn();
  	 playTwo.switchTurn();
  	 lb.setSpot(0, 0);
  	 assertEquals(lb.isSpotEmpty(0, 0),false);
  	 assertEquals("| X null O |\n| null X O |\n| null null X |\n",lb.toString());
  	  
  	 assertEquals("X", lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if diagonal win condition is true top right to bottom left
 */
 @Test public void diagonalWinTest2()
 {
	 Player playOne= new Player("X");
   	 Player playTwo= new Player("O");
   	 LocalBoard lb= new LocalBoard(0,playOne,playTwo);
   	 playOne.setPlayerTurn();
   	 lb.setSpot(1, 0);
   	 assertEquals(lb.isSpotEmpty(1, 0),false);
   	  
   	 playOne.switchTurn();
   	 playTwo.switchTurn();
   	 lb.setSpot(0, 2);
   	 assertEquals(lb.isSpotEmpty(0, 2),false);
   	  
   	 playOne.switchTurn();
   	 playTwo.switchTurn();
   	 lb.setSpot(2, 1);
   	 assertEquals(lb.isSpotEmpty(2, 1),false);
   	  
   	 playOne.switchTurn();
   	 playTwo.switchTurn();
   	 lb.setSpot(2,0);
   	 assertEquals(lb.isSpotEmpty(2, 0),false);
   	  
   	 playOne.switchTurn();
   	 playTwo.switchTurn();
   	 lb.setSpot(0, 0);
   	 assertEquals(lb.isSpotEmpty(0, 0),false);
   	  
   	 playOne.switchTurn();
   	 playTwo.switchTurn();
   	 lb.setSpot(1,1);
   	 assertEquals(lb.isSpotEmpty(1, 1),false);
   	  
   	 //System.out.println(lb.toString());
   	 assertEquals("O", lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if horizontal win condition is true first row
 */
 @Test public void horizontalTest1()
 {
	 Player playOne= new Player("X");
     Player playTwo= new Player("O");
     LocalBoard lb= new LocalBoard(0,playOne,playTwo);
     playOne.setPlayerTurn();
     lb.setSpot(0,0);
     lb.setSpot(0, 1);
     lb.setSpot(0, 2);
     System.out.println(lb.toString());
     assertEquals("X",lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if horizontal win condition is true second row
 */
 @Test public void horizontalTest2()
 {
	 Player playOne= new Player("X");
     Player playTwo= new Player("O");
     LocalBoard lb= new LocalBoard(0,playOne,playTwo);
     playOne.setPlayerTurn();
     lb.setSpot(1,0);
     lb.setSpot(1, 1);
     lb.setSpot(1, 2);
     System.out.println(lb.toString());
     assertEquals("X",lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if horizontal win condition is true third row
 */
 @Test public void horizontalTest3()
 {
	 Player playOne= new Player("X");
     Player playTwo= new Player("O");
     LocalBoard lb= new LocalBoard(0,playOne,playTwo);
     playOne.setPlayerTurn();
     lb.setSpot(2,0);
     lb.setSpot(2, 1);
     lb.setSpot(2, 2);
     System.out.println(lb.toString());
     assertEquals("X",lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if vertical win condition is true first column
 */
 @Test public void verticalTest1()
 {
	 Player playOne= new Player("X");
     Player playTwo= new Player("O");
     LocalBoard lb= new LocalBoard(0,playOne,playTwo);
     playOne.setPlayerTurn();
     lb.setSpot(0,0);
     lb.setSpot(1, 0);
     lb.setSpot(2, 0);
     System.out.println(lb.toString());
     assertEquals("X",lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if vertical win condition is true second column
 */
 @Test public void verticalTest2()
 {
	 Player playOne= new Player("X");
     Player playTwo= new Player("O");
     LocalBoard lb= new LocalBoard(0,playOne,playTwo);
     playOne.setPlayerTurn();
     lb.setSpot(0,1);
     lb.setSpot(1, 1);
     lb.setSpot(2, 1);
     System.out.println(lb.toString());
     assertEquals("X",lb.getWinner());
 }
/*----------------------------------------------------------------------------------------------------
 * Test if vertical win condition is true third column
 */
 @Test public void verticalTest3()
 {
	 Player playOne= new Player("X");
     Player playTwo= new Player("O");
     LocalBoard lb= new LocalBoard(0,playOne,playTwo);
     playOne.setPlayerTurn();
     lb.setSpot(0,2);
     lb.setSpot(1, 2);
     lb.setSpot(2, 2);
     System.out.println(lb.toString());
     assertEquals("X",lb.getWinner());
 }        
}
