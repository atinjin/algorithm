package algorithm.graph;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
public class Pr_11724_ConnectComp {

    /**
     * INPUT : N(nodes) M(edges)
     *         n1 n2
     *         n3 n6
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<String> lines = new ArrayList<>();
        lines.add(String.format("%s %s", n, m));
        for(int i=0; i<m; i++) {
            lines.add(String.format("%s %s", in.nextInt(), in.nextInt()));
        }
        lines.add("0");
        List<Integer>[] edges = getEdges(lines, n);

        System.out.println(findConnectecComponent(n, edges));
    }

    private static int findConnectecComponent(int n, List<Integer>[] edges) {
        /**
         * 각 노드에 대해서 DFS를 하면서 확인했던 노드가 다시 나오는 순간이 Connected Component를 찾은 것이다
         * 그 다음은 확인하지 않는 노드를 다시 찾아서 위의 과정을 반복하는 것이다
         * 모든 노드를 확인했다면 알고리즘은 끝난다.
         */
        boolean[] isVisited = new boolean[n+1]; //n=1부터 시작한다
        int components = 0;
        for(int i=1; i<=n; i++) { //n=1부터 시작한다
            if(!isVisited[i]) {
                dfs(i, edges, isVisited);
                components++;
            }
        }

        return components;
    }

    private static void dfs(int n, List<Integer>[] edges, boolean[] isVisited) {
        if(isVisited[n] || edges[n] == null)
            return;

        for(int next :edges[n]) {
            isVisited[n] = true;
            dfs(next, edges, isVisited);
        }
    }

    @Test
    void test() throws URISyntaxException, IOException {
        String fileName = "ConnectComp.txt";
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        List<String> lines = Files.readAllLines(path);

        String[] firstLine = lines.get(0).split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<Integer>[] edges = getEdges(lines, n);

        int answer = Integer.parseInt(lines.get(m+1));
        assertEquals(answer, findConnectecComponent(n, edges), "ConnectComp.txt");
    }

    private static List<Integer>[] getEdges(List<String> lines, int n) {
        List<Integer>[] edges = new List[n+1];
        for(int i=1; i<lines.size()-1; i++) {
            String[] input = lines.get(i).split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            if(edges[from] == null) {
                edges[from] = new ArrayList<>();
            }
            edges[from].add(to);
            if(edges[to] == null) {
                edges[to] = new ArrayList<>();
            }
            edges[to].add(from);

        }

        return edges;
    }
}
