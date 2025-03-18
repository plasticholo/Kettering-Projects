/***********************************************************************************************
 * Class Name: LLNode
 * Author's Name: Will Erickson
 * Date: 9/16/24
 * Description of the class: Creates the structure for the node of a doubly linked list that
 * stores the book written by an author
 ***********************************************************************************************/
public class LLNode 
{
    //Necessary variables
    protected String info;

    protected LLNode forwardLink;
    protected LLNode backwardLink;

    //constructor
    public LLNode(String info)
    {
        this.info = info;
        this.backwardLink = null;
        this.forwardLink = null;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public String getInfo()
    {
        return info;
    }

    public void setForwardLink(LLNode link)
    {
        this.forwardLink = link;
    }

    public LLNode getForwardLink()
    {
        return forwardLink;
    }

    public void setBackwardLink(LLNode link)
    {
        this.backwardLink = link;
    }

    public LLNode getBackwardLink()
    {
        return backwardLink;
    }

    /*****************************************************************************
     * Method Name: hasNext
     * Returns: boolean
     * Input: N/A
     * Task: checks if the current node has another node
     ****************************************************************************/
    public boolean hasNext()
    {
        if(this.getForwardLink() != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
