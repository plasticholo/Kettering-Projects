import java.io.*;
import java.util.Scanner;

/***********************************************************************************************
 * Class Name: Main
 * Author's Name: Will Erickson
 * Date: 8/8/24
 * Description of the class: This class uses a linked list to edit a set of entries from a file
 * as well as a variety of other functions
 ***********************************************************************************************/
public class Main 
{
    //main function
    public static void main(String[] args) 
    {
        //case if args not entered before running
        if(args.length != 1)
        {
            System.out.println("No arguments provided");
            return;
        }

        //saves filename to variable
        String filename = args[0];

        //creates new linked list
        LinkedList<String> fileContent = new LinkedList<>();

        //saves file to file variable
        File file = new File(filename);

        //loads file if it is a valid file
        if(file.exists())
        {
            try (BufferedReader br = new BufferedReader(new FileReader(file)))
            {
                String line;
                while ((line = br.readLine())!=null)
                {
                    fileContent.addLast(line);
                }
            }
            catch(IOException e)
            {
                System.out.println("File couldn't be read " + e.getMessage());
            }
        }

        //declaring more vars + scanner
        Scanner scan = new Scanner(System.in);
        boolean running = true;


        //while loop that runs main options menu and displays file
        while (running)
        {
            //displays file
            //traces where you are in linked list
            LLNode<String> selected = fileContent.head;

            //variable to track the current line
            int line = 1;

            //prints each line one by one
            while(selected!=null)
            {
                System.out.println(line+") " + selected.getInfo());
                selected = selected.getLink();
                line++;
            }

            //creates blank line
            System.out.println();

            //options
            System.out.println("g word 1 word2 -- globally replace all words, word1 with word2 in the file");
            System.out.println("a text -- add a line tothe end of the file. User provides the string text.");
            System.out.println("i n text -- insert a line at the line number n. User provides the number n and the string text.");
            System.out.println("r n -- remove the ine number n. User provides the number n");
            System.out.println("c n text -- (change) replace the line number n with string text. User provides the number n and string text");
            System.out.println("l -- print the number of lines in the file.");
            System.out.println("s -- save file to disk");
            System.out.println("q -- quit the program");

            //reads user input
            String input = scan.nextLine();
            String[] parts = input.split(" ", 3);

            //commands
            //replace all words word 1 with word 2
            if(parts[0].equals("g"))
            {
                //checks for the correct input
                if(parts.length == 3)
                {
                    //stores input for word1/word2
                    String word1 = parts[1];
                    String word2 = parts[2];

                    //resets slected variable to traverse linked list
                    selected = fileContent.head;

                    while(selected != null)
                    {
                        //creates new info for use
                        String newLine = selected.getInfo().replace(word1, word2);
                        
                        //sets new info
                        selected.setInfo(newLine);
                        selected= selected.getLink();
                    }
                }
            }
            //adds a line to the end of the file
            else if(parts[0].equals("a"))
            {
                //checks for correct input
                if(parts.length == 2)
                {
                    //sets text variable
                    String text = parts[1];
                    
                    //adds to the end of the file
                    fileContent.addLast(text);
                }
            }
            //inserts a line into the file at a line number
            else if(parts[0].equals("i"))
            {
                //checks for correct input
                if(parts.length==3)
                {
                    //sets input to variables
                    int n = Integer.parseInt(parts[1]);
                    String text = parts[2];

                    //adds to the file at the line number
                    try
                    {
                        fileContent.add(text, n-1);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Invalid line number");
                    }
                }
            }
            //removes the line at a line number
            else if(parts[0].equals("r"))
            {
                //checks for correct input
                if (parts.length == 2)
                {
                    //sets n variable
                    int n = Integer.parseInt(parts[1]);

                    //removes the line
                    try
                    {
                        fileContent.remove(n-1);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Invalid line number");
                    }
                }
            }
            //changes the old line to a new line
            else if(parts[0].equals("c"))
            {
                //checks for correct input
                if(parts.length == 3)
                {
                    //converts input to variable
                    int n = Integer.parseInt(parts[1]);
                    String text = parts[2];

                    try
                    {
                        fileContent.remove(n-1);
                        fileContent.add(text, n-1);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("invalid line number");
                    }
                }
            }
            //prints the number of lines
            else if(parts[0].equals("l"))
            {
                System.out.println("There are "+ fileContent.getSize() + " lines");
            }
            //saves to the file
            else if(parts[0].equals("s"))
            {
                //creates a buffered writer to write to the file
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
                {
                    bw.write(fileContent.toString());
                    System.out.println("File successfully saved");
                }
                catch(IOException e)
                {
                    System.out.println("Error saving file"+ e.getMessage());
                }
            }
            //quits program
            else if(parts[0].equals("q"))
            {
                running = false;
            }
            //if input does not match a command
            else
            {
                System.out.println("invalid command");
            }

        }
        //closes scanner
        scan.close();
    }
}
