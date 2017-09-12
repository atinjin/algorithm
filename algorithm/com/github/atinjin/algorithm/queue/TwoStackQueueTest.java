package com.github.atinjin.algorithm.queue;

import java.util.Stack;

public class TwoStackQueueTest {

    public static void main(String[] args)  {
         TwoStackQueue queue = new TwoStackQueue();
         
         int[] data = {1,2,3,4,5};
         queue.enqueue(data[0]);
         queue.enqueue(data[1]);
         queue.enqueue(data[2]);
         queue.enqueue(data[3]);
         queue.enqueue(data[4]);

         for(int i=0; i<queue.size(); i++) {
             if(!queue.dequeue().equals(data[i]))
                 System.out.println("Fail");    
         }
    }

    public static class TwoStackQueue {
        Stack enqueueStack = new Stack();
        Stack dequeueStack = new Stack();

        public void enqueue(Object o) {
            enqueueStack.push(o);
        }

        public Object dequeue() {
            if(dequeueStack.size() == 0)
                while(enqueueStack.size() > 0)
                    dequeueStack.push(enqueueStack.pop());
            return dequeueStack.pop();
        }

        public int size() {
            return enqueueStack.size() + dequeueStack.size();
        }
    }

}
