package datastructures.tree.algorithms;

import datastructures.stack.GenericStack;
import datastructures.stack.common.Stack;
import datastructures.tree.common.BinaryTree;
import datastructures.tree.common.BinaryTreeNode;

/**
 * Created by andrew on 2/3/17.
 */
public class TraversalAlgorithms {
    public static void inOrderTraversal(final BinaryTree binaryTree) throws Exception {
//        inOrderTraversal(binaryTree.getRootNode());
        inOrderTraversalIterative(binaryTree);
    }

    private static void inOrderTraversal(final BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode != null) {
            inOrderTraversal(binaryTreeNode.getLeftChild());
            System.out.println(binaryTreeNode.getValue());
            inOrderTraversal(binaryTreeNode.getRightChild());
        }
    }

    public static void inOrderTraversalIterative(final BinaryTree binaryTree) throws Exception {
        BinaryTreeNode binaryTreeNode = binaryTree.getRootNode();
        Stack stack = new GenericStack();
        while(binaryTreeNode != null) {
            stack.push(binaryTreeNode);
            binaryTreeNode = binaryTreeNode.getLeftChild();
        }
        while(!stack.isEmpty()) {
            BinaryTreeNode currentNode = (BinaryTreeNode) stack.pop();
            System.out.println(currentNode.getValue());
            if(currentNode.getRightChild() != null) {
                stack.push(currentNode.getRightChild());
            }
        }
    }

    public static BinaryTreeNode getNextInOrderNode(final BinaryTree binaryTree, final BinaryTreeNode currentNode) throws Exception {
        BinaryTreeNode binaryTreeNode = binaryTree.getRootNode();
        Stack stack = new GenericStack();
        while(binaryTreeNode != null) {
            stack.push(binaryTreeNode);
            binaryTreeNode = binaryTreeNode.getLeftChild();
        }

        while(!stack.isEmpty()) {
            final BinaryTreeNode thisNode = (BinaryTreeNode) stack.pop();
            if(thisNode.getRightChild() != null) {
                stack.push(thisNode.getRightChild());
            }
            if(thisNode == currentNode) {
                return (BinaryTreeNode) stack.pop();
            }
        }

        return null;
    }

}
