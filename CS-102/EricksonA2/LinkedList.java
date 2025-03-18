import java.util.NoSuchElementException;
import java.util.spi.LocaleNameProvider;

/***********************************************************************************************
 * Class Name: LinkedList
 * Author's Name: Will Erickson
 * Date: 8/6/24
 * Description of the class: A class that defines several functions necessary for a linked list
 ***********************************************************************************************/

public class LinkedList<T>
{
    //declaring variables
    public LLNode<T> head;
    public LLNode<T> tail;


    //constructor
    public LinkedList()
    {
        head = null;
        tail = null;
    }



    /*****************************************************************************
     * Method Name: addLast
     * Returns: void
     * Input: T info
     * Task: Adds a node to the end of the linked list
     ****************************************************************************/
    public void addLast(T info)
    {
        //declaring new node variable
        LLNode<T> newNode = new LLNode<T>(info);

        
        //checks if there is already a tail so that 
        if(tail==null)
        {
            head = newNode;
        }
        else
        {
            tail.setLink(newNode);
        }
        
        //sets the new tail
        tail = newNode;
    }
     
    /*****************************************************************************
     * Method Name: addFirst
     * Returns: void
     * Input: T info
     * Task: Adds a node to the front of the linked list
     ****************************************************************************/
    public void addFirst(T info)
    {
        LLNode<T> newNode = new LLNode<T>(info);

        if(head==null)
        {
            head = newNode;
        }
        else
        {
            newNode.setLink(head);
        }

        //Sets the new head
        head = newNode;
    }

      /*****************************************************************************
     * Method Name: add
     * Returns: void
     * Input: T info, int index
     * Task: Allows the user to add a node anywhere in the Linked List
     ****************************************************************************/
    public void add(T info, int index) throws IndexOutOfBoundsException
    {
        //declaring new node variable
        LLNode<T> newNode = new LLNode<T>(info);
        
        //checks for valid index input
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("Index must be greater than 0");
        }

        if (index == 0)
        {
            //case if the head is the selected node
            newNode.setLink(head);
            head = newNode;

            //if list is empty sets tail
            if (tail == null)
            {
                tail = newNode;
            }
            
            //ends method early to prevent errors
            return;
        }

        //Selected variable to traverse LL
        LLNode<T> selected = head;

        //traverses to the selected index
        for(int i = 1; i < index; i++)
        {
            selected = selected.getLink();
        }

        //inserts the new node
        newNode.setLink(selected.getLink());
        selected.setLink(newNode);

