package list;
import java.util.*;

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
        ref = head.next;
        for (int i = 0; i < ndx; i++)
        {
            ref = ref.next;
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
        if (isEmpty())
        {
            return "[]";
        }

        String result = "";
        for(int i = 0; i < size; i++)
        {
            result += get(i);
            if(i != size - 1)
            {
                result += ", ";
            }
        }
        return "[" + result + "]";
    }
}

