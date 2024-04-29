package treeDriver;
import tree.*;
public class Test
{
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(0);
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);

        System.out.println("Height of the tree: " + tree.height());
    }
}
