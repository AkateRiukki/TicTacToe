package tictactoe;

/*Tic Tac Toe by Akate*/
import java.util.*;

public class tictactoe
{
   static String[] Board;
   static String XOMark;
   
   //checkWinner method
   static String checkWinner()
   {
       for (int i = 0; i < 8; i++)
       {
           String line = null;
           
           switch (i)
           {
               //basic board lineup (checkWinner Horizontal)
               case 0:
                   line = Board[0] + Board[1] + Board[2];
               break;
               
               case 1:
                   line = Board[3] + Board[4] + Board[5];
               break;
               
               case 2:
                   line = Board[6] + Board[7] + Board[8];
               break;
               
               //checkWinner Vertical
               case 3:
                   line = Board[0] + Board[3] + Board[6];
               break;
               
               case 4:
                   line = Board[1] + Board[4] + Board[7];
               break;
               
               case 5:
                   line = Board[2] + Board[5] + Board[8];
               break;
               
               //checkWinner Diagonal
               case 6:
                   line = Board[0] + Board[4] + Board[8];
               break;
               
               case 7:
                   line = Board[2] + Board[4] + Board[6];
               break;
           }
           
           //For X winner
           if (line.equals("XXX"))
           {
               return "X";
           }
           
           //For O winner
           else if (line.equals("OOO"))
           {
               return "O";
           }
           
           /*For Error
           
           else
           {
               System.out.println("Bruh y u bulli mi");
           }
           
           */
       }
       
           //if its a draw
           for (int i = 0; i < 9; i++)
           {
               if (Arrays.asList(Board).contains(String.valueOf(i + 1)))
               {
                   break;
               }
               else if ( i == 8)
               {
                   return "draw";
               }
           }
           
        //To put the XOMark ( X, your turn! Please enter a slot  number to place X in: / O, your turn! Please enter a slot  number to place O in: )
        System.out.println("\n" + XOMark + ", your turn! Please enter a slot number to place " + XOMark + " in: ");
        return null;
   }
   
   //To print out the board
   /*  1 | 2 | 3 
      ---|---|---
       4 | 5 | 6 
      ---|---|---
       7 | 8 | 9  */
       
   static void printBoard()
   {
       // 1 | 2 | 3
       System.out.println (" " + Board[0] + " | " + Board[1] + " | " + Board[2] + " ");
       
       // ---|---|---
       System.out.println ("---|---|---");
       
       // 4 | 5 | 6
       System.out.println (" " + Board[3] + " | " + Board[4] + " | " + Board[5] + " ");
       
       // ---|---|---
       System.out.println ("---|---|---");
       
       // 7 | 8 | 9
       System.out.println (" " + Board[6] + " | " + Board[7] + " | " + Board[8] + " ");
   }
   
   public static void main (String[] args)
   {
       Scanner in = new Scanner(System.in);
       Board = new String[9];
       XOMark = "X";
       String winner = null;
       
       for (int i = 0; i < 9; i++)
       {
           Board[i] = String.valueOf(i + 1);
       }
       
       System.out.println("Tic Tac Toe Challenge!\n");
       printBoard();
       
       System.out.println("\nX approaches menacingly! Yoink a number X!: ");
       
       while (winner == null)
       {
           int numInput;
           
           //Exception Handling
           //Error message if player places number not ranging from 1 to 9
           try
           {
               numInput = in.nextInt();
               if (!(numInput > 0 && numInput <=9))
               {
                System.out.println("Bruh. That's an invalid number! Re-enter a number between 1 to 9 my dudes: ");
                continue;
               }
           }
           
           catch (InputMismatchException e)
           {
               System.out.println("Bruh. That's an invalid number! Re-enter a number between 1 to 9 my dudes: ");
               continue;
           }
        
           //2 players; X and O.
           //Game logic (turn decision)
           if (Board[numInput - 1].equals(String.valueOf(numInput)))
           {
               Board[numInput - 1] = XOMark;
               
               if (XOMark.equals("X"))
               {
                   XOMark = "O";
               }
               else
               {
                   XOMark = "X";
               }
               
               printBoard();
               winner = checkWinner();
           }
           
           else
           {
               System.out.println("Get out of my swamp! Choose another number: ");
           }
       }
       
       //Nobody wins... issa draw~
       //Game logic (draw)
       if (winner.equalsIgnoreCase("draw"))
       {
           System.out.println("You got a draw... Oh well, thanks for playing~");
       }
       
       //Winner
       else
       {
           System.out.println("Chicken Dinner, " + winner + "? Thanks for playing");
       }
   }
}
