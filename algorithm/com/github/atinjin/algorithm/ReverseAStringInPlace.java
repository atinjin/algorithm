package com.github.atinjin.algorithm;

/**
 * Created by ryanjin on 18/11/2016.
 */
public class ReverseAStringInPlace {
	
	public static void main(String[] args) {
		String input = null;
        if(args.length == 0)
            input = "abcdef";

        //ERROR : Char[]가 아니라 char[] 이다. String을 char array 변환할 때는 toCharArray를 사용한다.
		char[] values = input.toCharArray();
		//if lenght is 5[0,1,2,3,4], until i=0,1
		for(int i=0; i<values.length/2; i++) {
			char front = values[i];
			values[i] = values[values.length-1-i];
			values[values.length-1-i] = front;
		}
		//ERROR : char[]를 String으로 만들 때, toArray를 사용하면 decimal 값이 나온다 대신에 String.valueOf함수를 이용하여 String을 생성해야 한다
		String result = String.valueOf(values);
		System.out.println("Result = "+result);
	}
}
