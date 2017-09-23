package algorithm.queue;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
public class RightRotation {

    /**
     * https://www.hackerrank.com/challenges/circular-array-rotation?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] query = new int[q];
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            query[a0] = m;
        }

        int[] result = rightRotation(a, k);
        Arrays.stream(query).forEach(i -> System.out.println(result[i]));
    }

    public static int[] rightRotation(int[] a, int k) {
        Deque<Integer> q = new LinkedList<>();
        Arrays.stream(a).forEach(q::offerFirst);
        IntStream.range(0, k).forEach(i -> {
            int n = q.pollFirst();
            q.offerLast(n);
        });
        int[] result = new int[q.size()];
        IntStream.range(0, q.size()).forEach(i -> result[i] = q.pollLast());
        return result;
    }

    @Test
    public void test() {
        int[] input = {1,2,3};
        int[] result = rightRotation(input, 2);
        int[] answer = {2,3,1};
        assertArrayEquals(result, answer, Arrays.toString(input) +"-" + Arrays.toString(answer));
    }

    @Test
    public void test2() {
        int[] input = {1};
        int[] result = rightRotation(input, 10);
        int[] answer = {1};
        assertArrayEquals(result, answer, Arrays.toString(input) +"-" + Arrays.toString(answer));
    }

    @Test
    public void test21() {
        int[] input = {1,2,3,4,5,6,7,8,9,0};
        int[] result = rightRotation(input, 9);
        int[] answer = {2,3,4,5,6,7,8,9,0,1};
        assertArrayEquals(result, answer, Arrays.toString(input) +"-" + Arrays.toString(answer));
    }

    @Test
    public void test3() {
        int[] input = {1,2};
        int[] answerEven = {1,2};
        int[] answerOdd = {2,1};
        assertArrayEquals(rightRotation(input, 2), answerEven, Arrays.toString(input) +"-" + Arrays.toString(answerEven));
        assertArrayEquals(rightRotation(input, (int)Math.pow(10,5)), answerEven, Arrays.toString(input) +"-" + Arrays.toString(answerEven));
        assertArrayEquals(rightRotation(input, 1), answerOdd, Arrays.toString(input) +"-" + Arrays.toString(answerOdd));
    }

    @Test
    public void test4() throws IOException, URISyntaxException {
        String fileName = "RightRotationTest.txt";
        String answerFileName = "RightRotationTestAnswer.txt";

        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        List<String> lines = Files.readAllLines(path);

        String[] problem = lines.get(0).split(" ");
        System.out.println(String.format("Problem : %s elements, %s numbers, %s queries", problem));
        int rotations = Integer.parseInt(problem[1]);
        String[] inputString = lines.get(1).split(" ");
        int[] query = lines.stream().skip(2).mapToInt(Integer::parseInt).toArray();
        int[] input = Arrays.stream(inputString).mapToInt(Integer::parseInt).toArray();


        List<String> answerLines = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource(answerFileName).toURI()));
        int[] answer = answerLines.stream().mapToInt(Integer::parseInt).toArray();

        int[] result = rightRotation(input, rotations);

        IntStream.range(0, answer.length).forEach(i ->
            assertEquals(answer[i], result[query[i]], i + "th = " + answer[i])
        );


    }
}
