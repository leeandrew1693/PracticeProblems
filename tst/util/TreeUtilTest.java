package util;

import datastructures.tree.AbstractTreeTest;
import datastructures.tree.BinarySearchTree;
import datastructures.tree.algorithms.DSWAlgorithm;
import datastructures.tree.util.TreeUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * Created by andrew on 2/3/17.
 */
public class TreeUtilTest extends AbstractTreeTest {
    @Before
    public void setup() {
        binaryTree = new BinarySearchTree();
    }

    @Test
    public void testIsBalancedFalseCondition() {
        binaryTree.addChild(10);
        binaryTree.addChild(9);
        binaryTree.addChild(8);
        Assert.assertFalse(TreeUtil.isBalanced(binaryTree.getRootNode()));
    }

    @Test
    public void testIsBalancedTrueCondition() {
        binaryTree.addChild(9);
        binaryTree.addChild(10);
        binaryTree.addChild(8);
        Assert.assertTrue(TreeUtil.isBalanced(binaryTree.getRootNode()));
    }

    @Test
    public void testGetHeight() {
        binaryTree.addChild(10);
        binaryTree.addChild(9);
        binaryTree.addChild(8);
        Assert.assertEquals(3, TreeUtil.getHeight(binaryTree));
        Assert.assertEquals(3, TreeUtil.getHeight(binaryTree.getRootNode()));
    }

    @Test
    public void testFindCommonAncestor() throws Exception {
        createSequentialTreeWithNodes(15);
        binaryTree = DSWAlgorithm.getBalancedTree(binaryTree);
        Assert.assertEquals(1, TreeUtil.findAncestorOptimized(0, 2, binaryTree.getRootNode()).getValue());
        Assert.assertEquals(3, TreeUtil.findAncestorOptimized(0, 3, binaryTree.getRootNode()).getValue());
        Assert.assertEquals(7, TreeUtil.findAncestorOptimized(0, 11, binaryTree.getRootNode()).getValue());
        Assert.assertEquals(11, TreeUtil.findAncestorOptimized(12, 8, binaryTree.getRootNode()).getValue());
    }

    @Test
    public void testFindCommonAncestor2() throws Exception{
        final int NUM_NODES = 8191;
        createSequentialTreeWithNodes(NUM_NODES);
        binaryTree = DSWAlgorithm.getBalancedTree(binaryTree);
        final Callable nonOptimized = () -> TreeUtil.findAncestor(0, NUM_NODES, binaryTree.getRootNode());
        final Callable optimized = () -> TreeUtil.findAncestorOptimized(0, NUM_NODES, binaryTree.getRootNode());
        System.out.println("Optimized algorithm");
        Timer.time(optimized);
        System.out.println("Non-optimized algorithm");
        Timer.time(nonOptimized);
    }
}
