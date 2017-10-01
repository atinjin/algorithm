package algorithm.divideNconquer;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.stream.IntStream;

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
public class Pr_11728_MergeArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sizeA = in.nextInt();
        int sizeB = in.nextInt();

        int[] a = new int[sizeA];
        int[] b = new int[sizeB];
        IntStream.range(0, sizeA).forEach(i -> {
            a[i] = in.nextInt();
        });
        IntStream.range(0, sizeB).forEach(i -> {
            b[i] = in.nextInt();
        });

        int[] m = merge(a, b);
        IntStream.range(0, m.length).forEach(i -> System.out.print(m[i]+" "));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] m = new int[a.length+b.length];

        int i = 0;
        int ai = 0;
        int bi = 0;
        while(ai < a.length && bi < b.length) {
            if(a[ai] == b[bi]) {
                m[i++] = a[ai++];
                m[i++] = b[bi++];
            } else if(a[ai] > b[bi]) {
                m[i++] = b[bi++];
            } else {
                m[i++] = a[ai++];
            }
        }
        while(ai < a.length) {
            m[i++] = a[ai++];
        }
        while(bi < b.length) {
            m[i++] = b[bi++];
        }
        return m;
    }

    @Test
    public void test() {
        int[] a = {2,3,5,9};
        int[] b = {1,4,7};
        int[] m = merge(a, b);
        assertArrayEquals(m, new int[]{1, 2, 3, 4, 5, 7, 9}, "arrays");
    }
}
