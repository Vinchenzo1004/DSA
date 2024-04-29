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

    /**
     * @return this Set as a String: e.g. [a, b, c]
     */
    public String toString()
    {
        String s = "[";
        Iterator<E> it = this.iterator();
        while(it.hasNext())
        {
            s += it.next().toString();
            if(it.hasNext())
            {
                s += ", ";
            }
        }
        return s + "]";
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

    public Set<E> difference(Set<E> other)
    {
        Set<E> result = new HashSet<>();
        Iterator<E> it = iterator();
        while(it.hasNext())
        {
            E value = it.next();
            if(!other.contains(value))
            {
                result.add(value);
            }
        }
        return result;
    }
}
