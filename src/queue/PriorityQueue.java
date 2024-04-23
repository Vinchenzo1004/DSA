package queue;
import list.*;

/**
 * A priority queue.
 * Largest value is removed.
 *
 * @author SDB & Vincent Vaccaro
 */
public class PriorityQueue<E extends Comparable> implements QueueADT<E>
{
    List<E> list = new ArrayList<E>();

    //Front of Queue is at position 0

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
        E result = list.get(0);
        int avail = 0,
                last = list.size() - 1,
                bc = biggerChild(0);

        while(2 * avail + 1 < last && greater(bc, last))
        {
            list.set(avail, list.get(bc));
            avail = bc;
            bc = biggerChild(avail);
        }
        list.set(avail, list.get(last));
        list.remove(last);
        return result;
    }

    /**
     * @return position of bigger child of parent
     */
    private int biggerChild(int parent)
    {
        int left = 2 * parent + 1,
                right = left + 1;

        if(right >= list.size())
        {
            return left;
        }

        if(greater(left, right))
        {
            return left;
        }
        return right;
    }

    /**
     * @return true iff value of position x is greater than value at position y
     */
    private boolean greater(int x, int y)
    {
        return list.get(x).compareTo(list.get(y)) > 0;
    }

    private void swap(int x, int y)
    {
        E temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    public void add(E value)
    {
        int added = list.size();
        list.add(value);
        int parent = (added - 1) / 2;

        while(added > 0  && greater(added, parent))
        {
            swap(added, parent);
            added = parent;
            parent = (added - 1) / 2;
        }
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public void clear()
    {
        list.clear();
    }

    public int size()
    {
        return list.size();
    }

    public String toString()
    {
        return list.toString();
    }
}
