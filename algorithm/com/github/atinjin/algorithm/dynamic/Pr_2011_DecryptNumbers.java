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

        int count = countDecryptNum(encrypted);
        System.out.println(count);
    }

    public static int countDecryptNum(String encrypted) {
        /**
         * i번째 숫자에 따라서 d[i-1]
         */
        int[] d = new int[encrypted.length()+1];
        encrypted = " "+ encrypted;
        char[] s = encrypted.toCharArray();

        d[0] = 1;
        int l = encrypted.length();

        for (int i = 1; i <= encrypted.length()-1; i++) {
            char x = s[i];
            char pre = s[i-1];
            //1 ~ 9
            if(x >= '1' && x<= '9')
                d[i] = d[i] + d[i-1];

            //10 ~ 26
            if( (( pre == '1' && x >= '0' && x <= '9') || ( pre== '2' && x >= '0' && x <= '6' )) ) {
                d[i] = (d[i] + d[i - 2]) % 1000000;
            }
        }

        return d[l-1];
    }

    @Test
    public void test1() {
        int result = Pr_2011_DecryptNumbers.countDecryptNum("25114");
        assertEquals(6, result, "25114");
    }
    @Test
    public void test2() {
        String num = "123"; //1,23 //12,3//1,2,3
        int result = Pr_2011_DecryptNumbers.countDecryptNum(num);
        assertEquals(3, result, num);
    }
}
