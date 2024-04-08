package hash;
import list.*;

/**
 * A HashTable allows quick access to "keys."
 * Client must implement a hashCode() method for the keys
 * If two keys are equal, they must have the same hashCode()
 * If two keys are not equal, they should have different hashCodes, for efficiency
 * Duplicate keys are allowed
 * Worst Case Performance = O(n) few long lists, lots of collisions
 * Avg Case Performance = O(1) many short lists, few collisions
 *
 * @author SDB & Vincent Vaccaro
 */
public class HashTable<K>
{
    List<List<K>> lists;
    int size = 0;

    public HashTable()
    {
        this(10);
    }

    public HashTable(int listCount)
    {
        lists = new ArrayList<List<K>>(listCount);
        for(int i = 0; i < listCount; i++)
        {
            lists.add(new LinkedList<K>());
        }
    }

    /**
     * Add the given key to this HashTable
     */
    public void put(K key)
    {
        List<K> list = getList(key);
        list.add(key);
        size++;
    }

    /**
     * Choose a LinkedList using client's hashCode() method
     *
     * @return the LinkedList
     */
    private List<K> getList(Object obj)
    {
        int code = obj.hashCode();
        code = Math.abs(code);
        code = code % lists.size();
        return lists.get(code);
    }

    /**
     * @return true iff this HashTable contains the given Object
     */
    public boolean containsKey(Object obj)
    {
        List<K> list = getList(obj);
        return list.contains(obj);
    }

    /**
     * @return the given key from this HashTable or null if not found
     */
    public K get(K key)
    {
        List<K> list = getList(key);
        int ndx = list.indexOf(key);

        if(ndx < 0)
        {
            return null;
        }
        return list.get(ndx);
    }

    /**
     * Remove the given object from this HashTable if possible
     *
     * @return true iff the object was removed
     */
    public boolean remove(Object obj)
    {
        List<K> list = getList(obj);

        if(list.remove(obj))
        {
            size--;
            return true;
        }
        return false;
    }

    /**
     * @return the size of this HashTable
     */
    public int size()
    {
        return size;
    }

    /**
     * @return true iff this HashTable is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Clear this HashTable
     */
    public void clear()
    {
        for (int i = 0; i < lists.size(); i++)
        {
            lists.set(i, new LinkedList<K>());
        }
        size = 0;
    }
}
