package list;

/**
 * An Iterator for ArrayLists
 * @author SDB & Vincent Vaccaro
 */
class ArrayIterator<E> implements Iterator<E>
{
    //ndx is the position of the last value obtained by next()
    int ndx = -1;
    List<E> list;
    ArrayIterator(List<E> list)
    {
        this.list = list;
    }

    public boolean hasNext()
    {
        return ndx < list.size()-1;
    }

    public E next()
    {
        ndx++;
        return list.get(ndx);
    }

    public void remove()
    {
        list.remove(ndx);
        ndx--;
    }

    /**
     * @return true iff the last value visited is equal to the next value in this List.
     * Pre: hasNext() is true. next() has been called at least once
     */
    public boolean equalNeighbors()
    {
        if(!hasNext())
        {
            return false;
        }
        return list.get(ndx).equals(list.get(ndx + 1));
    }
}
