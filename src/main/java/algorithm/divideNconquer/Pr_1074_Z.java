package algorithm.divideNconquer;

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
public class Pr_1074_Z {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        /**
         *  좌표는 다음과 같이 표현된다 x axis가 상하로 y axis가 좌우로 된다
         *  (x0, y0) (x0, y1) (x0, y2)
         *  (x1, y0) (x1, y1) (x1, y2)
         *  (x2, y0) (x2, y1) (x2, y2)
         *
         */

        int result = count(n, x, y);
        System.out.println(result);
    }

    private static int count(int n, int x, int y) {
        /*
         * 4개의 분면으로 나누었다고 헀을때
         *  1사분면  /  2사분면
         *  3사분면  /  4사분면
         */

        //최소 단위일 경우
        if( n == 1) {
            /*
             * 1칸 짜리만 남았을 경우 : 2 x 2 매트릭스 형태에서 (x, y)좌표에 따른 이동 횟수는 다음과 같은 식으로 간단히 표현할 수 있다
             * (0,0) : 0 (시작점이기 때문에 움직일 필요없음)
             * (0,1) : 1
             * (1,0) : 2
             * (1,1) : 3
             */
           return 2 * x + y;
        } else {
            /*
             *  2,3,4 사분면일 경우, 이전 사분면의 이동횟수에 현재 사분면의 이동 횟수를 더하면 된다.
             *  현재 사분면의 이동횟수를 구하기 위해서 count 함수를 recursive call 하면 된다.
             *
             *  여기서 이전 사분면의 이동 횟수를 한번에 계산 가능하면 계산 횟수를 줄일 수 있다
             *  사분면 내의 칸의 수를 변의 길이의 제곱을 하면 된다.
             *  즉 2칸짜리 2x2 일 경우, 이동 횟수는 2 * 2 = 4
             *  4칸짜리 4x4 일 경우 이동 횟수는 4 * 4 = 16
             *  2^n 칸짜리 일 경우 이동 횟수는 2^n * 2^n = 2^(2n)
             *
             *  x, y 좌표는 새로운 사분면을 기준으로 바꿔줘야 하기 때문에 2,3,4 분면의 경우 값을 변경해줘야 한다
             */

            int half = (int)Math.pow(2, n-1);
            //1사분면
            if( x < half && y < half) {
                return count(n-1, x, y);
            }
            //2사분면
            else if( x < half && y >= half) {
                return half*half + count(n-1, x, y - half);
            }
            //3사분면
            else if( x >= half && y < half) {
                return half*half * 2 + count(n-1, x - half, y);
            }
            //4사분면
            else {
                return half*half * 3 + count(n-1, x - half, y - half);
            }

        }
    }

    @Test
    public void test() {
        assertEquals(11, count(2,3,1), "2, 3, 1");
        assertEquals(63, count(3,7,7), "3 7 7");
    }
}
