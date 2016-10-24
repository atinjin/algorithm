package com.github.atinjin.algorithm;

public class Wildcard {
    
    public static void main(String[] args) {
        System.out.println("Start the Wildcard Algorithm\n-------------------------");
        if(args.length == 2)
                run(args[0], args[1]);
        else
                System.out.println("Input the wildcard pattern and string.");
    }

    public static void run(String w, String s) {
        System.out.println("Patter["+w+"]"+ "-->" +s); 
        if(match(w, s))
                System.out.println("Result = Mateched");
        else
                System.out.println("Result = Not matched");
    }
    
    public static boolean match(String w, String s) {
        int pos = 0;

        while(pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos)))
                pos++;

        if(pos == w.length())
                return pos == s.length();

        if(w.charAt(pos) == '*')
                for(int skip=0; pos+skip <= s.length(); ++skip) {
                    if(match(w.substring(pos+1), s.substring(pos+skip)))
                        return true;
                }

        return false;
    }

}
