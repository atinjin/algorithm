package com.github.atinjin.algorithm.dynamic;

import java.util.LinkedList;
import java.util.Queue;
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
public class Pr_1157_Josephus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Queue<Integer> q = new LinkedList<>();
        IntStream.range(0+1, n+1).forEach(q::offer);
        System.out.print("<");
        while(q.size() > 0) {
            IntStream.range(0, m-1).forEach(i -> {int value = q.poll(); q.offer(value);});
            int remove = q.poll();
            System.out.print(((q.size()==n-1)?"":", ") +remove);
        }
        System.out.print(">");
    }
}
