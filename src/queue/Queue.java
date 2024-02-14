package queue;
import list.*;

/**
 *An implementation of QueueADT, with a LinkedList
 *
 * @author SDB & Vincent Vaccaro
 */
public class Queue<E> implements QueueADT<E>
{
    List<E> list = new LinkedList<E>();

    public void add(E value)
    {
        list.add(value);
    }

    public E peek()
    {
        if(list.isEmpty())
        {
            return null;
        }
        return list.get(0);
    }

    public E remove()
    {
        return list.remove(0);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public String toString()
    {
        return list.toString();
    }

    public void clear()
    {
        list.clear();
    }

    public int size()
    {
        return list.size();
    }
}
