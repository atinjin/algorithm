package algorithm.divideNconquer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
public class Pr_11729_TowerHanoi {
    /**
     * 하노이탑 문제를 풀기 위해서는 DNC 문제라는 것을 이용해야 한다
     * 탑을 옮기는 문제는 탑 높이에 상관없이 계속 같은 방식으로 반복되는 것이다
     * 즉 1층짜리 탑을 옮기는 것은 2층짜리 탑을 옮기는 것에 포함된다
     *
     * D[n] = 2 * D[n-1] + 1
     *
     * https://www.acmicpc.net/problem/11729
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = 1;
        int y = 2;
        int z = 3;
        movingTower(n, x, z);
        System.out.println(answer.size());
        answer.stream().forEach(System.out::println);
    }

    private static final int max = 1 + 2 +3;

    private static final List<String> answer = new ArrayList<>(20);

    private static void movingTower(int n, int from, int to) {
        if(n < 1)
            return;
        movingTower(n-1, from, max - from - to);
        String move = String.format("%s %s", from, to);
        //System.out.println(move);
        answer.add(move);
        movingTower(n-1, max - from - to, to);
    }

    @Test
    public void test() {
        movingTower(3, 1, 3);
        assertArrayEquals(
                new String[]{"1 3",
                                "1 2",
                                "3 2",
                                "1 3",
                                "2 1",
                                "2 3",
                                "1 3"}
                , answer.toArray(new String[answer.size()])
                , "3 floors");

    }

}
