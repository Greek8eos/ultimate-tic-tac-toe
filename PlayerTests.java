import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
* Class to unit test methods in the Player class.
*
* To run in Terminal use: 
* javac -cp .:junit.jar *.java
* java -cp .:junit.jar PlayerTests
*/
public class PlayerTests
{
  public static void main(String args[])
  {
    org.junit.runner.JUnitCore.main("PlayerTests");
  }

/*-------------------------------------------------------------------------------------------------
* Tests for Player(String symbol) constuctor.
*/
  //Tests the  Player constuctor with a null String.
  @Test public void playerConstuctorTest1()
  {
    Player playOne = new Player(null);
    assertEquals(null, playOne.getSymbol());
  }

  //Tests the  Player constuctor with a non-null String.
  @Test public void playerConstuctorTest2()
  {
    Player playOne = new Player("X");
    assertEquals("X", playOne.getSymbol());
  }

  //Tests the  Player constuctor with a two Player objects.
  @Test public void playerConstuctorTest3()
  {
    Player playOne = new Player("O");
    Player playTwo = new Player("X");

    assertEquals("O", playOne.getSymbol());
    assertEquals("X", playTwo.getSymbol());
  }  
}