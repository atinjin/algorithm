package algorithm.exhaustiveSearch;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * (C) Copyright 2017 Ryan Donghyun Jin (http://ryanjin.net/).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Contributors:
 * Ryan Donghyun Jin (atinjin@gmail.com)
 */
public class Pr_9019_DSRL {
    /**
     * 4가지 연산이 정의되어 있다
     *  D : * 2  ex) 1234 -> 2468
     *  S : -1  ex) 1234 -> 1233
     *  R : 10진수 오른쪽 shift  ex) 1234 -> 4123
     *  L : 10진수 왼쪽 shift  ex) 1234 -> 2341
     *
     *  주어진 수 A를 B로 변환하기 위한 최소 연산 방법을 구하라.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTc = in.nextInt();

        int[][] tc = new int[numTc][2];
        IntStream.range(0, numTc).forEach(i -> {
            tc[i][0] = in.nextInt();
            tc[i][1] = in.nextInt();
        });

        IntStream.range(0, tc.length).forEach(i ->{
            String sol = findSolution(tc[i]);
            System.out.println(sol);
        });
    }

    private static String findSolution(int[] tc) {
        int a = tc[0];
        int b = tc[1];

        boolean[] isVisited = new boolean[10000];
        int[] from = new int[10000];
        String[] ops = new String[10000];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        isVisited[a] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(now == b) break;
            Map<String,Integer>  nexts = getNext(now);
            nexts.forEach((op,next) -> enqueue(isVisited, from, ops, queue, now, next, op));
        }

        return getOperations(from, ops, b, a);
    }

    private static String getOperations(int[] from, String[] ops, int b, int a) {
        StringBuffer stb = new StringBuffer();

        while(b != a && ops[b] != null) {
            stb.append(ops[b]);
            b = from[b];
        }

        return stb.reverse().toString();
    }

    private static Map<String,Integer> getNext(int now) {
        Map<String,Integer> nexts = new LinkedHashMap<>();

        /**
         * caution : now 값이 0(zero)인 경우를 조심해야 한다
         * 문제의 조건에서 S operation의 경우, 0일 경우 9999로 변한다고 하였다
         *
         * 한가지 더 유의할 점은
         *  0 / 1000 = 0
         *  0 % 100 = 0
         * 연산 오류가 발생하지 않는다
         */

        // D
        nexts.put("D", (now * 2) % 10000);
        // S
        nexts.put("S", (now == 0)?9999:now - 1);
        // L : 1234 -> 2341
        nexts.put("L", /*(now == 0)?0:*/now / 1000 + (now % 1000) * 10);
        // R : 1234 -> 4123
        nexts.put("R", /*(now == 0)?0:*/(now % 10) * 1000 + now / 10);
        return nexts;
    }

    private static void enqueue(boolean[] isVisited, int[] from, String[] ops, Queue<Integer> queue
                                , int now, int next, String op) {
        if(!isVisited[next]) {
            ops[next] = op;
            from[next] = now;
            isVisited[next] = true;
            queue.offer(next);
        }
    }

    @Test
    public void test() {
        assertTrue(Arrays.asList("LL").contains(findSolution(new int[]{1234, 3412})));
        assertEquals("L", findSolution(new int[]{1000, 1}));
        assertEquals("DDDD", findSolution(new int[]{1, 16}));
        assertEquals("", findSolution(new int[]{0, 0}));
    }

    @Test
    public void testO() {
        assertEquals("SSRDRSRDRDDDRR", findSolution(new int[]{0, 2}));
    }

    @Test
    public void test1() {
        assertEquals("SS", findSolution(new int[]{1, 9999}));
    }

    @Test
    public void test2() {
        assertEquals("S", findSolution(new int[]{9999, 9998}));
    }

    @Test
    public void test3() {
        assertEquals("SDSDRS", findSolution(new int[]{9999, 998}));
    }

    @Test
    public void test4() {
        Map<String,Integer> map = getNext(0);
        map.forEach((k,v) -> System.out.println(k + " : " +v));
    }
}
