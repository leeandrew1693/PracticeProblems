package datastructures.tree;

import datastructures.tree.common.BinaryTreeNode;

/**
 * Created by andrew on 1/29/17.
 */
public class AVLTree extends BinarySearchTree {
    public AVLTree() {
        super();
    }
    public AVLTree(final int value) {
        super(value);
    }

    private BinaryTreeNode rightRotate(final BinaryTreeNode rotate) {
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

    private BinaryTreeNode leftRotate(final BinaryTreeNode rotate) {
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

    private int getBalance(final BinaryTreeNode node) {
        final int leftHeight = getHeight(node.getLeftChild(), 1);
        final int rightHeight = getHeight(node.getRightChild(),1);
        return rightHeight - leftHeight;
    }

    @Override
    public void addChild(final int childValue) {
        headNode = addChild(headNode, childValue);
        printTree();
        System.out.println("");
    }

    private BinaryTreeNode addChild(final BinaryTreeNode node, final int childValue) {
        if(node == null) {
            return new BinaryTreeNode(childValue);
        }

        if(node.getValue() < childValue) {
            node.setRightChild(addChild(node.getRightChild(), childValue));
        } else {
            node.setLeftChild(addChild(node.getLeftChild(), childValue));
        }

        if(getBalance(node) > 1 && node.getRightChild().getValue() < childValue) {
            return leftRotate(node);
        } else if (getBalance(node) > 1 && node.getRightChild().getValue() >= childValue) {
            node.setRightChild(rightRotate(node.getRightChild()));
            return leftRotate(node);
        } else if(getBalance(node) < -1 && node.getLeftChild().getValue() < childValue) {
            node.setLeftChild(leftRotate(node.getLeftChild()));
            return rightRotate(node);
        } else if(getBalance(node) < -1 && node.getLeftChild().getValue() >= childValue) {
            return rightRotate(node);
        }

        return node;
    }

    public static void main (final String args[] ) throws Exception {
        AVLTree binarySearchTree = new AVLTree(5);
        binarySearchTree.addChild(3);
        binarySearchTree.addChild(4);
        binarySearchTree.addChild(5);
        binarySearchTree.addChild(6);
        binarySearchTree.addChild(8);
        binarySearchTree.addChild(9);
        binarySearchTree.addChild(10);
        binarySearchTree.addChild(12);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        System.out.println("Max Depth: " + binarySearchTree.getHeight() + '\n');
        binarySearchTree.printTree();
    }
}
