import java.io.*;
import java.util.*;

/***********************************************************************************************
 * Class Name: A3
 * Author's Name: Will Erickson
 * Date: 8/21/23
 * Description of the class: Identifies and labels blocks of white cells in a n x n mesh where cells
 * are either black or white.
 ***********************************************************************************************/
public class A3
{
    //declaring variables that are used in multiple methods
    private static int n;
    private static char[][] mesh;
    private static int blockNum = 1;

     /*****************************************************************************
     * Method Name: main
     * Returns: void
     * Input: String[] args
     * Task: Reads an input file and marks blocks of white cells then exports it as
     * a text file
     ****************************************************************************/
    public static void main(String[] args) 
    {
        
        //checking if arguments were correctly provided
        if (args.length != 2)
        {
           //displays exit message and exits the main method
            System.out.println("Incorrect arguments");
            return;
        }

        //setting the arguments to their respective variables
        n = Integer.parseInt(args[0]);
        String fileName = args[1];

        //creates the array to be filled
        mesh = new char[n][n];

        try
        {
            //creates a buffered reader to read the input file
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        for(int i = 0; i < n; i++)
        {
            //temp variable to store the line that was read
            String readLine = br.readLine().trim().replaceAll("\\s+", "");

            //
            for(int j = 0; j<n; j++)
            {
                mesh[i][j] = readLine.charAt(j);
            }
        }
        
        //calls the function to find the blocks
        findBlocks();

        //closes the bufferedreader
        br.close(); 

        //creates buffered writer to write to the output file
        BufferedWriter bw = new BufferedWriter(new FileWriter("Output.txt"));

        //iterates through the array
        for(int i=0; i < n; i++)
        {
            for(int j= 0; j < n; j++)
            {
                //writes to the file
                bw.write(mesh[i][j]);
            }
             //moves on to the next line
             bw.newLine();
        }
         //closes the writer
         bw.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }


     /*****************************************************************************
     * Method Name: findBlocks
     * Returns: void
     * Input: N/A
     * Task: Iterates through the mesh and calls the recursive function labelBlock
     ****************************************************************************/
    private static void findBlocks()
    {
        //nested for loop to iterate through both the row and column
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                //checks if cell is white
                if(mesh[i][j] == 'W' || mesh[i][j] == 'w')
                {
                    //calls the recursive method
                    labelBlock(i, j, blockNum);
                    
                    //increments the block number
                    blockNum++;
                }
            }
        }
    }

     /*****************************************************************************
     * Method Name: labelBlock
     * Returns: void
     * Input: int row, int column, int blockNum
     * Task: Recursive method that navigates each direction from the original cell
     ****************************************************************************/
    private static void labelBlock(int row, int column, int blockNum)
    {
        //Base Case to end recursion
        if(row < 0 || row >= n || column < 0 || column >= n)
        {
            return;
        }
        //checks if the selected cell is white
        if(mesh[row][column] == 'w' || mesh[row][column] == 'W')
        {
            //sets the cell to the block number
            mesh[row][column] = (char) ('0' + blockNum);

            //checks the cell above
            labelBlock(row+1, column, blockNum);
            //checks the cell below
            labelBlock(row-1, column, blockNum);
            //checks the cell to the right
            labelBlock(row, column+1, blockNum);
            //checks the cell to the left
            labelBlock(row, column-1, blockNum);
        }
    }
}