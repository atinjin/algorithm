package algorithm.famous;

import java.util.ArrayList;
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
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        /**
         * 범위 안의 수가 소수라고 초기화 한다.
         */
        ArrayList<Boolean> list = new ArrayList(n+1);
        IntStream.range(0,n+1).forEach(i -> list.add(true));

        list.set(0, false);
        list.set(1, false);
        for(int i=2; i < n+1; i++) {
            if(list.get(i)) {
                System.out.println(i);
                for(int j=2; i * j<=n; j++) {
                    list.set(i*j, false);
                }
            }
        }
    }
}
