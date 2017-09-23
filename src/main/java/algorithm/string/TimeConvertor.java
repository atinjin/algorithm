package com.github.atinjin.algorithm.string;

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
public class TimeConvertor {

    static String timeConversion(String s) {
        String ampm = s.substring(8, 10);
        String time = s.substring(0, 8);
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);

        if(ampm.toLowerCase().equals("am")) {
            //am 12:00AM -> 00:00
            if(hour == 12)
                hour = 0;
        } else {
            //pm 01:00PM -> 13:00, 12:00PM -> 12:00
            if(hour != 12)
                hour+=12;
        }

        return String.format("%02d:"+times[1]+":"+times[2], hour);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }

    @Test
    public void test() {
        TimeConvertor t = new TimeConvertor();
        String r = "12:00:00PM";
        assertEquals( "12:00:00", t.timeConversion(r), r);
        r = "12:00:00AM";
        assertEquals( "00:00:00", t.timeConversion(r), r);
    }
}
