package algorithm.exhaustiveSearch;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

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

    private static int catchCow(int n, int k) {
        return 0;
    }

    @Test
    public void test() {
        int n = 5;
        int k = 17;

        assertEquals(4, catchCow(n,k), String.format("from %s to %s", n, k));
    }

}
