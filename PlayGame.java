import java.util.*;
import java.io.*;
import java.nio.charset.Charset;

public class PlayGame
{
  //Declare and Initialize variables
  static UltimateBoard gameBoard;
  static String newG;
  static boolean newGame;
  static int chosenMode;
  
  
  //Driver for Playing the Game
  public static void main(String[] args ) throws IOException
  {
    //Choose gamemodes, Play games, etc.
    gameBoard = new UltimateBoard();
    
    String line;
    String line2 = null;
    InputStream fis = new FileInputStream("/home/eadom/communication.txt");
    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    BufferedReader br = new BufferedReader(isr);
    
    while ((line = br.readLine()) == null) {
    //just waiting for option input
    }
    String[] command = line.split("\\s+");
    int chosenMode = Integer.parseInt(command[1]); 
    
    new FileWriter("/home/eadom/communication.txt").close();
    System.out.println(chosenMode);

    switch(chosenMode)
    {
      /*Player One begins game, with turn equals true
      Allow Player one to pick any spot on UltimateBoard
      The position chosen dictates the next local board to be used
      Whenever a local board is won, the game ends
      */
      case 1:
        
        //Player One picks a position (A local board and local board position)
        //How is this represented? Are we receiving a string or input from the click in the UI
        //Player Two picks a position in a local board dictated by the previous position
        //This should continue in a loop until one local board is won
        int localBoardNumber = 0;


        gameBoard.getPlayerOne().setPlayerTurn();
        while(!gameBoard.getBoardArr(localBoardNumber).isWon())
        {
        	// Added  by Eadom
         
        
while (1 == 1)
{
   InputStream fis1 = new FileInputStream("/home/eadom/communication.txt");
            InputStreamReader isr1 = new InputStreamReader(fis1, Charset.forName("UTF-8"));
            BufferedReader br1 = new BufferedReader(isr1);
line2 = br1.readLine();

if(line2 == null)
{
}
else
{
if(!line2.split("\\s+")[0].toString().equals("Feedback"))
{
break;
}
}
} 
System.out.println(line2.toString());


           // while ((line = br1.readLine()) == null || (line = br1.readLine()).equals("Feedback")) 
           // {
            //just waiting for option input
           // }
            String[] command1 = line2.split("\\s+");
            int row = Integer.parseInt(command1[1]);
            int col = Integer.parseInt(command1[2]);
            localBoardNumber=Integer.parseInt(command1[3]);
	    System.out.println(row);
	    System.out.println(col);
            		
          if(gameBoard.getBoardArr(localBoardNumber).isSpotEmpty(row, col))
          {
            int[] nextLBArr = gameBoard.getBoardArr(localBoardNumber).setSpot(row,col);
            gameBoard.getBoardArr(localBoardNumber).checkWon();
            
            if(gameBoard.getBoardArr(localBoardNumber).isWon())
            {
               //send to python playerOne won
            	 try 
                 {
                   BufferedWriter bw = null;
                   FileWriter fw = null;
                   int playerNumber;
                   if(gameBoard.getPlayerOne().getTurn())
                   {
                	   playerNumber=1;
                   }
                   else
                   {
                	   playerNumber=2;
                   }
                   String content = "Feedback 1 LocalBoardChange " + localBoardNumber + " LocalBoardWin 1 Won 1";

                   fw = new FileWriter("/home/eadom/communication.txt");
                   bw = new BufferedWriter(fw);
                   bw.write(content);
		
                   System.out.println("Sending random command in a single line");
                   if (bw != null)
                     bw.close();

                   if (fw != null)
                     fw.close();

                 }
                 catch (IOException e) 
                 {
                   e.printStackTrace();
                 }
           
              
            }
              else
              {
            	localBoardNumber = 3 * nextLBArr[0] + nextLBArr[1];
            	gameBoard.getPlayerOne().switchTurn();
            	gameBoard.getPlayerTwo().switchTurn();
                try 
                {
                  BufferedWriter bw = null;
                  FileWriter fw = null;

                  String content = "Feedback 1 LocalBoardChange " + localBoardNumber + " LocalBoardWin 0 Won 0";

                  fw = new FileWriter("/home/eadom/communication.txt");
                  bw = new BufferedWriter(fw);
                  bw.write(content);

                  System.out.println("Sending random command in a single line");
                  if (bw != null)
                    bw.close();

                  if (fw != null)
                    fw.close();

                }
                catch (IOException e) 
                {
                  e.printStackTrace();
                }

              
            }
          }
          else
          {
        	  try 
              {
                BufferedWriter bw = null;
                FileWriter fw = null;

                String content = "Feedback 0 LocalBoardChange " + localBoardNumber + " LocalBoardWin 0 Won 0";

                fw = new FileWriter("/home/eadom/communication.txt");
                bw = new BufferedWriter(fw);
                bw.write(content);

                System.out.println("Sending random command in a single line");
                if (bw != null)
                  bw.close();

                if (fw != null)
                  fw.close();

              }
              catch (IOException e) 
              {
                e.printStackTrace();
              }

          }
        }
        
        break;
      case 2:
        //Player On picks a position (A local board and local board position)
        //Player Two picks a position in a local board dictated by the previous position
        //This should continue in a loop until three local boards are won in a row
    	  int localBoardNumber1 = 0;



          gameBoard.getPlayerOne().setPlayerTurn();
          while(!gameBoard.isWon())
          {
              
            while (1 == 1)
{
   InputStream fis1 = new FileInputStream("/home/eadom/communication.txt");
            InputStreamReader isr1 = new InputStreamReader(fis1, Charset.forName("UTF-8"));
            BufferedReader br1 = new BufferedReader(isr1);
line2 = br1.readLine();

if(line2 == null)
{
}
else
{
if(!line2.split("\\s+")[0].toString().equals("Feedback"))
{
break;
}
}
} 
              String[] command2 = line2.split("\\s+");
            int row = Integer.parseInt(command2[1]);
            int col = Integer.parseInt(command2[2]);
            localBoardNumber1=Integer.parseInt(command2[3]);
              	
            if(gameBoard.getBoardArr(localBoardNumber1).isSpotEmpty(row, col))
            {
              int[] nextLBArr = gameBoard.getBoardArr(localBoardNumber1).setSpot(row,col);
		    
	      gameBoard.getBoardArr(localBoardNumber1).checkWon();
	      gameBoard.checkWon();
         	
              if(gameBoard.isWon())
              {
                 //send to python playerOne won
              	 try 
                   {
                     BufferedWriter bw = null;
                     FileWriter fw = null;
                     int playerNumber;
                     if(gameBoard.getPlayerOne().getTurn())
                     {
                  	   playerNumber=1;
                     }
                     else
                     {
                  	   playerNumber=2;
                     }
                     String content = "Feedback 1 LocalBoardChange " + localBoardNumber1 + " LocalBoardWon 1 Won 1";

                     fw = new FileWriter("/home/eadom/communication.txt");
                     bw = new BufferedWriter(fw);
                     bw.write(content);

                     System.out.println("Sending random command in a single line");
                     if (bw != null)
                       bw.close();

                     if (fw != null)
                       fw.close();

                   }
                   catch (IOException e) 
                   {
                     e.printStackTrace();
                   }
               
                   System.exit(0);
                
              }
                else
                {
                	 if(gameBoard.getBoardArr(localBoardNumber1).isWon())
                     {
                        //send to python playerOne won
                     	 try 
                          {
				gameBoard.getPlayerOne().switchTurn();
                		gameBoard.getPlayerTwo().switchTurn();

                     		localBoardNumber1 = 3 * nextLBArr[0] + nextLBArr[1];

  				if (gameBoard.getBoardArr(localBoardNumber1).isWon())
                                    {
                                        
                                      
                                        localBoardNumber1 = 0;
                                        while(gameBoard.getBoardArr(localBoardNumber1).isWon())
                                        {
                                            localBoardNumber1++;
                                        }
                                    }
                     		BufferedWriter bw = null;
                            FileWriter fw = null;



                            int playerNumber;
                            if(gameBoard.getPlayerOne().getTurn())
                            {
                         	   playerNumber=1;
                            }
                            else
                            {
                         	   playerNumber=2;
                            }
                            String content = "Feedback 1 LocalBoardChange " + localBoardNumber1 + " LocalBoardWon 1 Won 0";

                            fw = new FileWriter("/home/eadom/communication.txt");
                            bw = new BufferedWriter(fw);
                            bw.write(content);

                            System.out.println("Sending random command in a single line");
                            if (bw != null)
                              bw.close();

                            if (fw != null)
                              fw.close();

                          }
                          catch (IOException e) 
                          {
                            e.printStackTrace();
                          }
                     }
                	 else
                	 {
                		 localBoardNumber1 = 3 * nextLBArr[0] + nextLBArr[1];
  if (gameBoard.getBoardArr(localBoardNumber1).isWon())
                                    {
                                        
                                      
                                        localBoardNumber1 = 0;
                                        while(gameBoard.getBoardArr(localBoardNumber1).isWon())
                                        {
                                            localBoardNumber1++;
                                        }
                                    }
                		 gameBoard.getPlayerOne().switchTurn();
                		 gameBoard.getPlayerTwo().switchTurn();
                		 try 
                		 {
                			 BufferedWriter bw = null;
                			 FileWriter fw = null;

                			 String content = "Feedback 1 LocalBoardChange " + localBoardNumber1 + " LocalBoardWon 0 Won 0";

                			 fw = new FileWriter("/home/eadom/communication.txt");
                			 bw = new BufferedWriter(fw);
                			 bw.write(content);
                    
                			 System.out.println("Sending random command in a single line");
                			 if (bw != null)
                				 bw.close();

                			 if (fw != null)
                				 fw.close();

                		 }
                		 catch (IOException e) 
                		 {
                			 e.printStackTrace();
                		 }
                	 }
                }
            }
            else
            {
          	  try 
                {
                  BufferedWriter bw = null;
                  FileWriter fw = null;

                  String content = "Feedback 0 LocalBoardChange " + localBoardNumber1 + " LocalBoardWon 0 Won 0";

                  fw = new FileWriter("/home/eadom/communication.txt");
                  bw = new BufferedWriter(fw);
                  bw.write(content);

                  System.out.println("Sending random command in a single line");
                  if (bw != null)
                    bw.close();

                  if (fw != null)
                    fw.close();

                }
                catch (IOException e) 
                {
                  e.printStackTrace();
                }
            }
          }
        break;
    }
  }
}

