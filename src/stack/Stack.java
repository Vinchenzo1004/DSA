package stack;
import list.*;

/**
 * An implementation of StackADT
 * @author SDB & Vincent Vaccaro
 */
public class Stack<E> implements StackADT<E>
{
    //End of list is top of stack
    List<E> list = new ArrayList<E>();

    public Stack(boolean array)
    {
        if(array)
        {
            list = new ArrayList<E>();
        }
        else
        {
            list = new LinkedList<E>();
        }
    }

    public E push(E value)
    {
        list.add(value);
        return value;
    }

    public E peek()
    {
        return list.get(list.size()-1);
    }

    public E pop()
    {
        return list.remove(list.size()-1);
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
}
