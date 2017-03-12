package datastructures.linkedlist.practice;

import datastructures.linkedlist.LinkedListNode;

/**
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 */
public class LoopDetection {
    public static void main(String args[]) {
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode node1 = new LinkedListNode(2);
        LinkedListNode node2 = new LinkedListNode(3);
        LinkedListNode node3 = new LinkedListNode(4);
        LinkedListNode node4 = new LinkedListNode(5);
        LinkedListNode node5 = new LinkedListNode(6);
        LinkedListNode node6 = new LinkedListNode(7);
        LinkedListNode node7 = new LinkedListNode(8);
        LinkedListNode node8 = new LinkedListNode(9);
        LinkedListNode node9 = new LinkedListNode(10);
        head.withNextNode(node);
        node.withNextNode(node1);
        node1.withNextNode(node2);
        node2.withNextNode(node3);
        node3.withNextNode(node4);
        node4.withNextNode(node5);
        node5.withNextNode(node6);
        node6.withNextNode(node7);
        node7.withNextNode(node8);
        node8.withNextNode(node9);
        node9.withNextNode(null);

        LinkedListNode loopHead = getNodeBeginningLoop(head);
        System.out.println(loopHead == null ? -99 : loopHead.val);
    }



    public static LinkedListNode getNodeBeginningLoop(final LinkedListNode head) {
        LinkedListNode runner = head;
        LinkedListNode walker = head;

        do{
            if(runner.next == null || runner.next.next == null) {
                return null;
            }
            runner = runner.next.next;
            walker = walker.next;
        } while(runner != walker);

        walker = head;

        while(runner != walker) {
            walker = walker.next;
            runner = runner.next;
        }

        return walker;
    }
}
