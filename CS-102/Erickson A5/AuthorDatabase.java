/***********************************************************************************************
 * Class Name: AuthorDatabase
 * Author's Name: Will Erickson
 * Date: 9/16/24
 * Description of the class: Creates new data type that stores author's name as well as a reference
 * to the head of a doubly linked list that contains the books theyve wrote
 ***********************************************************************************************/
import java.util.*;
import java.io.*;

 public class AuthorDatabase 
{
    //creates array to store authors
    private Node[] authorList;
    private int authorCount;

    //constructor
    public AuthorDatabase(int size)
    {
        authorList = new Node[size];
        authorCount = 0;
    }

    //main method
    public static void main(String[] args) 
    {
        //checks if arguments are correct
        if(args.length != 1)
        {
            System.out.println("Invalid arguments");
            return;
        }

        //declaring variables
        String fileName = args[0];
        String line;
        
        //try-catch to catch io exception
        try
        {
            //creates authordatabase object
            AuthorDatabase adb = new AuthorDatabase(100);

            //creates a buffered reader to read the file
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            //while loop to read each line
            while((line = br.readLine()) != null)
            {
                String[] parts = line.split("-");
                
                //sets to variables
                String author = parts[0];
                String book = parts[1];

                //uses the variables to create new entry
                adb.addABook(author, book);
            }
            //closes the buffered reader
            br.close();

            //prints unsorted database
            System.out.println("Database before sort: ");
            adb.printBookList();

            //calls insertion sort method
            adb.sortByAuthor();

            //for loop to sort each author's books
            for(int i = 0; i< adb.authorCount; i++)
            {
                //calls bubble sort method
                adb.sortBooksBySingleAuthor(adb.authorList[i].getAuthor());
            }
            //prints sorted database
            System.out.println("Sorted database: ");
            adb.printBookList();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /*****************************************************************************
     * Method Name: addABook
     * Returns: void
     * Input: String author, String book
     * Task: adds a book to the list attached to the author that wrote it
     ****************************************************************************/
    public void addABook(String author, String book)
    {
        //searches the array for the author and sets it to a variable
        Node authorNode = findAuthor(author);

        //checks if the given author exists
        if(authorNode == null)
        {
            //creates new node for the author
            authorNode = new Node(author);

            //increases author count and adds author to the array
            authorList[authorCount++] = authorNode;
        }
        
        //adds the given book to the author's list
        authorNode.addBook(book);
    }
    
    /*****************************************************************************
     * Method Name: printBookList
     * Returns: void
     * Input: N/A
     * Task: Prints the list of all authors and their books
     ****************************************************************************/
    public void printBookList()
    {
        //for loop to traverse the array
        for(int i =0; i<authorCount; i++)
        {
            //prints books written by an author
            System.out.println("Books written by " + authorList[i].getAuthor()+":");
            authorList[i].printBooks();
        }
    }
    
    /*****************************************************************************
     * Method Name: sortByAuthor
     * Returns: void
     * Input: N/A
     * Task: uses insertion sort to sort the array of authors alphabetically
     ****************************************************************************/
    public void sortByAuthor()
    {
        //for loop to traverse through array
        for(int i = 1; i< authorCount; i++)
        {
            //swapnode acts as key to compare against
            Node swapNode = authorList[i];
            //variable to traverse the sorted section of the array
            int j = i-1;
            
            //while loop to run comparisons
            while(j >= 0 && authorList[j].getAuthor().compareTo(swapNode.getAuthor()) > 0)
            {
                //moves the elements to the sorted section of the array
                authorList[j+1] = authorList[j];
                j=j-1;
            }
            //re-inserts the key
            authorList[j+1] = swapNode;
        }
    }

    /*****************************************************************************
     * Method Name: sortBooksBySingleAuthor
     * Returns: boolean
     * Input: author
     * Task: sorts the list of books for a given author
     ****************************************************************************/
    public void sortBooksBySingleAuthor(String author)
    {
        //looks for suthor in array
        Node authorNode = findAuthor(author);
        
        //if to check if node exists before sorting
        if(authorNode != null)
        {
            //sorts books
            authorNode.bubbleSort();
        }
    }
    
    /*****************************************************************************
     * Method Name: findAuthor
     * Returns: Node
     * Input: author
     * Task: searches the array of authors for a specific author
     ****************************************************************************/
    public Node findAuthor(String author)
    {
        //for loop to traverse the array and check for author
        for(int i=0; i<authorCount; i++)
        {
            //check to see if the current node is the author
            if(authorList[i].getAuthor().equals(author))
            {
                return authorList[i];
            }
        }
        //returns nothing if author not found
        return null;
    }
}
