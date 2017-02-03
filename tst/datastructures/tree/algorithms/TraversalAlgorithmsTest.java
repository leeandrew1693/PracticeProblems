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
}
