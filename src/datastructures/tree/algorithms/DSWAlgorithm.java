package datastructures.tree.algorithms;

import datastructures.tree.common.BinaryTree;
import datastructures.tree.common.BinaryTreeNode;
import util.TreeUtil;

/**
 * Created by andrew on 2/1/17.
 */
public class DSWAlgorithm {
    public static BinaryTree getBalancedTree(final BinaryTree binaryTree) {
        BinaryTreeNode root = binaryTree.getRootNode();
        root = treeToVine(root);
        root = vineToBalancedTree(root);
        binaryTree.setRootNode(root);
        return binaryTree;
    }

    private static BinaryTreeNode treeToVine(BinaryTreeNode root) {
        while(root.getLeftChild() != null) {
            root = TreeUtil.rightRotate(root);
        }
        if(root.getRightChild() != null) {
            root.setRightChild(treeToVine(root.getRightChild()));
        }
        return root;
    }

    private static BinaryTreeNode vineToBalancedTree(BinaryTreeNode root) {
        int numNodes = TreeUtil.getHeight(root);
        final int numTimes = (int) (Math.log(numNodes)/Math.log(2));
        BinaryTreeNode newRoot = root;
        BinaryTreeNode rootToBeRotated = null;
        BinaryTreeNode rotatedNodeParent = null;
        for(int i =0; i < numTimes ; i ++) {
            newRoot = TreeUtil.leftRotate(newRoot);
            rootToBeRotated= newRoot.getRightChild();
            rotatedNodeParent = newRoot;
            for(int j =0; j < numNodes/2 -1 ; j++ ){
                rotatedNodeParent.setRightChild(TreeUtil.leftRotate(rootToBeRotated));
                rootToBeRotated = rotatedNodeParent.getRightChild().getRightChild();
                rotatedNodeParent = rotatedNodeParent.getRightChild();
            }
            numNodes >>= 1;
        }

        return newRoot;
    }
}
