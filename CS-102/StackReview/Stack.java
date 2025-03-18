import java.util.*;

public class Stack
{
    protected final int maxCapacity = 100;
    protected T[] elements;
    protected int topIndex = -1;

    public Stack()
    {
        elements = (T[]) new Object[maxCapacity];
    }
    
    public void push(Object info) throws IllegalStateException
    {
        if(isFull())
        {
            throw new IllegalStateException("Cannot add onto a full stack");
        }

        topIndex++;
        elements[topIndex] = info;
    }

    public void pop()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Cannot remove from an empty stack");
        }

        elements[topIndex] = null;
        topIndex--;
    }

    public Object top()
    {
        if(isEmpty()) 
        {
            return null;
        }
        else
        {
            return elements[topIndex];
        }
    }

    public boolean isEmpty()
    {
        if(topIndex == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isFull()
    {
        if(topIndex == maxCapacity-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        for(int i= 0; i <= topIndex; i++)
        {
            sb.append(elements[i]);
        }

        return sb.toString();
    }
}