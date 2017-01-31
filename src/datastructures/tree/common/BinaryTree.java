package datastructures.tree.common;

/**
 * Created by andrew on 1/29/17.
 */
public interface BinaryTree {
    BinaryTreeNode headNode = null;

    public void addChild(final int value);
    public void removeNode(final int value) throws Exception;
    public BinaryTreeNode find(final int value) throws Exception;
    public int getHeight();

}
