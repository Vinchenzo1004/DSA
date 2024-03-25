package tree;
import list.*;
import queue.*;

/**
 * An Iterator for BinaryTrees
 *
 * @author SDB & Vincent Vaccaro
 */
public class TreeIterator<E> implements Iterator<E>
{
    BinaryTree<E> tree;
    QueueADT<E> queue = new Queue<E>();
    E lastGotten;  //for remove

    //Constructor
    TreeIterator(BinaryTree<E> tree)
    {
        this.tree = tree;
        buildQ(tree);
    }

    //Add values to queue
    //In-Order Traversal
    private void buildQ(BinaryTree<E> tree)
    {
        if(tree.isEmpty())
        {
            return;
        }

        buildQ(tree.getLeft());
        queue.add(tree.getValue());
        buildQ(tree.getRight());
    }

    public boolean hasNext()
    {
        return !queue.isEmpty();
    }

    public E next()
    {
        lastGotten = queue.remove();
        return lastGotten;
    }

    public void remove()
    {
        if(lastGotten.equals(tree.getValue()) && tree.getLeft().isEmpty() != tree.getRight().isEmpty())  //child
        {
            BinaryTree<E> kid = tree.getLeft();
            if(kid.isEmpty())
            {
                kid = tree.getRight();  //kid is the only child
            }

            tree.setValue(kid.getValue());
            tree.setLeft(kid.getLeft());
            tree.setRight(kid.getRight());
        }
        else
        {
            tree = tree.remove(lastGotten);
        }
    }

    public boolean equalNeighbors()
    {
        return lastGotten.equals(tree.getValue());
    }
}
