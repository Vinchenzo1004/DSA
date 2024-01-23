package list;

/**
 * An implementation of the List interface using an Array
 *
 * @author SDB & Vincent Vaccaro
 */
public class ArrayList<E> implements List<E>
{
    int size = 0;
    E [] values;

    //Constructors
    public ArrayList(int cap) //cap is length of array
    {
        values = (E[]) new Object[cap];
    }

    public ArrayList()
    {
        this(10); //default cap
    }

    public E get(int ndx)
    {
        return values[ndx];
    }

    public E set(int ndx, E value)
    {
        E result = values[ndx];
        values[ndx] = value;
        return result;
    }

    public void add(E value)
    {
        add(size, value);
    }

    public void add(int ndx, E value)
    {
        if(size == values.length)
        {
            alloc();
        }

        for (int i = size; i > ndx; i--)
        {
            values[i] = values[i-1];
        }
        values[ndx] = value;
        size++;
    }

    public E remove(int ndx)
    {
        E result = values[ndx];
        for (int i = ndx; i < size-1; i++)
        {
            values[i] = values[i+1];
        }
        size--;
        return result;
    }

    private void alloc()
    {
        E[] temp = (E[]) new Object[values.length * 2];
        for (int i = 0; i < values.length; i++)
        {
            temp[i] = values[i];
        }
        values = temp;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
        size = 0;
    }
}
