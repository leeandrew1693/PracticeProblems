package datastructures.tree;

import com.sun.tools.javac.jvm.Gen;
import datastructures.stack.GenericStack;
import datastructures.stack.common.Stack;
import datastructures.tree.common.BinaryTree;
import datastructures.tree.common.BinaryTreeNode;

/**
 * Created by andrew on 1/29/17.
 */
public class BinarySearchTree implements BinaryTree{
    BinaryTreeNode headNode;

    public BinarySearchTree() {
        headNode = null;
    }

    public BinarySearchTree(final int value) {
        headNode = new BinaryTreeNode(value);
    }

    public BinarySearchTree(final BinaryTreeNode node) {
        headNode = node;
    }


        @Override
    public void addChild(final int childValue) {
        addChildRecursive(childValue);
//        addChildIterative(childValue);
//        printTree();
    }

    private void addChildRecursive(final int childValue) {
        headNode = addChildRecursive(headNode, childValue);
    }

    private BinaryTreeNode addChildRecursive(final BinaryTreeNode node, final int childValue) {
        if(node == null) {
            return new BinaryTreeNode(childValue);
        }

        if(node.getValue() < childValue) {
            node.setRightChild(addChildRecursive(node.getRightChild(), childValue));
        } else {
            node.setLeftChild(addChildRecursive(node.getLeftChild(), childValue));
        }

        return node;
    }

    private void addChildIterative(final int childValue) {
        if(headNode == null) {
            headNode = new BinaryTreeNode(childValue);
            return;
        }
        BinaryTreeNode currentNode = headNode;
        do {
            if (currentNode.getValue() < childValue) {
                if (currentNode.getRightChild() == null) {
                    currentNode.setRightChild(new BinaryTreeNode(childValue));
                    break;
                } else {
                    currentNode = currentNode.getRightChild();
                }
            } else {
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(new BinaryTreeNode(childValue));
                    break;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            }
        } while (true);
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

        return currentNode;
    }


    @Override
    public BinaryTreeNode find(final int value) throws Exception {
        return dfsFind(value);
    }

    private BinaryTreeNode dfsFind(final int value) throws Exception{
        Stack stack = new GenericStack();
        BinaryTreeNode binaryTreeNode = headNode;
        while(binaryTreeNode != null) {
            if(binaryTreeNode.getValue() == value) {
                return binaryTreeNode;
            }
            if(binaryTreeNode.getLeftChild() != null) {
                stack.push(binaryTreeNode.getLeftChild());
            }
            if(binaryTreeNode.getRightChild() != null) {
                stack.push(binaryTreeNode.getRightChild());
            }
            binaryTreeNode = (BinaryTreeNode) stack.pop();
        }
        return null;
    }



    @Override
    public BinaryTreeNode getRootNode() {
        return headNode;
    }

    public static void main (final String args[] ) throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5);
        binarySearchTree.addChild(3);
        binarySearchTree.addChild(4);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(1);
        binarySearchTree.addChild(2);
        binarySearchTree.addChild(5);
        binarySearchTree.addChild(7);
        binarySearchTree.addChild(6);
        binarySearchTree.addChild(9);
        binarySearchTree.addChild(8);
        binarySearchTree.removeNode(5);
        System.out.println("Max Depth: " + binarySearchTree.getHeight() + '\n');
        binarySearchTree.printTree();
    }

    @Override
    public int getHeight() {
        if(headNode != null) {
            return getHeight(headNode, 1);
        } else {
            return 0;
        }
    }

    protected int getHeight(BinaryTreeNode node, int curDepth) {
        int a = curDepth;
        int b = curDepth;
        curDepth += 1;
        if(node == null) {
            return 0;
        }
        if(node.getLeftChild() != null)  {
            a = getHeight(node.getLeftChild(), curDepth) ;
        }
        if(node.getRightChild() != null) {
            b = getHeight(node.getRightChild(), curDepth) ;
        }

        return (a>b?a:b);
    }

    @Override
    public void setRootNode(final BinaryTreeNode rootNode) {
        this.headNode = rootNode;
    }

    @Override
    public void printTree() {
        headNode.print("", true);
        System.out.println("");
    }
}
