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
public class Pr_1704_BipartitieGraph {
    /**
     * 이분 그래프인지 판별하기
     *
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        int tc = in.nextInt();
        lines.add(String.valueOf(tc));
        for(int i=0; i<tc; i++) {
            int v = in.nextInt();
            int e = in.nextInt();
            lines.add(String.format("$s $s", v, e));
            for(int j=0; j<e; j++) {
                lines.add(in.next());
            }
        }
        List<List<Integer>[]> inputs = getGraph(lines);
    }

    public static List<List<Integer>[]> getGraph(List<String> lines) {
        //first line : number of test cases
        int prNum = Integer.parseInt(lines.get(0));

        // Test cases
        //next line : V(1<=V<=20,000) E(1<=E<=200,000)
        //rest : from to
        List<List<Integer>[]> inputs = new ArrayList<>();
        int line = 1;
        for(int pr=0; pr<prNum; pr++) {
            String[] ve = lines.get(line++).split(" ");
            int v = Integer.parseInt(ve[0]);
            int e = Integer.parseInt(ve[1]);
            List<Integer>[] edges = new List[v+1];
            inputs.add(edges);
            for(int i=0; i<e; i++) {
                String[] edge = lines.get(line++).split(" ");
                int from = Integer.parseInt(edge[0]);
                int to = Integer.parseInt(edge[1]);
                if(edges[from] == null) {
                    edges[from] = new ArrayList<>();
                }
                edges[from].add(to);
                if(edges[to] == null) {
                    edges[to] = new ArrayList<>();
                }
                edges[to].add(from);
            }
        }
        return inputs;
    }

    @Test
    public void test() throws URISyntaxException, IOException {
        String fileName = "Pr_1704_BipartitieGraph.txt";
        Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        List<String> lines = Files.readAllLines(path);

        List<List<Integer>[]> inputs = getGraph(lines);

    }
}
