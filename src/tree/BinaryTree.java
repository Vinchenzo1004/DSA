package tree;

/**
 * A BinaryTree may have a value, and at most, two children,
 * each of which is also a BinaryTree.
 *
 * @author SDB & Vincent Vaccaro
 */
public interface BinaryTree<E>
{
    /**
     * @return the value stored in this BinaryTree, or null if it is empty
     */
    E getValue();

    /**
     * Search the family of this BinaryTree for the given value.
     *
     * @return a BinaryTree containing the given value, or null if not found
     */
    E get(E value);

    /**
     * @return true iff the family of this BinaryTree contains given obj
     */
    boolean containsKey(Object obj);

    /**
     * Add the given value to the family of this BinaryTree
     *
     * @return a BinaryTree containing the given value
     */
    BinaryTree<E> add(E value);

    /**
     * Remove the given object from this BinaryTree, if possible
     *
     * @return the resulting BinaryTree
     */
    BinaryTree<E> remove(Object obj);

    /**
     * @return the left child of this BinaryTree
     */
    BinaryTree<E> getLeft();

    /**
     * @return the right child of this BinaryTree
     */
    BinaryTree<E> getRight();

    /**
     * @return the size of this BinaryTree's family
     */
    int size();

    /**
     * @return true iff this BinaryTree is empty
     */
    boolean isEmpty();

    /**
     * Set the value of this BinaryTree to the given value
     */
    void setValue(E value);

    /**
     * Set the left child of this BinaryTree to the given BinaryTree
     */
    void setLeft(BinaryTree<E> left);

    /**
     * Set the right child of this BinaryTree to the given BinaryTree
     */
    void setRight(BinaryTree<E> right);
}
