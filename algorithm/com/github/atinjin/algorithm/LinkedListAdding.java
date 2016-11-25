package com.github.atinjin.algorithm;

public class LinkedListAdding {

    public stataic void main(String[] args) {
        List<Integer> a = Arrays.asList(7,1,6);
        List<Integer> b = Arrays.asList(5,9,2);
        
        //Same to adding integer by human
        //Add each other and %10 and adding 1 next
        //Consider when each list size is different

        int max = (a.size()>b.size())?a.size():b.size();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<max; i++) {
            int valueA = (a.get(i)!=null)?a.get(i):0;
            int valueB = (b.get(i)!=null)?b.get(i):0;
            int sum = valueA + valueB;
            result.add(sum%10);
            if(sum != sum%10) {
                if(a.get(i+1)!=null)
                    a.set(a.get(i+1)+1);
                else
                    b.set(b.get(i+1)+1);
            }
        }
        System.out.println(result.toString());

    }

}