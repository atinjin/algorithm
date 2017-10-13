package algorithm.famous;

import org.junit.jupiter.api.Test;

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
public class Pr_10972_NextPermutation {
    public static boolean next_permutation(int[] a) {

        /**
         * Tail에서부터 최장 감소수열의 첫번째 인덱스(i)을 찾는다
         * 그 이유는 현재 진행중인 Permutation 구간을 찾기 위해서이다
         * 여기서 i-1은 현재 순열의 pivot이 되는 수이다
         * 이를 기준으로 아래의 값들이 사전순으로 움직인다
         */
        int i = getFirstIndexOfLongestDec(a);
        if (i <= 0) {
            /**
             * index가 0이라는 것은 현재 수열이 처음부터 끝까지 감소 수열 즉 마지막이라는 것이다
             * 예) 7 6 5 4 3 2 1
             */
            return false;
        }

        /**
         * 사전순에서 다음으로 기준이 될 숫자를 찾는다
         * 내림차순 수열 중에서 현재 기준 숫자보다 큰 수중 가장 작은 수를 선택한다
         * 예) 7 4 (6 5 2)  일 경우 (5 3 2) 에서 현재 pivot인 4보다 큰 수는 5이다
         */
        int j = getNextPivotIndex(a, a[i - 1]);

        swap(a, i-1, j);

        invertArrayFromToEnd(a, i);

        return true;
    }

    private static int getNextPivotIndex(int[] a, int i) {
        int j = a.length - 1;
        while (a[j] <= i) {
            j -= 1;
        }
        return j;
    }

    private static void invertArrayFromToEnd(int[] a, int i) {
        int j = a.length - 1;
        while (i < j) {
            swap(a, i, j);
            i += 1;
            j -= 1;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
//        System.out.println(String.format("swap %s : %s", i, j));
    }

    private static int getFirstIndexOfLongestDec(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i - 1] >= a[i]) {
            i -= 1;
        }
        return i;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        if (next_permutation(a)) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("-1");
        }
    }

    @Test
    public void test() {
        int[] in = {7, 4, 6, 5, 2};
        Pr_10972_NextPermutation.next_permutation(in);
        assertArrayEquals(new int[]{7, 5, 2, 4, 6}, in, "{7, 4, 6, 5, 2}");
    }

    @Test
    public void test2() {
        int[] in = {1, 2, 3, 4, 5};

        Pr_10972_NextPermutation.next_permutation(in);
        assertArrayEquals(new int[]{1, 2, 3, 5, 4}, in, "{1, 2, 3, 4, 5} 2nd");
        Pr_10972_NextPermutation.next_permutation(in);
        assertArrayEquals(new int[]{1, 2, 4, 3, 5}, in, "{1, 2, 3, 4, 5} 3rd");
        Pr_10972_NextPermutation.next_permutation(in);
        assertArrayEquals(new int[]{1, 2, 4, 5, 3}, in, "{1, 2, 3, 4, 5} 4th");
        Pr_10972_NextPermutation.next_permutation(in);
        assertArrayEquals(new int[]{1, 2, 5, 3, 4}, in, "{1, 2, 3, 4, 5} 5th");
    }

}
