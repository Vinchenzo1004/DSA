package map;
import tree.*;
import list.*;
import set.*;

/**
 * A Map implemented with a BST.
 * Entries may be accessed in natural order (of keys).
 *
 * @author SDB & Vincent Vaccaro
 */
public class TreeMap<K extends Comparable, V> implements Map<K, V>
{

    //start inner class
    class Entry<K extends Comparable, V> implements Comparable
    {
        K key;
        V value;

        //Constructor
        Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public int compareTo(Object obj)
        {
            Entry<K, V> other = (Entry) obj;
            return key.compareTo(other.key);
        }
    }  //end inner class

    BinaryTree<Entry<K, V>> tree = new EmptyBinarySearchTree();

    public boolean containsKey(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        return tree.containsKey(entry);
    }

    public V get(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = tree.get(entry);

        if(entry == null)
        {
            return null;
        }
        return entry.value;
    }

    public V put(K key, V value)
    {
        Entry<K, V> newEntry = new Entry<K, V>(key, value),
                oldEntry = tree.get(newEntry);

        if(oldEntry == null)
        {
            tree = tree.add(newEntry);
            return null;
        }
        V result = oldEntry.value;
        oldEntry.value = value;
        return result;
    }

    public V remove(K key)
    {
        Entry<K, V> entry = new Entry<K, V>(key, null);
        entry = tree.get(entry);

        if(entry == null)
        {
            return null;
        }
        tree = tree.remove(entry);
        return entry.value;
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
        tree = new EmptyBinarySearchTree();
    }

    public K getKey(V value)
    {
        Entry<K, V> entry = new Entry<K, V>(null, value);
        entry = tree.get(entry);

        if (entry == null)
        {
            return null;
        }
        return entry.key;
    }
}
