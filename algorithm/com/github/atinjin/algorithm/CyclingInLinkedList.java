package com.github.atinjin.algorithm;

/**
 * Created by ryanjin on 04/11/2016.
 */
public class CyclingInLinkedList {

    public static void main(String[] args) {

        DeleteSinglyLinkedList.LinkedListNode a = new DeleteSinglyLinkedList.LinkedListNode("A");
        DeleteSinglyLinkedList.LinkedListNode b = new DeleteSinglyLinkedList.LinkedListNode("B");
        DeleteSinglyLinkedList.LinkedListNode c = new DeleteSinglyLinkedList.LinkedListNode("C");
        DeleteSinglyLinkedList.LinkedListNode d = new DeleteSinglyLinkedList.LinkedListNode("D");
        DeleteSinglyLinkedList.LinkedListNode e = new DeleteSinglyLinkedList.LinkedListNode("E");
        DeleteSinglyLinkedList.LinkedListNode f = new DeleteSinglyLinkedList.LinkedListNode("F");
        DeleteSinglyLinkedList.LinkedListNode g = new DeleteSinglyLinkedList.LinkedListNode("G");
        DeleteSinglyLinkedList.LinkedListNode h = new DeleteSinglyLinkedList.LinkedListNode("H");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = null;


        DeleteSinglyLinkedList.LinkedListNode slowRunner = a;
        DeleteSinglyLinkedList.LinkedListNode fastRunner = b;

        while(slowRunner != fastRunner) {
            slowRunner = slowRunner.next;
            fastRunner = (fastRunner.next!=null)?fastRunner.next.next:null;
            if(slowRunner == null || fastRunner == null) {
                System.out.println("No cycles. slow="+((slowRunner == null)?"null":slowRunner.value) +", fast="
                        +((fastRunner == null)?"-":fastRunner.value));
                return;
            }
        }
        System.out.println("Has a cycle."+slowRunner.value +" " +fastRunner.value) ;

    }

}
