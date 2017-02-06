package datastructures.tree.algorithms;

import datastructures.queue.Queue;
import datastructures.queue.GenericQueue;
import datastructures.stack.GenericStack;
import datastructures.stack.common.Stack;
import datastructures.tree.common.BinaryTree;
import datastructures.tree.common.BinaryTreeNode;

/**
 * Created by andrew on 2/3/17.
 */
public class TraversalAlgorithms {
    public static void dfsTraversal(final BinaryTree binaryTree) throws Exception {
        Stack stack = new GenericStack();
        BinaryTreeNode binaryTreeNode = binaryTree.getRootNode();
        while(binaryTreeNode != null) {
            System.out.println(binaryTreeNode.getValue());

            if(binaryTreeNode.getRightChild() != null) {
                stack.push(binaryTreeNode.getRightChild());
            }

            if(binaryTreeNode.getLeftChild() != null) {
                stack.push(binaryTreeNode.getLeftChild());
            }
            binaryTreeNode = (BinaryTreeNode) stack.pop();
        }
    }

    public static void bfsTraversal(final BinaryTree binaryTree) throws Exception {
        Queue queue = new GenericQueue();
        BinaryTreeNode binaryTreeNode = binaryTree.getRootNode();
        while(binaryTreeNode != null) {
            System.out.println(binaryTreeNode.getValue());

            if(binaryTreeNode.getLeftChild() != null) {
                queue.enqueue(binaryTreeNode.getLeftChild());
            }

            if(binaryTreeNode.getRightChild() != null) {
                queue.enqueue(binaryTreeNode.getRightChild());
            }

            binaryTreeNode = (BinaryTreeNode) queue.dequeue();
        }

    }


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

    public static void postOrderTraversal(final BinaryTree binaryTree) {
        postOrderTraversal(binaryTree.getRootNode());
    }

    private static void postOrderTraversal(final BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode != null) {
            postOrderTraversal(binaryTreeNode.getLeftChild());
            postOrderTraversal(binaryTreeNode.getRightChild());
            System.out.println(binaryTreeNode.getValue());
        }
    }

    public static void preOrderTraversal(final BinaryTree binaryTree) {
        preOrderTraversal(binaryTree.getRootNode());
    }

    private static void preOrderTraversal(final BinaryTreeNode binaryTreeNode) {
        if(binaryTreeNode != null) {
            System.out.println(binaryTreeNode.getValue());
            preOrderTraversal(binaryTreeNode.getLeftChild());
            preOrderTraversal(binaryTreeNode.getRightChild());
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
