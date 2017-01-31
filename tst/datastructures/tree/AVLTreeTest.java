package datastructures.tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andrew on 1/31/17.
 */
public class AVLTreeTest {
    AVLTree avlTree = new AVLTree();

    @Test
    public void addChildTest() {
        avlTree.addChild(5);
        avlTree.addChild(4);
        avlTree.addChild(3);
        Assert.assertEquals(4, avlTree.headNode.getValue());
        Assert.assertEquals(5, avlTree.headNode.getRightChild().getValue());
        Assert.assertEquals(3, avlTree.headNode.getLeftChild().getValue());
    }
}
