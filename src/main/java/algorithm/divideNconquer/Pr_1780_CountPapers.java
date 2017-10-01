package algorithm.divideNconquer;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
public class Pr_1780_CountPapers {
    // https://www.acmicpc.net/problem/1780

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] m = new int[n][n];
        int[] result = new int[3];
        if(n > 0) {
            IntStream.range(0, n).forEach(x -> IntStream.range(0, n).forEach(y -> m[x][y] = in.nextInt()));
            result = countNumbers(0, 0, m.length, m, result);
        }
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] countNumbers(int x, int y, int w, int[][] m, int[] result) {
        boolean isAllSame = hasSameValues(x, y, w, m);
        if(isAllSame)
            result[m[x][y]+1]++;
        else {
            w = w/3;
            countNumbers(x, y, w, m, result);
            countNumbers(x+w, y, w, m, result);
            countNumbers(x+2*w, y, w,  m, result);
            countNumbers(x, y+w, w, m, result);
            countNumbers(x+w, y+w, w, m, result);
            countNumbers(x+2*w, y+w, w,  m, result);
            countNumbers(x, y+2*w, w, m, result);
            countNumbers(x+w, y+2*w, w, m, result);
            countNumbers(x+2*w, y+2*w, w,  m, result);
        }

        return result;
    }

    private static boolean hasSameValues(int x, int y, int w, int[][] m) {
        for(int xi=x; xi<x+w; xi++) {
            for(int yi=y; yi<y+w; yi++) {
                if(m[xi][yi] != m[x][y])
                    return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        int[][] in = {
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {0, 0, 0, 1, 1, 1, -1, -1, -1},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 1, -1, 0, 1, -1, 0, 1, -1},
                {0, -1, 1, 0, 1, -1, 0, 1, -1},
                {0, 1, -1, 1, 0, -1, 0, 1, -1  },
        };
        int[] result = new int[3];
        result = countNumbers(0, 0, in.length, in, result);
        assertArrayEquals(result, new int[]{10, 12, 11}, "count");
    }
}
