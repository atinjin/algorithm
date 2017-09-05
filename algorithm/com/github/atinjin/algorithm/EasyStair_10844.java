package com.github.atinjin.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
public class EasyStair_10844 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long[][] d = new long[101][10];
        IntStream.range(1,9+1).forEach(i -> d[1][i] = 1);
        IntStream.range(2,n+1).forEach(i -> {
            IntStream.range(0, 9+1).forEach(j -> {
                if(j-1 >= 0) d[i][j] += d[i-1][j-1];
                if(j+1 <= 9) d[i][j] += d[i-1][j+1];
                d[i][j] = d[i][j] % 1000000000;
            });
        });

        System.out.println(Arrays.stream(d[n]).sum() % 1000000000);

    }
}


