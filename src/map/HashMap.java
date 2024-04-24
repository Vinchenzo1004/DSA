package map;
import hash.*;
import list.*;
import set.*;

/**
 * A Map implemented as a HashTable of Entries.
 * Each Entry has a key and a value.
 *
 * @author SDB & Vincent Vaccaro
 */
public class HashMap<K, V> implements Map<K, V>
{
    HashTable<Entry<K, V>> table = new HashTable<Entry<K, V>>();

    class Entry<K, V>  //begin inner class
    {
        K key;
        V value;

        Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object obj)
        {
            Entry<K, V> other = (Entry) obj;
            return this.key.equals(other.key);
        }

        public int hashCode()
        {
            int code = 17;
            code = 31 * code + key.hashCode();
            return code;
        }

        public String toString()
        {
            return "" + key + " = " + value + "";
        }
    }  //end inner class

    public boolean containsKey(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        return table.containsKey(entry);
    }

    public V get(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = table.get(entry);

        if (entry == null)
        {
            return null;
        }
        return entry.value;
    }

    public V put(K key, V value)
    {
        Entry<K, V> newEntry = new Entry<K, V>(key, value),
        oldEntry = table.get(newEntry);

        if(oldEntry == null)
        {
            table.put(newEntry);
            return null;
        }
        V result = oldEntry.value;
        oldEntry.value = value;
        return result;
    }

    public V remove(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = table.get(entry);

        if(entry == null)
        {
            return null;
        }
        table.remove(entry);
        return entry.value;
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

    public K getKey(V value)
    {
        Iterator<Entry<K, V>> it = table.iterator();

        while(it.hasNext())
        {
            Entry<K, V> entry = it.next();
            if(entry.value.equals(value))
            {
                return entry.key;
            }
        }
        return null;
    }

    public Set<K> keySet()
    {
        Set<K> keys = new HashSet<>();
        Iterator<Entry<K, V>> it = table.iterator();

        while(it.hasNext())
        {
            Entry<K, V> entry = it.next();
            keys.add(entry.key);
        }
        return keys;
    }

    /**
     * @return true iff the given object is a Map, and this Map is equal to the given object
     */
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Map))
        {
            return false;
        }

        Map<K, V> other = (Map<K, V>) obj;
        if(this.size() != other.size())
        {
            return false;
        }

        Iterator<Entry<K, V>> it = table.iterator();
        while(it.hasNext())
        {
            Entry<K, V> entry = it.next();
            if(!other.containsKey(entry.key) || !other.get(entry.key).equals(entry.value))
            {
                return false;
            }
        }
        return true;
    }
}