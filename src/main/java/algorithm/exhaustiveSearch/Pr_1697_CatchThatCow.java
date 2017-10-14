package algorithm.exhaustiveSearch;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class Pr_1697_CatchThatCow {

    /**
     * 2배로 늘어나는 경우가 있어서 문제에 주어진 사이즈보다 여유 있게 선택했다
     */
    public static final int MAX_SIZE = 200001;

    /**
     * 시작점이 N(0 <= N <= 100000), 찾는점이 K(0 <= K <= 100000)
     * 모두 1초가 걸리는 3가지 움직임 조작이 가능하다
     *  1) +1
     *  2) -1
     *  3) *2
     * 가장 빨리 N에서 K로 가는 방법을 찾아보자.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int result = catchCow(n, k);

        System.out.println(result);
    }

    /**
     * queue를 사용하여 BFS를 구현한다 BFS의 adjective list는 문제에 공식으로 주어졌으므로 필요없다
     */
    private static int catchCow(int n,  int k) {
        int[] dist = new int[MAX_SIZE];
        boolean[] isVisited = new boolean[MAX_SIZE];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        isVisited[n] = true;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            List<Integer> next = getNext(x);
            next.forEach(i -> {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dist[i] = dist[x] + 1;
                    queue.offer(i);
                }
            });
        }

        return dist[k];
    }

    private static List<Integer> getNext(int x) {
        ArrayList<Integer> next = new ArrayList<>();

        putNext(next, x + 1);
        putNext(next, x - 1);
        putNext(next, x * 2);

        return next;
    }

    private static void putNext(ArrayList<Integer> next, int nextX) {
        /**
         * 값이 0보다 크거나 같을 수 있다는 것에 주의 해야 한다
         */
        if(nextX >= 0 && nextX < MAX_SIZE)
            next.add(nextX);
    }

    @Test
    public void test() {
        assertEquals(4, catchCow(5,17), "5 : 10 9 18 17");
        assertEquals(2, catchCow(2,8), "2 : 4 8");
        assertEquals(5, catchCow(1,15), "1 : 2 4 8 16 15");
        assertEquals(21, catchCow(1,100000), "1 : ..... 100000");
        assertEquals(0, catchCow(0,0), "0 :");
        assertEquals(1, catchCow(1,0), "1 : 0");
    }

}
