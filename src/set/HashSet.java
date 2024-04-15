package set;
import hash.*;
import list.*;

/**
 * A Set implemented with a HashTable.
 *
 * @author SDB & Vincent Vaccaro
 */
public class HashSet<E> implements Set<E>
{
    HashTable<E> table = new HashTable<E>();

    public boolean contains(Object obj)
    {
        return table.containsKey(obj);
    }

    public boolean add(E value)
    {
        if(table.containsKey(value))
        {
            return false;
        }
        table.put(value);
        return true;
    }

    public boolean remove(Object obj)
    {
        return table.remove(obj);
    }

    public Iterator<E> iterator()
    {
        return table.iterator();
    }

    public int size()
    {
        return table.size();
    }

    public boolean isEmpty()
    {
        return table.isEmpty();
    }

    public void clear()
    {
        table.clear();
    }

    public String toString()
    {
        return table.toString();
    }
}
