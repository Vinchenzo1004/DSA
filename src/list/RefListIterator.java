package list;

/**
 * A ListIterator for LinkedLists
 *
 * @author SDB & Vincent Vaccaro
 * @param <E>
 */
public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>
{
    //super.cursor is a ref to the node storing last value obtained by next() or previous()
    boolean forward = true;

    //Constructor
    RefListIterator(LinkedList list)
    {
        super(list);
    }

    RefListIterator(LinkedList list, int start)
    {
        super(list);
        for(int i = 0; i < start; i++)
        {
            cursor = cursor.next;
        }
    }

    public boolean hasNext()
    {
        if(list.isEmpty())
        {
            return false;
        }

        if(forward)
        {
            return cursor.next != list.tail;
        }
        return true;
        //return cursor.next != null;
    }

    public E next()
    {
        if(forward)
        {
            cursor = cursor.next;
            return cursor.value;
        }
        forward = true;
        return cursor.value;
    }

    public boolean hasPrevious()
    {
        if(!forward)
        {
            return cursor.prev != list.head;
        }
        return cursor != list.head;
    }

    public E previous()
    {
        if(!forward)
        {
            cursor = cursor.prev;
        }
        forward = false;
        return cursor.value;

        //if(!forward)
        //{
        //    cursor = cursor.prev;
        //    return cursor.value;
        //}
        //forward = false;
        //return cursor.value;
    }

    public void remove()
    {
        super.remove();
        if(forward)
        {
            cursor = cursor.prev;
        }
        else
        {
            cursor = cursor.next;
        }
    }

    public void add(E value)
    {
        if(forward)
        {
            Node<E> temp = new Node<E>(value, cursor.next, cursor);
            cursor.next.prev = temp;
            cursor.next = temp;
            cursor = cursor.next;
            list.size++;
        }
        else
        {
            Node<E> temp = new Node<E>(value, cursor, cursor.prev);
            cursor.prev.next = temp;
            cursor.prev = temp;
            list.size++;

        }

    }
}
