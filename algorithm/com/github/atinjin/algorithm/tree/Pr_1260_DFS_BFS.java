package com.github.atinjin.algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.*;

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
public class Pr_1260_DFS_BFS {
    /**
     * 문제 : Print DFS, BFS path
     * 조건 1 <= Vertex <= 1,000
     *     1 <= Eadg <= 10,000
     * 입력 : n(v) n(e) start_node
     *       start end
     *       ...
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int vertexes = in.nextInt();
        int edges = in.nextInt();
        int startNode = in.nextInt();

        // node 번호를 1번부터 하기 위해 +1을 한 Array를 정의하였다
        List<Integer>[] link = new ArrayList[vertexes+1];

        // edge를 입력받아, 양방향 edge를 표현할 리스트 만들기
        for(int i=0; i<edges; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            linkBidirection(link, start, end);
        }
        // 문제의 정의상 번호가 적은 순으로 방문하기 위해서 정렬한다
        Arrays.stream(link).filter(Objects::nonNull).forEach(Collections::sort);

        dfs(startNode, link, new boolean[vertexes+1]);
        System.out.println("");
        bfs(1, link, new boolean[vertexes+1]);
    }

    /**
     * DFS(Depth First Search) 그래프의 시작점에서 최대한 먼 Node부터 검색한다.
     *   - Stack을 이용하여 While문을 이용한 구현 방식
     *   - Recursive call을 이용하여 call stack을 이용한 구현 방식
     * @param startNode 시작 node
     * @param link Edge List를 저장하고 있는 Array
     * @param isVisited 각 노드별 방문 여부를 저장한 Array
     */
    public static void dfs(int startNode, List<Integer>[] link, boolean[] isVisited) {
        List<Integer> edges = link[startNode];
        if(edges != null) {
            // 방문한 node는 방문했다고(true) 표시하고 출력
            isVisited[startNode] = true;
            System.out.print(startNode + " ");

            // edge로 연결되어 있는 node를 찾아서 방문했는지 확인하고 dfs를 recursive call
            // edges는 이미 오름차순(natual) 정렬이 되어 있기 때문에 iterator로 바로 사용할 수 있다.
            for (int next : edges) {
                if (!isVisited[next]) {
                    dfs(next, link, isVisited);
                }
            }
        }
    }

    /**
     * BFS(Breadth First Search) 그래프의 시작점에서 가까운 Node부터 검색한다.
     *   -  Queue를 사용하여 방문할 Node를 저장하고 찾아진 모든 노드를 방문할 때까지(Queue is empty) 반복한다.
     *   - (중요) Queue에 Node를 넣을 때 방문 표시를 해야한다. 중복으로 Queue에 넣는 것을 방지하기 위해서이다.
     * @param startNode 시작 node
     * @param link Edge List를 저장하고 있는 Array
     * @param isVisited 각 노드별 방문 여부를 저장한 Array
     */
    public static void bfs(int startNode, List<Integer>[] link, boolean[] isVisited) {
        // 방문할 Node를 쌓아둘 Queue
        Queue<Integer> q = new LinkedList<>();
        // 시작 Node를 넣는다. 방문 표시를 먼저 한다.
        q.add(startNode);
        isVisited[startNode] = true;
        // Queue가 빈다는 것은 더이상 방문할 Node가 없다는 것이다.
        while(!q.isEmpty()) {
            int node = q.poll();
            if(link[node] == null) continue;

            System.out.print(node + " ");

            for(int next: link[node]) {
                if(!isVisited[next]) {
                    // Queue에 넣기 전에 방문 표시를 한다.
                    // 그렇지 않으면 Edge가 여러개일 경우 같은 노드를 여러번 Queue에 넣는 경우가 생긴다.
                    isVisited[next] = true;
                    q.offer(next);
                }
            }
        }

    }

    /**
     * 양방향 edge를 생성해준다 start -> end, end -> start
     * @param link Edge 리스트를 가진 Array
     * @param start edge의 시작 node
     * @param end edge의 끝 node
     */
    public static void linkBidirection(List<Integer>[] link, int start, int end) {
        List<Integer> l = link[start];
        if( l == null) {
            l = new ArrayList<>();
            link[start] = l;
        }
        l.add(end);

        l= link[end];
        if( l == null) {
            l = new ArrayList<>();
            link[end] = l;
        }
        l.add(start);
    }

    @Test
    public void dfsTest() {
        int vertexes = 4;
        // node 번호를 1번부터 하기 위해 +1을 한 Array를 정의하였다
        List<Integer>[] link = new ArrayList[vertexes+1];
        // 양방향 edge를 표현할 리스트 만들기
        linkBidirection(link, 1,2);
        linkBidirection(link, 1,3);
        linkBidirection(link, 1,4);
        linkBidirection(link, 2,4);
        linkBidirection(link, 3,4);

        // 문제의 정의상 번호가 적은 순으로 방문하기 위해서 정렬한다
        Arrays.stream(link).filter(Objects::nonNull).forEach(Collections::sort);

        dfs(1, link, new boolean[vertexes+1]);
        System.out.println("");
        bfs(1, link, new boolean[vertexes+1]);
    }
}
