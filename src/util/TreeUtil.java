package util;

import datastructures.tree.common.BinaryTreeNode;

/**
 * Created by andrew on 2/1/17.
 */
public class TreeUtil {
    public static int getHeight(final BinaryTreeNode node) {
        return getHeight(node,1);
    }

    private static int getHeight(final BinaryTreeNode node, int curDepth) {
        int a = curDepth;
        int b = curDepth;
        curDepth += 1;
        if(node == null) {
            return 0;
        }
        if(node.getLeftChild() != null)  {
            a = getHeight(node.getLeftChild(), curDepth);
        }
        if(node.getRightChild() != null) {
            b = getHeight(node.getRightChild(), curDepth);
        }

        return (a>b?a:b);
    }

    public static boolean isBalanced(final BinaryTreeNode node) {
        if(node == null) {
            return true;
        }

        final int leftHeight = getHeight(node.getLeftChild());
        final int rightHeight = getHeight(node.getRightChild());

        if(Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced(node.getLeftChild())
                && isBalanced(node.getRightChild())) {
            return true;
        }

        return false;
    }

    public static BinaryTreeNode rightRotate(final BinaryTreeNode rotate) {
        //left child takes nodes place
        //node becomes right child
        // left child's right child becomes nodes left cild
        final BinaryTreeNode leftChild = rotate.getLeftChild();
        final BinaryTreeNode leftChildRightChild;
        leftChildRightChild = leftChild.getRightChild();
        rotate.setLeftChild(leftChildRightChild);
        leftChild.setRightChild(rotate);

        return leftChild;
    }

    public static BinaryTreeNode leftRotate(final BinaryTreeNode rotate) {
        //Right child takes nodes place
        // Node bcomes left child
        // right child's right child
        final BinaryTreeNode rightChild = rotate.getRightChild();
        final BinaryTreeNode rightChildLeftChild;
        rightChildLeftChild = rightChild.getLeftChild();
        rotate.setRightChild(rightChildLeftChild);
        rightChild.setLeftChild(rotate);

        return rightChild;
    }

    public static BinaryTreeNode getLeftMostNode(final BinaryTreeNode node) {
        BinaryTreeNode currentNode = node;
        do {
            if(currentNode.getLeftChild() == null) {
                return currentNode;
            } else {
                currentNode = currentNode.getLeftChild();
            }
        } while(true);
    }

    public static BinaryTreeNode getRightMostNode(final BinaryTreeNode node) {
        BinaryTreeNode currentNode = node;
        do {
            if(currentNode.getRightChild() == null) {
                return currentNode;
            } else {
                currentNode = currentNode.getRightChild();
            }
        } while(true);
    }

    public static void replaceChild(final BinaryTreeNode parentNode, final BinaryTreeNode removeNode, final BinaryTreeNode replacementNode) {
        if(parentNode.getLeftChild() == removeNode) {
            parentNode.setLeftChild(replacementNode);
        } else {
            parentNode.setRightChild(replacementNode);
        }

    }
}
