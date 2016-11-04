package com.github.atinjin.algorithm;

/**
 * Created by ryanjin on 04/11/2016.
 * Algorithm:

 First swap elements in the middle pair
 Next swap elements in the middle two pairs
 Next swap elements in the middle three pairs
 iterate n-1 steps.

 Ex: with n = 4.
 a1 a2 a3 a4 b1 b2 b3 b4
 a1 a2 a3 b1 a4 b2 b3 b4
 a1 a2 b1 a3 b2 a4 b3 b4
 a1 b1 a2 b2 a3 b3 a4 b4
 */
public class Relocation {

    static int n =4;
    static String[] arr = {
            "a1", "a2", "a3", "a4", "b1", "b2", "b3", "b4"
    };

    static String[][] result = new String[4][8];

    public static void main(String[] args) {

        for(int i=0; i<n; i++) {
            int start = (arr.length / 2)-i;
            for(int j=0; j<i; j++) {
                swap(arr, start+(j*2),start+(j*2)+1);
            }
            for(int k=0;k<arr.length;k++)
                result[i][k] = arr[k];
        }

        for(int i=0; i<result.length; i++) {
            for (int j = 0; j < result[i].length; j++)
                System.out.print(result[i][j] + " ");
            System.out.println("/n");
        }
    }

    private static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
