package datastructures.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.TreeUtil;

/**
 * Created by andrew on 1/31/17.
 */
public class AVLTreeTest extends AbstractTreeTest{
    private static final int NUM_ITERATIONS = 100;

    @Before
    public void setup() {
        binaryTree = new AVLTree();
    }

    @Test
    public void addChildTest() {
        addChild(5);
        addChild(4);
        addChild(3);
        Assert.assertEquals(4, binaryTree.getRootNode().getValue());
        Assert.assertEquals(5, binaryTree.getRootNode().getRightChild().getValue());
        Assert.assertEquals(3, binaryTree.getRootNode().getLeftChild().getValue());
    }


    @Test
    public void addRemoveChildBigNumberTest() throws Exception {
        for(int i = 1; i< NUM_ITERATIONS; i++) {
            addChild(i);
        }

        for(int i =1; i< NUM_ITERATIONS;i++) {
            removeChild(i);
        }
    }
}
