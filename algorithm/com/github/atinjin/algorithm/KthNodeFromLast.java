package com.github.atinjin.algorithm;

/**
 * Created by ryanjin on 09/11/2016.
 */
public class KthNodeFromLast {
    public static String kthToLastNode(int k, LinkedListNode list) {
        // write the body of your function here
        LinkedListNode head = list, tail = list;
        int n = 0;
        while(tail.next != null) {
            tail = tail.next;
            n++;
            if(n - k >= 0)
                head = head.next;
        }

        return "running with " + head.value;
    }
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        LinkedListNode a = new LinkedListNode("Angel Food");
        LinkedListNode b = new LinkedListNode("Bundt");
        LinkedListNode c = new LinkedListNode("Cheese");
        LinkedListNode d = new LinkedListNode("Devil's Food");
        LinkedListNode e = new LinkedListNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;


        System.out.println(kthToLastNode(3, a));
    }

    public static class LinkedListNode {

        public String value;
        public LinkedListNode next;

        public LinkedListNode(String value) {
            this.value = value;
        }
    }
}

