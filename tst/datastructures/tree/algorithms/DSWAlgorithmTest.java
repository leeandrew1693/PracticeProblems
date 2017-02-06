package datastructures.tree.algorithms;

import datastructures.tree.AbstractTreeTest;
import datastructures.tree.BinarySearchTree;
import datastructures.tree.common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.tree.util.TreeUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andrew on 2/2/17.
 */
public class DSWAlgorithmTest extends AbstractTreeTest{
    @Before
    public void setup() {
        binaryTree = new BinarySearchTree();
    }

    @Test
    public void dswAlgorithmSimpleTest() {
        addChild(10);
        addChild(5);
        addChild(15);
        addChild(3);
        addChild(7);
        addChild(13);
        addChild(17);

        binaryTree = DSWAlgorithm.getBalancedTree(binaryTree);
        Assert.assertEquals(3, binaryTree.getHeight());
    }

    @Test
    public void dswAlgorithm15Test() {
        final int numIterations = 15;
        for(int i = 0; i < numIterations; i ++) {
            addChild(i);
        }

        binaryTree = DSWAlgorithm.getBalancedTree(binaryTree);
        Assert.assertEquals(nodesToHeight(15), binaryTree.getHeight());
    }

    @Test
    public void dswAlgorithmExtensiveTest() {
        final int numIterations = 1000;
        for(int i = 0; i < numIterations; i ++) {
            addChild((int)(Math.random() * 10000));
        }

        binaryTree = DSWAlgorithm.getBalancedTree(binaryTree);
        Assert.assertEquals(nodesToHeight(numIterations), binaryTree.getHeight());
    }

    @Test
    public void treeToVineTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        addChild(10);
        addChild(5);
        addChild(15);
        addChild(3);
        addChild(7);
        addChild(13);
        addChild(17);

        Method m = DSWAlgorithm.class.getDeclaredMethod("treeToVine", BinaryTreeNode.class);
        m.setAccessible(true); //if security settings allow this
        BinaryTreeNode headNode = (BinaryTreeNode) m.invoke(null, binaryTree.getRootNode()); //use null if the method is static

        Assert.assertEquals(7, TreeUtil.getHeight(headNode));
    }

    private int nodesToHeight(final int numNodes) {
        final int height = (int) (Math.log(numNodes)/Math.log(2)) + 1;
        return height;
    }
}
