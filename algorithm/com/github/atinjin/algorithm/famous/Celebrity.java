package com.github.atinjin.algorithm.famous;

import java.util.Stack;

public class Celebrity {

    static int[][] matrix = {
            {0,0,0,1,1}
            ,{1,0,0,0,1}
            ,{0,1,0,0,1}
            ,{1,1,0,0,1}
            ,{0,0,0,0,0}
    };

    public static void main(String[] args) {
        //Step1. Make a stack
        Stack stack = new Stack();
        for(int i=0; i < matrix.length; i++) {
           stack.push(new Integer(i));
        }

        //Step2. Find the Candidate
        Integer first = (Integer) stack.pop();
        Integer second = (Integer)stack.pop();

        while(stack.size() > 0) {
            if (matrix[first.intValue()][second.intValue()] != 0)//first know second(first isn't the celebrity)
                first = (Integer) stack.pop();
            else //first don't know second(second isn't the celebrity)
                second = (Integer) stack.pop();
        }

        int celebrity = 0;
        if(matrix[first.intValue()][second.intValue()] != 0 )
            celebrity = second.intValue();
        else
            celebrity = first.intValue();

        System.out.println("Candidate is "+celebrity);

        //Step3. Verify
        for(int i=0; i < matrix.length; i++) {
            if (i != celebrity)
                if( matrix[i][celebrity] == 1 && matrix[celebrity][i] == 0)
                    continue;
                else
                    celebrity = -1;
        }

        System.out.println("Celebrity is "+celebrity+"th person");
        return;
    }
}


