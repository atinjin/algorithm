package com.github.atinjin.algorithm;

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
public class Pr_1463_makeOne {
//    정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//            X가 3으로 나누어 떨어지면, 3으로 나눈다.
//    X가 2로 나누어 떨어지면, 2로 나눈다.
//            1을 뺀다.
//    정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최소값을 출력하시오.
//
//            입력
//    첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 자연수 N이 주어진다.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

//        int count = makeOne(x);
        int count = makeOneBottomUp(x);
        System.out.println(count);
    }

    private static int makeOneBottomUp(int x) {

        d[1] = 0;
        for(int i=2; i<x+1; i++) {
            int count = Integer.MAX_VALUE;
            if(i % 3 == 0)
                count = Math.min(count, d[i/3]+1);

            if(i % 2 == 0)
                count = Math.min(count, d[i/2]+1);

            count = Math.min(count, d[i-1]+1);

            d[i] = count;
        }
        return d[x];
    }

    public static int[] d = new int[1000001];
    private static int makeOne(int x) {
        if(x == 1) return 0;

        if(d[x] != 0) return d[x];
        int count = Integer.MAX_VALUE;
        if(x % 3 == 0)
            count = Math.min(count, makeOne(x/3)+1);

        if(x % 2 == 0)
            count = Math.min(count, makeOne(x/2)+1);

        count = Math.min(count, makeOne(x-1)+1);

        d[x] = count;
        return count;
    }

    @Test
    public void test1() {
        Pr_1463_makeOne m = new Pr_1463_makeOne();
        assertEquals(1, m.makeOneBottomUp(2), "2");
        assertEquals(3, m.makeOneBottomUp(10), "10");
        assertEquals(2, m.makeOneBottomUp(9), "9");
        assertEquals(9, m.makeOneBottomUp(1000), "1000");
    }
}