/***********************************************************************************************
 * Class Name: LinkedList
 * Author's Name: Will Erickson
 * Date: 8/6/24
 * Description of the class: A class that defines the functions necessary for a linked list node
 ***********************************************************************************************/

 public class LLNode<T>
 {   
    //defining variables
    protected T info;
    protected LLNode<T> link;
    
    //constructor method
    public LLNode(T info)
    {
        this.info = info;
        link = null;
    }

    //set method for info
    public void setInfo(T info)
    {
        this.info = info;
    }

    //get method for info
    public T getInfo()
    {
        return info;
    }

    //set method for link
    public void setLink(LLNode<T> link)
    {
        this.link = link;
    }

    //get method for link
    public LLNode<T> getLink()
    {
        return link;
    }
 }