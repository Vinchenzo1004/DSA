package list;

/**
 * A List implemented with references
 *
 * @author SDB & Vincent Vaccaro
 */
public class LinkedList<E> implements List<E>
{
    int size = 0;
    Node<E> head = new Node<E>(null, null,null),
            tail = new Node<E>(null, null, head);
    private Node<E> ref;
    //Constructor
    public LinkedList()
    {
        head.next = tail;
    }

    @Override
    public E get(int ndx)
    {
        setRef(ndx);
        return ref.value;
    }

    private void setRef(int ndx)
    {
        if(ndx <= size / 2)
        {
            ref = head.next;
            for(int i = 0; i < ndx; i++)
            {
                ref = ref.next;
            }
        }
        else
        {
            ref = tail.prev;
            for(int i = size - 1; i > ndx; i--)
            {
                ref = ref.prev;
            }
        }
    }

    public E set(int ndx, E value)
    {
        setRef(ndx);
        E result = ref.value; //old value
        ref.value = value;    //clobbering old value
        return result;        //returning old value
    }

    public void add (E value)
    {
        Node<E> temp = new Node<E>(value, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    public void add(int ndx, E value)
    {
        setRef(ndx);
        Node<E> temp = new Node<E>(value, ref, ref.prev);
        ref.prev.next = temp;
        ref.prev = temp;
        size++;
    }

    public E remove(int ndx)
    {
        setRef(ndx);
        ref.prev.next = ref.next;
        ref.next.prev = ref.prev;
        size--;
        return ref.value;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void clear()
    {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int indexOf(Object obj)
    {
        ref = head.next;
        for (int i = 0; i < size; i++)
        {
            if(ref.value.equals(obj))
            {
                return i;
            }
            else
            {
                ref = ref.next;
            }
        }
        return -1;
    }

    public boolean contains(Object obj)
    {
        return indexOf(obj) != -1;
    }

    /**
     * @return this List as a String
     */
    public String toString()
    {
        if(isEmpty())
        {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < size; i++)
        {
            result.append(get(i));
            if(i != size - 1)
            {
                result.append(", ");
            }
        }
        return "[" + result + "]";
    }

    public Iterator<E> iterator()
    {
        return new RefIterator<E>(this); //stub (under construction)
    }

    public boolean lastIsDuplicated()
    {
        ref = head.next;
        for(int i = 0; i < size - 1; i++)
        {
            if(ref.value.equals(ref.next.value))
            {
                return true;
            }
            else
            {
                ref = ref.next;
            }
        }
        return false;
    }

    public boolean remove(Object obj)
    {
        Iterator<E> it = iterator();
        while(it.hasNext())
        {
            if(it.next().equals(obj))
            {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * @return true iff the given Object is a List and this List is equal to the given List.
     */
    public boolean equals (Object obj)
    {
        if(!(obj instanceof List))
        {
            return false;
        }
        List<E> other = (List<E>) obj;
        if(size != other.size())
        {
            return false;
        }

        Iterator<E> it = iterator();
        Iterator<E> temp = other.iterator();
        while(it.hasNext() && temp.hasNext())
        {
            if(!(it.next().equals(temp.next())))
            {
                return false;
            }
        }
        return true;
    }

    public ListIterator<E> listIterator()
    {
        return new RefListIterator<E>(this);
    }

    public ListIterator<E> listIterator(int start)
    {
        return new RefListIterator<E>(this, start);
    }

    public void addAll(List<E> list)
    {
        Iterator<E> it = list.iterator();
        while(it.hasNext())
        {
            add(it.next());
        }
    }
}

