package datastructures.tree;

import datastructures.tree.common.BinaryTree;
import org.junit.Assert;
import util.TreeUtil;

/**
 * Created by andrew on 2/1/17.
 */
public class AbstractTreeTest {
    protected BinaryTree binaryTree;

    protected void addChild(final int value) {
        binaryTree.addChild(value);
        Assert.assertEquals(true, TreeUtil.isBalanced(binaryTree.headNode));
    }

    protected void removeChild(final int value) throws Exception {
        binaryTree.removeNode(value);
        Assert.assertEquals(true, TreeUtil.isBalanced(binaryTree.headNode));
    }
}
