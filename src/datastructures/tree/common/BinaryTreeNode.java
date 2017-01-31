package datastructures.tree.common;

/**
 * Node in a binary tree
 */
public class BinaryTreeNode {
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    int value;

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(final BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(final BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode(final int value) {
        this.value = value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void removeNode(final int removeValue) {

    }


    public void print(String prefix, boolean isTail) {
        int numChildren =0;
        if(leftChild != null) {
            numChildren ++;
        }
        if(rightChild != null) {
            numChildren++;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + value);
        if(rightChild!= null) {
            rightChild.print(prefix + (isTail ? "    " : "│   "), false);
        }
        if(leftChild != null) {
            leftChild.print(prefix + (isTail ? "    " : "│   "), false);
        }
    }

    public void depth() {
    }
}
