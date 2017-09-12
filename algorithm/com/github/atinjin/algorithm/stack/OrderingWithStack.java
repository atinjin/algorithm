package com.github.atinjin.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

public class OrderingWithStack {

    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(3);
        stack.offerFirst(1);
        stack.offerFirst(5);
        stack.offerFirst(8);
        stack.offerFirst(6);
        
        Deque<Integer> tempStack = new LinkedList<>();
        
        int size = stack.size();
        for(int i=0; i<size; i++) {
            int min = stack.pollFirst();
            for(int j=0; j<size-i-1;j++) {
                int val = stack.pollFirst();
                if(val < min) {
                    tempStack.offerFirst(min);
                    min = val;
                } else
                    tempStack.offerFirst(val);
            }
            stack.offerFirst(min);
            while(!tempStack.isEmpty())
                stack.offerFirst(tempStack.pollFirst());
        }

        while(stack.peekFirst() != null) {
            System.out.println(stack.pollFirst());
        }
    }



}