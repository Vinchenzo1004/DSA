package list;

/**
 * A node has a value and references to two other nodes
 *
 * @author SDB & Vincent Vaccaro
 */
class Node<E>
{
    E value;
    Node<E> next;
    Node<E> prev;

    //Constructor
    Node(E value, Node<E> next, Node<E> prev)
    {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
