package datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrew on 1/31/17.
 */
public class BinarySearchTreeTest {
    BinarySearchTree binarySearchTree = new BinarySearchTree();

    @Before
    public void setUp() {
    }

    @Test
    public void addChildTest() {
        binarySearchTree.addChild(5);
        binarySearchTree.addChild(4);
        binarySearchTree.addChild(3);
        binarySearchTree.addChild(2);
        assertEquals(5, binarySearchTree.headNode.getValue());
        assertEquals(4, binarySearchTree.headNode.getLeftChild().getValue());
        assertEquals(3, binarySearchTree.headNode.getLeftChild().getLeftChild().getValue());
        assertEquals(2, binarySearchTree.headNode.getLeftChild().getLeftChild().getLeftChild().getValue());
    }

    @Test
    public void removeNodeTest() throws Exception {
        binarySearchTree.addChild(5);
        binarySearchTree.addChild(4);
        binarySearchTree.addChild(3);
        binarySearchTree.addChild(2);

        binarySearchTree.removeNode(4);
        assertEquals(5, binarySearchTree.headNode.getValue());
        assertEquals(3, binarySearchTree.headNode.getLeftChild().getValue());
        assertEquals(2, binarySearchTree.headNode.getLeftChild().getLeftChild().getValue());
    }

    @Test
    public void removeNode2Test() throws Exception {
        binarySearchTree.addChild(10);
        binarySearchTree.addChild(5);
        binarySearchTree.addChild(15);
        binarySearchTree.addChild(3);
        binarySearchTree.addChild(7);
        binarySearchTree.addChild(13);
        binarySearchTree.addChild(17);
        binarySearchTree.addChild(2);
        binarySearchTree.addChild(4);
        binarySearchTree.addChild(6);
        binarySearchTree.addChild(8);
        binarySearchTree.addChild(12);
        binarySearchTree.addChild(14);
        binarySearchTree.addChild(16);
        binarySearchTree.addChild(18);

        binarySearchTree.removeNode(5);
    }

    @Test
    public void removeNodeRootNodeTest() throws Exception {
        binarySearchTree.addChild(10);
        binarySearchTree.addChild(5);
        binarySearchTree.addChild(15);
        binarySearchTree.addChild(3);
        binarySearchTree.addChild(7);
        binarySearchTree.addChild(13);
        binarySearchTree.addChild(17);
        binarySearchTree.removeNode(10);
        binarySearchTree.printTree();
        assertEquals(13, binarySearchTree.headNode.getValue());
        assertEquals(5, binarySearchTree.headNode.getLeftChild().getValue());
        assertEquals(15, binarySearchTree.headNode.getRightChild().getValue());
    }

}
