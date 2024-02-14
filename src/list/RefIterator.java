package list;

/**
 * An Iterator for LinkedLists
 * @author SDB & Vincent Vaccaro
 */
public class RefIterator<E> implements Iterator<E>
{
    //ref to the Node storing the last character obtained by next()

    Node<E> cursor;
    LinkedList<E> list;

    RefIterator(LinkedList<E> list) //Constructor
    {
        cursor = list.head;
        this.list = list;
    }

    public boolean hasNext()
    {
        return cursor.next != list.tail;
    }

    public E next()
    {
        cursor = cursor.next;
        return cursor.value;
    }

    public void remove()
    {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        list.size--;
    }

    @Override
    public boolean equalNeighbors()
    {
        return false;
    }
}
