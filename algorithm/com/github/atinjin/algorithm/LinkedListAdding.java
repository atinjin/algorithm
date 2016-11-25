package com.github.atinjin.algorithm;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class LinkedListAdding {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(7,1,6,4);
        List<Integer> b = Arrays.asList(5,8,3);
        List<Integer> c = Arrays.asList();

        //Same to adding integer by human
        //Add each other and %10 and adding 1 next
        //Consider when each list size is different

        int max = (a.size()>b.size())?a.size():b.size();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<max; i++) {
            int valueA = (a.size()>i)?a.get(i):0;
            int valueB = (b.size()>i)?b.get(i):0;
            int sum = valueA + valueB;
            result.add(sum%10);
            if(sum != sum%10) {
                if(a.get(i+1)!=null)
                    a.set(i+1, a.get(i+1)+1);//ERROR : List는 set 함수가 index, 값으로 되어 있다
                else
                    b.set(i+1, b.get(i+1)+1);
            }
        }
        System.out.println(result.toString());

    }

}