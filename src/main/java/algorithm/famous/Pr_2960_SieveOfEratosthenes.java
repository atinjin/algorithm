package algorithm.famous;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

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
public class Pr_2960_SieveOfEratosthenes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int i = find(n, k);
        System.out.println(i);
    }

    private static int find(int n, int k) {
        /**
         * 범위 안의 수가 소수라고 초기화 한다.
         */
        ArrayList<Boolean> list = new ArrayList(n+1);
        IntStream.range(0,n+1).forEach(i -> list.add(true));

        list.set(0, false);
        list.set(1, false);
        int countDel = 0;
        for(int i=2; i <= n; i++) {
            if(list.get(i)) {
                countDel++;
                if( countDel == k )
                    return i;

                /**
                 * j를 i*i에서 시작해도 되는 이유는 i * (i-1)까지의 수는 이미
                 * i-1번째에서 확인되었기 때문이다.
                 */
                for(int j=i; i * j<=n; j++) {
                    if(list.get(i*j)) {
                        list.set(i * j, false);
                        countDel++;
                        if (countDel == k)
                            return i * j;
                    }
                }
            }
        }
        return -1;
    }

    private static int find2(int n, int k) {
        boolean[] primes = new boolean[1001];
        int deleted = 0;
        for(int i = 2; i <= n; i++) {
            if(!primes[i]) {
                primes[i] = true;
                deleted++;
                if(deleted == k)
                    return i;
                int tmp = i * i;
                while(tmp <= n) {
                    if(!primes[tmp]){
                        primes[tmp] = true;
                        deleted++;
                        if(deleted == k) {
                            return tmp;
                        }
                    }
                    tmp += i;
                }
            }
        }
        return -1;
    }


    @Test
    public void test() {
        /*
        2, 4, 6, 8, 10, 3, 9, 5, 7
         */
        assertEquals(9, find(10, 7));
        assertEquals(3, find(10, 6));
        assertEquals(7, find(10, 9));
        assertEquals(9, find2(10, 7));
        assertEquals(3, find2(10, 6));
        assertEquals(7, find2(10, 9));
    }
}
