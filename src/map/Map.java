package map;

/**
 * A Map consists of several Entries.
 * Each Entry has a key and a value.
 * Access is efficient by key.
 *
 * @author SDB & Vincent Vaccaro
 */
public interface Map<K, V>
{
    /**
     * @return true iff this Map contains an Entry with given key
     */
    boolean containsKey(K key);

    /**
     * Search this Map for an Entry that has the given key
     *
     * @return the value of that entry or null is not found
     */
    V get(K key);

    /**
     * Search this Map for an Entry with given key.
     * Change its value to the given value or if not found, add a new Entry to this Map.
     *
     * @return old value or null if not found
     */
    V put(K key, V value);

    /**
     * Remove the entry with given key from this Map, if possible
     *
     * @return the value of that Entry or null if not found
     */
    V remove(K key);

    /**
     * @return the size of this Map
     */
    int size();

    /**
     * @return true iff this Map is empty
     */
    boolean isEmpty();

    /**
     * Clear this Map
     */
    void clear();

    /**
     * @return a key for the given value, or null if not found
     */
    K getKey(V value);
}
