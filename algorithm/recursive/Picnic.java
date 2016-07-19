import java.io.*;
import java.util.*;

public class Picnic {


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        List<Integer> numberOfPr = scanner.nextIntArray();
        int total = numberOfPr.get(0);
        int[][] classmate = new int[3][total];
        for(int pr=0; pr < total; pr++) {
            List<Integer> nums = scanner.nextIntArray();
            classmate[pr][0] = nums.get(0);
            classmate[pr][1] = nums.get(1);

        }
        for(int pr=0; pr < total; pr++) {
            System.out.println("n(Students)="+classmate[pr][0]);
            System.out.println("n(friends)="+classmate[pr][1]);
        }
    }


    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
       String next() {
        while(st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
           } catch (IOException e) {
                e.printStackTrace();
           }
        }
        return st.nextToken();
       }
        
        List<String> nextArray() {
           List<String> strs = new ArrayList<String>();
           try {
            st = new StringTokenizer(br.readLine());
           } catch (Exception e) {
                e.printStackTrace();
           }
           while(st.hasMoreTokens()) {
            strs.add(st.nextToken());
           }
           return strs;
        }

       int nextInt() {
            return Integer.parseInt(next());       
       }

       List<Integer> nextIntArray() {
            List<String> strs = nextArray();
            List<Integer> nums = new ArrayList<Integer>();
            for(String str: strs) {
                int num = Integer.parseInt(str);
                nums.add(num);
            }
            return nums;
       }
    }
}
