package datastructures.tree.algorithms;

import datastructures.tree.AbstractTreeTest;
import datastructures.tree.BinarySearchTree;
import datastructures.tree.common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andrew on 2/3/17.
 */
public class TraversalAlgorithmsTest extends AbstractTreeTest{
    @Before
    public void setup() {
        binaryTree = new BinarySearchTree();
    }

    @Test
    public void testInOrderTraversal() throws Exception {
        final int numNodes = 10;
        createSequentialTreeWithNodes(numNodes);

        for(int i =0; i < numNodes -1 ; i ++) {
            Assert.assertEquals(i+1, TraversalAlgorithms.getNextInOrderNode(binaryTree, binaryTree.find(i)).getValue());
        }
        Assert.assertEquals(null, TraversalAlgorithms.getNextInOrderNode(binaryTree, binaryTree.find(numNodes)));
    }

    @Test
    public void testDfsTraversal() throws Exception {
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
        binaryTree.printTree();
        TraversalAlgorithms.bfsTraversal(binaryTree);
    }
}
