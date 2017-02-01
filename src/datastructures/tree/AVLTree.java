package datastructures.tree;

import datastructures.tree.common.BinaryTreeNode;
import util.TreeUtil;

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



    private int getBalance(final BinaryTreeNode node) {
        final int leftHeight = getHeight(node.getLeftChild(), 1);
        final int rightHeight = getHeight(node.getRightChild(),1);
        return rightHeight - leftHeight;
    }

    @Override
    public void removeNode(final int removeValue) throws Exception {
        headNode = removeNode(headNode, removeValue);
    }

    private BinaryTreeNode removeNode(BinaryTreeNode currentNode, final int removeValue) throws Exception {
        if( currentNode == null )
            return currentNode;   // Item not found; do nothing
        if( removeValue < currentNode.getValue())
            currentNode.setLeftChild(removeNode(currentNode.getLeftChild(), removeValue));
        else if(removeValue > currentNode.getValue())
            currentNode.setRightChild(removeNode(currentNode.getRightChild(), removeValue));
        else if( currentNode.getLeftChild() != null && currentNode.getRightChild() != null ) {
            BinaryTreeNode thisNode = currentNode.getRightChild();
            if(thisNode.getLeftChild() == null) {
                currentNode = thisNode;
            }  else {
                do {
                    if(thisNode.getLeftChild().getLeftChild() == null) {
                        BinaryTreeNode replacementNode = thisNode.getLeftChild();
                        thisNode.setLeftChild(null);
                        replacementNode.setLeftChild(currentNode.getLeftChild());
                        replacementNode.setRightChild(currentNode.getRightChild());
                        currentNode = replacementNode;
                        break;
                    } else {
                        thisNode= thisNode.getLeftChild();
                    }
                } while(true);
            }
        } else {
            currentNode = (currentNode.getLeftChild() != null) ? currentNode.getLeftChild() : currentNode.getRightChild();
        }

        if(currentNode == null) {
            return currentNode;
        }
        int balance = getBalance(currentNode);
        if(balance > 1 && getBalance(currentNode.getRightChild()) > 0) {
            return TreeUtil.leftRotate(currentNode);
        } else if(balance > 1 && getBalance(currentNode.getRightChild()) <= 0) {
            currentNode.setRightChild(TreeUtil.rightRotate(currentNode.getRightChild()));
            return TreeUtil.leftRotate(currentNode);
        } else if (balance < -1 && getBalance(currentNode.getLeftChild()) < 0) {
            return TreeUtil.rightRotate(currentNode);
        } else if (balance < -1 && getBalance(currentNode.getLeftChild()) >= 0){
            currentNode.setLeftChild(TreeUtil.leftRotate(currentNode.getLeftChild()));
            return TreeUtil.rightRotate(currentNode);
        }
        return currentNode;
    }

    @Override
    public void addChild(final int childValue) {
        headNode = addChild(headNode, childValue);
        printTree();
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
            return TreeUtil.leftRotate(node);
        } else if (getBalance(node) > 1 && node.getRightChild().getValue() >= childValue) {
            node.setRightChild(TreeUtil.rightRotate(node.getRightChild()));
            return TreeUtil.leftRotate(node);
        } else if(getBalance(node) < -1 && node.getLeftChild().getValue() < childValue) {
            node.setLeftChild(TreeUtil.leftRotate(node.getLeftChild()));
            return TreeUtil.rightRotate(node);
        } else if(getBalance(node) < -1 && node.getLeftChild().getValue() >= childValue) {
            return TreeUtil.rightRotate(node);
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
