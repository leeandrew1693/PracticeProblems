package datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 1/31/17.
 */
public class BinarySearchTreeTest extends  AbstractTreeTest{
    private static final int ITERATIONS = 10;
    @Before
    public void setUp() {
        binaryTree = new BinarySearchTree();

    }

    @Test
    public void addChildTest() {
        addChild(5);
        addChild(4);
        addChild(3);
        addChild(2);
        assertEquals(5, binaryTree.getRootNode().getValue());
        assertEquals(4, binaryTree.getRootNode().getLeftChild().getValue());
        assertEquals(3, binaryTree.getRootNode().getLeftChild().getLeftChild().getValue());
        assertEquals(2, binaryTree.getRootNode().getLeftChild().getLeftChild().getLeftChild().getValue());
    }


    @Test
    public void removeNodeTest() throws Exception {
        addChild(5);
        addChild(4);
        addChild(3);
        addChild(2);

        binaryTree.removeNode(4);
        assertEquals(5, binaryTree.getRootNode().getValue());
        assertEquals(3, binaryTree.getRootNode().getLeftChild().getValue());
        assertEquals(2, binaryTree.getRootNode().getLeftChild().getLeftChild().getValue());
    }

    @Test
    public void removeNode2Test() throws Exception {
        addChild(10);
        addChild(5);
        addChild(15);
        addChild(3);
        addChild(7);
        addChild(13);
        addChild(17);
        addChild(2);
        addChild(4);
        addChild(6);
        addChild(8);
        addChild(12);
        addChild(14);
        addChild(16);
        addChild(18);

        binaryTree.removeNode(5);
    }

    @Test
    public void removeNodeRootNodeTest() throws Exception {
        addChild(10);
        addChild(5);
        addChild(15);
        addChild(3);
        addChild(7);
        addChild(13);
        addChild(17);
        binaryTree.removeNode(10);
        assertEquals(13, binaryTree.getRootNode().getValue());
        assertEquals(5, binaryTree.getRootNode().getLeftChild().getValue());
        assertEquals(15, binaryTree.getRootNode().getRightChild().getValue());
    }

}
