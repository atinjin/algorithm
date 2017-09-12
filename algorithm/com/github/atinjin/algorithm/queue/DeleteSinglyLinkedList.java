package com.github.atinjin.algorithm.queue;

/**
 * Created by ryanjin on 04/11/2016.
 */
public class DeleteSinglyLinkedList {

    public static void main(String[] args) {

        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");
        LinkedListNode d = new LinkedListNode("D");

        a.next = b;
        b.next = c;
        c.next = d;

        deleteNode(b);

        LinkedListNode iterater = a;
        while(iterater.next!=null) {
            if(iterater.value.equals("B")) {
                System.out.println("FAIL");
                return;
            }
            System.out.print(iterater.value+" ");
            iterater = iterater.next;
        }
        if(iterater.value.equals("B")) {
            System.out.println("FAIL");
            return;
        }
        System.out.println(iterater.value +"\nSUCCESS");
    }

    private static void deleteNode(LinkedListNode node) {
        if(node != null) {
            LinkedListNode nextNode = node.next;
            node.value = nextNode.value;
            node.next = nextNode.next;
        } else
            throw new IllegalArgumentException("Cannot delete the last node with this method.");
    }

    public static class LinkedListNode {

        public String value;
        public LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }

}
