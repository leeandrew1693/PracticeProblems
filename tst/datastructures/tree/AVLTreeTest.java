package datastructures.tree;

import org.junit.Assert;
import org.junit.Test;
import util.TreeUtil;

/**
 * Created by andrew on 1/31/17.
 */
public class AVLTreeTest {
    private static final int NUM_ITERATIONS = 100;
    AVLTree avlTree = new AVLTree();

    @Test
    public void addChildTest() {
        addChild(5);
        addChild(4);
        addChild(3);
        Assert.assertEquals(4, avlTree.headNode.getValue());
        Assert.assertEquals(5, avlTree.headNode.getRightChild().getValue());
        Assert.assertEquals(3, avlTree.headNode.getLeftChild().getValue());
    }

    private void addChild(final int value) {
        avlTree.addChild(value);
        Assert.assertEquals(true, TreeUtil.isBalanced(avlTree.headNode));
    }

    private void removeChild(final int value) throws Exception {
        avlTree.removeNode(value);
        Assert.assertEquals(true, TreeUtil.isBalanced(avlTree.headNode));
    }

    @Test
    public void addChildBigNumberTest() throws Exception {
        avlTree = new AVLTree();
        for(int i = 1; i< NUM_ITERATIONS; i++) {
            addChild(i);
        }
        for(int i =1; i< NUM_ITERATIONS;i++) {
            removeChild(i);
        }
    }
}
