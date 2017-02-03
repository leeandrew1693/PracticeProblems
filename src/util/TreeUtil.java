package util;

import datastructures.tree.common.BinaryTree;
import datastructures.tree.common.BinaryTreeNode;

/**
 * Created by andrew on 2/1/17.
 */
public class TreeUtil {

    public static int getHeight(final BinaryTree tree) {
        return getHeight(tree.getRootNode());
    }
    /**
     * Get the height of a given node
     * @param node
     * @return
     */
    public static int getHeight(final BinaryTreeNode node) {
        return getHeight(node,1);
    }

    /**
     * Helper/Recursive method to get height
     * @param node - Current node
     * @param curDepth - Current Depth
     * @return
     */
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

    /**
     * Check if a tree is height balanced
     * @param node - Root node
     * @return - Whether or not its balanced
     */
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

    /**
     * Rotate to the right.
     * (Diagram from geeksforgeeks.org)
     *          z                                      y
     *         / \                                   /   \
     *       y   T4      Right Rotate (z)          x      z
     *      / \          - - - - - - - - ->      /  \    /  \
     *     x   T3                               T1  T2  T3  T4
     *    / \
     *  T1   T2
     *
     * @param rotate
     * @return
     */
    public static BinaryTreeNode rightRotate(final BinaryTreeNode rotate) {
        //left child takes nodes place
        //node becomes right child
        // left child's right child becomes nodes left cild
        final BinaryTreeNode newHead = rotate.getLeftChild();
        final BinaryTreeNode leftChildRightChild;
        leftChildRightChild = newHead.getRightChild();
        rotate.setLeftChild(leftChildRightChild);
        newHead.setRightChild(rotate);

        return newHead;
    }

    /**
     * Rotate to the left
     * (Diagram from geeksforgeeks.org)
     *    z                                y
     *   /  \                            /   \
     *  T1   y     Left Rotate(z)       z      x
     *     /  \   - - - - - - - ->    / \    / \
     *    T2   x                     T1  T2 T3  T4
     *        / \
     *       T3  T4
     *
     *       return y
     * @param rotate
     * @return
     */
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

    /**
     * Get the bottom left node from a given node.
     *
     * @param node - Starting node
     * @return - Bottom left node
     */
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

    /**
     * Get the bottom right node from a given node
     * @param node
     * @return
     */
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
