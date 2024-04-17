package set;
import tree.*;
import list.*;

/**
 * An implementation of Set using a BST
 * The values can be visited in their natural order
 *
 * @author SDB & Vincent Vaccaro
 */
public class TreeSet<E extends Comparable> implements Set<E>
{
    BinaryTree<E> tree = new EmptyBinarySearchTree<>();

    public boolean contains(Object obj)
    {
        return tree.containsKey(obj);
    }

    public boolean add(E value)
    {
        if(contains(value))
        {
            return false;
        }
        tree = tree.add(value);
        return true;
    }

    public boolean remove(Object obj)
    {
        if(!contains(obj))
        {
            return false;
        }
        tree = tree.remove(obj);
        return true;
    }

    //values are seen in natural order
    public Iterator<E> iterator()
    {
        return tree.iterator();
    }

    public int size()
    {
        return tree.size();
    }

    public boolean isEmpty()
    {
        return tree.isEmpty();
    }

    public void clear()
    {
        tree = new EmptyBinarySearchTree<>();
    }

    /**
     * @return this Set as a String: e.g. [a, b, c]
     */
    public String toString()
    {
        return tree.toString();
    }

    /**
     * @return true iff the given object is a Set and it contains exactly the same values as this Set
     */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Set))
        {
            return false;
        }

        if(this == obj)
        {
            return true;
        }

        Iterator<E> it = iterator();

        if(obj instanceof Set)
        {
            Set<?> other = (Set<?>) obj;
            if(this.size() != other.size())
            {
                return false;
            }

            while(it.hasNext())
            {
                if(!other.contains(it.next()))
                {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
