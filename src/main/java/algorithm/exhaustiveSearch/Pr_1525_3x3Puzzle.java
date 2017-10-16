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
public class Pr_1525_3x3Puzzle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


    }

    public static int doPuzzle(int[] puzzle) {
        /**
         * node에 해당하는 상태를 어떻게 표현할 것인가?
         * 상태의 총 개수는 9! = 362,880
         * 방법1) Array로 나타내기
         * 방법2) Permutation 번호로 표시하기
         * 방법3) 순서를 숫자 또는 문자열로 표시하기
         *    1번 방법의 경우는 362880 * 9 만큼의 저장 공간이 필요하다
         *    2번 방법의 경우 먼저 Permutation을 모두 구해야 한다
         *    3번 방법의 경우 숫자 또는 문자열 형태에서 숫자를 이동하는 로직을 작성해야 한다
         *
         *  위의 방법 중 3번 방법이 복잡도가 가장 낮아 이 방법을 사용해본다
         *
         * isVisited 여부를 저장하기 위해서 Array 보다는 Map을 사용한다
         * 또한 Depth 또는 이전 상태를 저장하기 위해서 value값을 사용한다
         *   Map<String,Boolean> isVisited
         */




        return 0;
    }

    public void BFS(String root) {
        Map<String,Boolean> isVisited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(root);
        isVisited.put(root, true);
        while(!queue.isEmpty()) {
            String now = queue.poll();
            List<String> next = getNext(now, isVisited);
            next.forEach(n -> {
                queue.offer(n);
                isVisited.put(n, true);
            });
        }
    }

    private List<String> getNext(String now, Map<String, Boolean> isVisited) {

        int index = now.indexOf("0");

        //Up
        if(index > 3 && index < 9) {
            index = index - 3;
        }
        //Down
        if(index > 0 && index < 6) {
            index = index + 3;
        }

        //Right

        //Left



        return null;
    }

    public static int[] answer = new int[]{1,2,3,4,5,6,7,8,0};

    @Test
    public void test() {
        /**
         * 1 0 3
         * 4 2 5
         * 7 8 6
         */

        int[] puzzle = new int[]{1,0,3,4,2,5,7,8,6};

        doPuzzle(puzzle);

        assertEquals(3, doPuzzle(puzzle));
    }

}
