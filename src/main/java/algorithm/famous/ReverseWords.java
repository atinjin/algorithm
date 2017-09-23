package com.github.atinjin.algorithm.famous;

public class ReverseWords {

    public static void main(String[] args) {
        String message = "find you will pain only go you recordings security the into if";

        ReverseWords reverser = new ReverseWords();
        String result = reverser.reverseWords(message);
        System.out.println(result);
    }

    public String reverseWords(String message) {
        //Step. Split with space
        //ERROR String의 split 함수는 정규식을 인자로 받는다
        //ERROR Stirng.split의 return value는 String[]이다
        String[] splits = message.split("\\s");

        //Step. Re-construct message
        for(int i=0; i<splits.length/2; i++) {
            String temp = splits[i];
            splits[i] = splits[splits.length-1-i];
            splits[splits.length-1-i] = temp;
        }
        //Step. Check the last spcae
        //ERROR StringBuilder는 size() 쓰지 않고 length()를 쓴다
        //ERROR StringBuilder는 deleteCharAt으로 지운다

        StringBuilder result = new StringBuilder();
        for(String s: splits) {
            result.append(s).append(" ");
        }
        if(result.length() > 0)
            result.deleteCharAt(result.length()-1);

        return result.toString();
    }


}