package algorithm.famous;

import java.util.Scanner;

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
         * Tail에서부터 최장 감소수열을 찾는다
         * 그 이유는 현재 진행중인 Permutation 구간을 찾기 위해서이다
         */
        GetLongestDecArray getLongestDecArray = new GetLongestDecArray(a).invoke();
        if (getLongestDecArray.is()) return false;
        int i = getLongestDecArray.getI();

        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }

        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
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

    private static class GetLongestDecArray {
        private boolean myResult;
        private int[] a;
        private int i;

        public GetLongestDecArray(int... a) {
            this.a = a;
        }

        boolean is() {
            return myResult;
        }

        public int getI() {
            return i;
        }

        public GetLongestDecArray invoke() {
            i = a.length - 1;
            while (i > 0 && a[i - 1] >= a[i]) {
                i -= 1;
            }
            if (i <= 0) {
                // 마지막 순열
                myResult = true;
                return this;
            }
            myResult = false;
            return this;
        }
    }
}