        //sets to tail if needed
        if(newNode.getLink() == null)
        {
            tail = newNode;
        }
    }

      /*****************************************************************************
     * Method Name: removeFirst
     * Returns: T
     * Input: N/A
     * Task: Removes the head of the Linked List
     ****************************************************************************/
    public T removeFirst()
    {
        //throws exception if the list is empty
        if(head == null)
        {
            throw new NoSuchElementException("Operation cannot be performed on an empty list");
        }

        //creates deletedNode variable to be able to return it
        LLNode<T> deletedNode = head;
        
        //sets new head
        head = head.getLink();

        //nulls out tail if list is empty
        if (head == null)
        {
            tail = null;
        }

        //returns the deleted node's info
        return deletedNode.info;
    }
    
     /*****************************************************************************
     * Method Name: removeLast
     * Returns: T
     * Input: N/A
     * Task: Removes the tail of the Linked List
     ****************************************************************************/
    public T removeLast()
    {
        
        //case if LL does not exist
        if(tail == null)
        {
            throw new NoSuchElementException("Operation cannot be performed on an empty list");
        }

        //case if the head is also the tail
        if(head == tail)
        {
            //creates deletedNode variable to be able to return it
            LLNode<T> deletedNode = head;
            
            //clears head and tail variables to avoid errors
            head = null;
            tail = null;

            //returns the deleted node's info
            return deletedNode.getInfo();
        }

        //variable to traverse the LL
        LLNode<T> selected = head;

        //while loop to traverse the LL
        while(selected.getLink() != tail)
        {
            selected = selected.getLink();
        }

        //stores the deleted info
        LLNode<T> deletedNode = tail;

        //sets new tail
        tail = selected;
        tail.setLink(null);

        //returns the deleted info
        return deletedNode.getInfo();
    }
    
    
    /*****************************************************************************
     * Method Name: remove
     * Returns: T
     * Input: int index
     * Task: removes a node from anywhere in the LL and returns it's info
     ****************************************************************************/
    public T remove(int index) throws IndexOutOfBoundsException
    {

        //case if the entered input is less than 0
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("Entered index must be more than 0");
        }

        //case if the LL is empty
        if(head==null)
        {
            throw new NoSuchElementException("Cannot delete from an empty list");
        }
        
        //case for if index is the same as the head
        if (index == 0)
        {
            //stores the old head as a seperate variable
            LLNode<T> deletedNode = head;
            
            //sets new head
            head= head.getLink();

            //prevents tail from having a value if list is empty
            if(head == null)
            {
                tail = null;
            }

            return deletedNode.getInfo();
        }

        //declaring variables to traverse the LL
        LLNode<T> selected = head;
        int currentIndex = 0;
        
        //loop to traverse to the index location
        while(selected != null && currentIndex < index-1)
        {
            //traverse the LL
            selected = selected.getLink();

            //increments currentIndex
            currentIndex++;
        }

        //prevents too large an index
        if(selected==null || selected.getLink()==null)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //stores the deleted data
        LLNode<T> deletedNode = selected.getLink();

        //reattaches list
        selected.setLink(deletedNode.getLink());

        //sets tail if tail was deleted
        if(deletedNode == tail)
        {
            tail = selected;
        }

        //returns delted info
        return deletedNode.getInfo();
    }

    /*****************************************************************************
     * Method Name: get
     * Returns: T
     * Input: int index
     * Task: gets the info from any node in the linked list
     ****************************************************************************/
    public T get(int index) throws IndexOutOfBoundsException
    {
        //case if index <0
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("Index must be greater than 0");
        }

        //declaring variables for navigating the LL
        LLNode<T> selected = head;
        int currentIndex = 0;

        while(selected != null && currentIndex < index)
        {
            //traverses the LL
            selected = selected.getLink();
            
            //iteratates current Index
            currentIndex++;
        }

        //makes sure the selected node exists
        if(selected == null)
        {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        //returns the info
        return selected.getInfo();
    }

    //gets the info from the first node
    public T getFirst()
    {
        return head.info;
    }

    //returns the info from the tail node 
    public T getLast()
    {  
        return tail.info;
    }

    /*****************************************************************************
     * Method Name: contains
     * Returns: imt
     * Input: T info
     * Task: Returns the index of the first appearence of data, returns -1 otherwise
     ****************************************************************************/
    public int contains(T info)
    {
        LLNode<T> selected = head;
        int index = 0;


        while(selected != null)
        {
            //checks if the info matches
            if (selected.getInfo().equals(info))
            {
                //returns the info
                return index;
            }

            //sets to next link
            selected = selected.getLink();

            //increments index var
            index++;
        }

        //returns -1 if info not found
        return -1;
    }

    public String toString()
    {
        //declaring required vars
        StringBuilder sb = new StringBuilder();
        LLNode<T> selected = head;


        //while loop to traverse the linked list
        while(selected != null)
        {
            //adds to the string
            sb.append(selected.getInfo()).append("\n");

            //traverse to the next node
            selected = selected.getLink();
        }

        //returns info
        return sb.toString();
    }

    public int getSize()
    {
        int total = 0;
        LLNode<T> selected = head;


        //while loop to traverse list
        while (selected != null)
        {
            //increments total
            total++;

            //traverses list
            selected = selected.getLink();
        }
        
        //returns total
        return total;
    }
}
