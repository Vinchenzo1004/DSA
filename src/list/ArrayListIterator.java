package list;

/**
 * Iterator for ArrayList.
 * @author SDB & Vincent Vaccaro
 */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E>
{
    //implicit cursor is between positions ndx, ndx+1
    boolean forward = true;

    //Constructor
    ArrayListIterator(List<E> list)
    {
        super(list);
    }

    /**
     * given start position
     * start == size => start at end
     */
    ArrayListIterator(List<E> list, int start)
    {
        super(list);
        ndx = start-1;
    }

    public boolean hasPrevious()
    {
        return ndx >= 0;
    }

    public E previous()
    {
        forward = false;
        ndx--;
        return list.get(ndx+1);
    }

    public E next()
    {
        forward = true;
        return super.next();
    }

    public void remove()
    {
        if(forward)
        {
            super.remove();
        }
        else
        {
            list.remove(ndx+1);
        }

        //if(!forward)
        //    ndx++;
        //else
        //    super.remove();
    }

    public void add(E value)
    {
        list.add(ndx+1, value);
        ndx++;
    }
}
