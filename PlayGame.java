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
    InputStream fis = new FileInputStream("/home/eadom/communication.txt");
    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
    BufferedReader br = new BufferedReader(isr);
    
    while ((line = br.readLine()) == null) {
    //just waiting for option input
    }
    String[] command = line.split("\\s+");
    int chosenMode = Integer.parseInt(command[1]); 

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
            InputStream fis1 = new FileInputStream("/home/eadom/communication.txt");
            InputStreamReader isr1 = new InputStreamReader(fis1, Charset.forName("UTF-8"));
            BufferedReader br1 = new BufferedReader(isr1);
            
            while ((line = br1.readLine()) == null) 
            {
            //just waiting for option input
            }
            String[] command1 = line.split("\\s+");
            int row = Integer.parseInt(command[0]);
            int col = Integer.parseInt(command[1]);
            localBoardNumber=Integer.parseInt(command[2]);
            		
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
                   String content = "Won " + playerNumber;

                   fw = new FileWriter(FILENAME);
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
            	localBoardNumber = 3 * nextLBArr[0] + nextLBArr[1];
            	gameBoard.getPlayerOne().switchTurn();
            	gameBoard.getPlayerTwo().switchTurn();
                try 
                {
                  BufferedWriter bw = null;
                  FileWriter fw = null;

                  String content = "Feedback True Localboard "+localBoardNumber;

                  fw = new FileWriter(FILENAME);
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

                String content = "Feedback False";

                fw = new FileWriter(FILENAME);
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
          	// Added  by Eadom
              InputStream fis1 = new FileInputStream("/home/eadom/communication.txt");
              InputStreamReader isr1 = new InputStreamReader(fis1, Charset.forName("UTF-8"));
              BufferedReader br1 = new BufferedReader(isr1);
              
              while ((line = br1.readLine()) == null) 
              {
              //just waiting for option input
              }
              String[] command1 = line.split("\\s+");
              int row = Integer.parseInt(command[0]);
              int col = Integer.parseInt(command[1]);
              localBoardNumber1=Integer.parseInt(command[2]);
              		
            if(gameBoard.getBoardArr(localBoardNumber1).isSpotEmpty(row, col))
            {
              int[] nextLBArr = gameBoard.getBoardArr(localBoardNumber1).setSpot(row,col);
         
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
                     String content = "Won " + playerNumber;

                     fw = new FileWriter(FILENAME);
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
                	 if(gameBoard.getBoardArr(localBoardNumber).isWon())
                     {
                        //send to python playerOne won
                     	 try 
                          {
                     		localBoardNumber = 3 * nextLBArr[0] + nextLBArr[1];
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
                            String content = "LocalWon " + playerNumber + " " + localBoardNumber;

                            fw = new FileWriter(FILENAME);
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

                			 String content = "Feedback True Localboard "+localBoardNumber;

                			 fw = new FileWriter(FILENAME);
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

                  String content = "Feedback False";

                  fw = new FileWriter(FILENAME);
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
      default:
        while(chosenMode != 1 || chosenMode != 2)
        {
          System.out.println("Error: Chosen mode number not recognized. Enter new input:");
          chosenMode = sc.nextInt();
        }
        
    }
  }
}
