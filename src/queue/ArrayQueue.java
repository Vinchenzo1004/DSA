package queue;
import list.*;

/**
 * A QueueADT using an ArrayList
 *
 * @author SDB & Vincent Vaccaro
 */
public class ArrayQueue<E> implements QueueADT<E>
{
    List<E> list = new ArrayList<E>();
    int size, front, back = 0; //"size" is size of queue

    public void add(E value)
    {
        if(size == list.size())
        {
            list.add(back, value);
            front = (front + 1) % list.size();
        }
        else
        {
            list.set(back, value);
        }
        back = (back + 1) % list.size();
        size++;
    }

    public E peek()
    {
        if(size == 0)
        {
            return null;
        }
        return list.get(front);
    }

    public E remove()
    {
        E result = list.get(front);
        front = (front + 1) % list.size();
        size--;
        return result;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public String toString()
    {
        if(size == 0)
        {
            return "[]";
        }

        String result = "["+ list.get(front % list.size()).toString();
        for(int i = 1; i < size; i++)
        {
            result += ", " + list.get((front + i) % list.size());
        }
        result += "]";
        return result;
    }

    public void clear()
    {
        list.clear();
        size = 0;
        front = 0;
        back = 0;
    }
}

