package datastructures.linkedlist;

/**
 * Created by andrew on 3/11/17.
 */
public class LinkedListNode {
    public int val;
    public LinkedListNode next;

    public LinkedListNode(int val) {
        this.val = val;
    }

    public LinkedListNode withNextNode(LinkedListNode next) {
        this.next = next;
        return this;
    }
}
