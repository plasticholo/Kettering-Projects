import java.util.*;
// Will Erickson
// CS-203
// Winter 2025

public class SolverNQueens 
{
    public static void main(String[] args) 
    {
        //declaring necessary variables
        boolean solved = false;
        
        Random random = new Random();
        


        //Creates scanner to ask for the number of queens to solve for
        Scanner scan = new Scanner(System.in);

        System.out.println("How many queens would you like to solve for");
        int queens = scan.nextInt();

        scan.close(); 
        int[][] board = new int[queens][queens];

        long startTime = System.nanoTime();

        //checks to make sure the number of queens is in the range
        if(queens<4)
        {
            System.out.println("The number of queens must be greater than 3");
            return;
        }

        //Iterates through each column and places a queen randomly
        for(int column = 0; column<queens; column++)
        { 
            int row = random.nextInt(queens);
            
            board[row][column] = 1;
        }

        //tracks iterations to prevent infinite loop
        int iterations = 0;

        //main function to rearrange queens until solved
        while (!solved && iterations<1000000)
        {
            iterations++;
            
            int maxAttacks= 0;
            int worstRow = -1;
            int worstColumn = -1;

            //iterates through each column  and row to locate the most attacked queen
            for(int column=0; column<queens; column++)
            {
                for(int row=0; row<queens; row++)
                {
                    if(board[row][column]==1)
                    {
                        int numofAttacks = countAttacks(board, row, column, queens);

                        //checks to see if this is the most attacked queen
                        if(numofAttacks>maxAttacks)
                        {
                            maxAttacks=numofAttacks;
                            worstRow = row;
                            worstColumn = column;
                        }
                    }
                }
            }

            //ends if there are no attacks
            if(maxAttacks==0)
            {
                solved = true;
                break;
            }

            //finds the best row for the worst queen
            int bestRow = 0;
            int minAttacks = 100;

            for(int row = 0; row<queens; row++)
            {
                //skips the queens current postion
                if(board[row][worstColumn]==1)
                {
                    
                }
                else
                {
                    int numberOfAttacks= countAttacks(board, row, worstColumn, queens);

                    if(numberOfAttacks < minAttacks)
                    {
                        minAttacks = numberOfAttacks;
                        bestRow = row;
                    }
                }
                
            }

            //moves the queen to the new best postion
            board[worstRow][worstColumn]=0;
            board[bestRow][worstColumn]=1;
            
        }

        if(iterations==10000)
        {
            System.out.println("Too many iterations program ending");
            return;
        }

        long endTime = System.nanoTime();
        long duration = endTime-startTime;
        System.out.println("Execution time: "+duration+"ns");

        //prints the final solution
        System.out.println("Final solved board:");
        
        for(int i=0;i<queens;i++)
        {
            for(int j=0; j<queens; j++)
            {
                System.out.print(board[i][j] +" ");
            }
            System.out.println();

        }
        
    }
    
    /* countAttacks
    * Method used to count for attacks by checking for 1's on the board
    * Input: int[][]board, int row, int column, int queens
    * Output: int value */
    public static int countAttacks(int[][]board, int row, int column, int queens)
    {
        //variable to hold the amount of times the queen is attacked
        int numberOfAttacks = 0;

        //checks the current row for attacks
        for(int x = 0; x<queens; x++)
        {
            //prevents counting of itself
            if(x==column)
            {

            }
            else
            {
                if(board[row][x]==1)
                {
                    numberOfAttacks++;
                }
            }
        }

        //diagonal checks for attacks
        //top left diagonal
        int x = row-1;
        int y = column -1;

        while(x>=0 && y>=0)
        {
            //checks for queen
            if(board[x][y]==1)
            {
                numberOfAttacks++;
            }
            
            //moves to the next postion diagonally
            x--;
            y--;
        }

        //top right diagonal
        x = row-1;
        y = column +1;

        while(x>=0 && y<queens)
        {
            //checks for queen
            if(board[x][y]==1)
            {
                numberOfAttacks++;
            }
            
            //moves to the next postion diagonally
            x--;
            y++;
        }

        //bottom right diagonal
        x = row+1;
        y = column +1;

        while(x<queens && y<queens)
        {
            //checks for queen
            if(board[x][y]==1)
            {
                numberOfAttacks++;
            }
            
            //moves to the next postion diagonally
            x++;
            y++;
        }

        //bottom left diagonal
        x = row+1;
        y = column -1;

        while(x<queens && y>=0)
        {
            //checks for queen
            if(board[x][y]==1)
            {
                numberOfAttacks++;
            }
            
            //moves to the next postion diagonally
            x++;
            y--;
        }

        //returns the total count of the attacks
        return numberOfAttacks;
    }
}