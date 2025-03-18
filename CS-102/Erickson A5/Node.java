/***********************************************************************************************
 * Class Name: Node
 * Author's Name: Will Erickson
 * Date: 9/16/24
 * Description of the class: Creates new data type that stores author's name as well as a reference
 * to the head of a doubly linked list that contains the books theyve wrote
 ***********************************************************************************************/
public class Node
{
    //declaring variables
    public String author;
    public LLNode head;
    
    public Node(String author)
    {
        this.author = author;
        this.head = null;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }

    public LLNode getHead()
    {
        return head;
    }

    public void setHead(LLNode head)
    {
        this.head = head;
    }
    
    /*****************************************************************************
     * Method Name: addBook
     * Returns: void
     * Input: book
     * Task: adds a book to the linked list
     ****************************************************************************/
    public void addBook(String book)
    {
        //creates required variables
        LLNode current = head;
        LLNode newBook = new LLNode(book);

        //checks if list is empty before adding
        if(head == null)
        {
            //if empty the new node is set to the head
            head = newBook;
        }
        else
        {
            //while loop to traverse the linked list
            while(current.hasNext())
            {
                current = current.getForwardLink();
            }
            
            //sets required links
            current.setForwardLink(newBook);
            newBook.setBackwardLink(current);
        }
    }
    /*****************************************************************************
     * Method Name: printBooks
     * Returns: void
     * Input: N/A
     * Task: prints all books in an authors linked list
     ****************************************************************************/
    public void printBooks()
    {
        //temp variable to traverse linked list
        LLNode current = head;

        //while loop to traverse and print
        while(current.hasNext())
        {
            //prints current node
            System.out.println(current.getInfo());
            //moves to next node
            current = current.getForwardLink();
        }

        //prints final node not included in while loop
        System.out.println(current.getInfo());
    }

    /*****************************************************************************
     * Method Name: bubbleSort
     * Returns: void
     * Input: N/A
     * Task: uses bubble sort to sort the books written by an author
     ****************************************************************************/
    public void bubbleSort()
    {
        //if to check if the list only has one variable
        if(head.getForwardLink() == null)
        {
            return;
        }

        //declaring variables
        LLNode current;
        boolean swapped = true;

        //while loop that ends sort after the list is completely sorted
        while(swapped)
        {
            //sets current node to head
            current = head;
            
            //sets swapped to false to prevent infinite loop
            swapped = false;

            //while loop to traverse list and swap
            while(current.hasNext())
            {
                //if statement to compare the two books alphabetically
                if(current.getInfo().compareTo(current.getForwardLink().getInfo())>0)
                {
                    //temp variable to store swapped title
                    String tempTitle = current.getInfo();

                    //swaps the titles
                    current.setInfo(current.getForwardLink().getInfo());
                    current.getForwardLink().setInfo(tempTitle);

                    //sets swapped to treu to continue loop
                    swapped = true;
                }

                current = current.getForwardLink();
            }
        }
    }
}