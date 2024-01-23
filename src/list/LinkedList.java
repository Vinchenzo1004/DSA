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
}
