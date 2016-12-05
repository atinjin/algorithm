package com.github.atinjin.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ryanjin on 05/12/2016.
 */
public class ShortestPathDijkstra {
    public static void main(String[] arg) {

        ShortestPathDijkstra dijkstra = new ShortestPathDijkstra();
        dijkstra.dijkstra(0);

        for(int i=0; i<dijkstra.distance.length; i++) {
            System.out.print(dijkstra.vertexName[i] + " ");
            System.out.print(dijkstra.distance[i] + " ");
            System.out.print(dijkstra.vertexName[dijkstra.path[i]] + " ");
            System.out.println("");
        }
    }

    char[] vertexName = {'A', 'B', 'C', 'D', 'E', '-'};

    int[][] weight = {
            //       A     B     C      D      E
           /*A*/     {-1,   4,   1,  -1,  -1},
           /*B*/     {-1,   -1,  -1, -1,  4},
           /*C*/     {-1,   2,   -1, 4,   -1},
           /*D*/     {-1,   -1,  -1, -1,  4},
           /*E*/     {-1,   -1,  -1, -1,  -1}
    };

    int[] distance = new int[weight.length];
    int[] path = new int[weight.length];

    void dijkstra(int start) {
//        Comparator<Vertex> comparator = new Comparator<Vertex>() {
//            @Override
//            public int compare(Vertex v1, Vertex v2) {
//                return v1.weight - v2.weight;
//            }
//        };
//        Comparator<Vertex> comparator = (v1, v2) -> v1.weight - v2.weight;
        Comparator<Vertex> comparator = Comparator.comparingInt(v1 -> v1.weight);
        PriorityQueue<Vertex> pq = new PriorityQueue<>(10, comparator);

        for(int i=0; i< distance.length; i++) {
            distance[i] = -1;
            path[i] = 5;
        }

        distance[start] = 0;
        pq.add(new Vertex(start, 0));

        while(!pq.isEmpty()) {
            Vertex v = pq.poll();
            for(int w=0;w < this.weight.length; w++) {
                if(weight[v.vertex][w] <= 0) continue;  //가중치가 -1인 경우 edge가 없다
                int curDistance = distance[v.vertex];   //현재 v까지의 최단 거리이다.
                int dis = curDistance + weight[v.vertex][w];    // 새로 계산한 adjacent "w"까지의 거리이다
                if(distance[w] < 0) {   //distance[w]가 초기값(-1)인 경우 현재 계산된 dis 값을 최소값이라고 할 수 있다
                    distance[w] = dis;
                    pq.add(new Vertex(w, dis)); //adjacent "w"를 큐에 넣어서 다음번 계산에서 쓴다
                    path[w] = v.vertex; //w로 가기 전에 'v'를 거쳐갔다는 것을 표시한다
                }
                if(distance[w] > dis) { //기존에 계산한 최소값보다 현재 계산한 값이 더 작다면 최소값을 변경한다
                    distance[w] = dis;
                    pq.remove(new Vertex(w));   //큐에 들어있는 "w"의 최소 거리값을 변경한다
                    pq.add(new Vertex(w, dis));
                    path[w] = v.vertex;
                }
            }
        }
    }

    static class Vertex {
        int vertex;
        int weight;

        Vertex(int vertext, int weight) {
            this.vertex = vertext;
            this.weight = weight;
        }

        public Vertex(int i) {
            this.vertex = i;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Vertex) {
                if(((Vertex) o).vertex == this.vertex)
                    return true;
            }
            return false;
        }
    }
}
