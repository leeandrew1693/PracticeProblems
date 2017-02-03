package util;

import datastructures.tree.AbstractTreeTest;
import datastructures.tree.BinarySearchTree;
import datastructures.tree.algorithms.TraversalAlgorithms;
import datastructures.tree.common.BinaryTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
