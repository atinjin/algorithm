package com.github.atinjin.algorithm.dynamic;

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
public class Pr_2011_DecryptNumbers {
    //A = 1, ... Z = 26
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String encrypted = in.next();
        int[][] d = new int[encrypted.length()+1][1];
        int count = countDecryptNum(encrypted, d);
        System.out.println(count);
    }

    public static int countDecryptNum(String encrypted, int[][] d) {
        /**
         * i번째 숫자에 따라서 d[i-1]
         */
        d[0][0] = 1;
        int l = encrypted.length();
        if(l == 1) return 1;

        for (int i = 1; i < encrypted.length(); i++) {
            char x = encrypted.charAt(i);
            char pre = encrypted.charAt(i-1);
            int count = 0;
            //1 ~ 9
            if(x >= '1' && x<= '9')
                count++;

            //10 ~ 26
            if( ( pre == '1' && x >= '0' && x <= '9')
                    || ( pre== '2' && x >= '0' && x <= '6' ))
                count++;

            d[i][0] = (d[i-1][0] + count) % 1000000;
        }

        return d[l-1][0];
    }

    @Test
    public void test1() {
        int result = Pr_2011_DecryptNumbers.countDecryptNum("25114", new int[5+1][1]);
        assertEquals(6, result, "25114");
    }
}
