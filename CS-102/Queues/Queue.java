import ch04.queues.QueueOverflowException;

public class Queue 
{
    protected final int maxCapacity = 100;
    protected T[] elements;
    protected int backIndex;
    protected int frontIndex;


    public Queue()
    {
        protected T[] elements = (T[]) new Object[maxCapacity];
    }

    public void enqueue(T info)throws QueueOverflowException
    {
        if(backIndex==maxCapacity-1)
        {
            throw new QueueOverflowException("Cannot add, queue is full");
        }
        
        backIndex++;
        elements[backIndex] = info;
    }

    public T dequeue() throws QueueUnderflowException
    {

    }
}
