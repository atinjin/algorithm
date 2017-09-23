package com.github.atinjin.algorithm.tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
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
public class Pr_2178_MazeEscape {
    /**
     * 4 6
     * 101111
     * 101010
     * 101011
     * 111011
     *
     * (1,1) -> (N, M), (2≤ N,M ≤100)
     */
    public void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sx = in.nextInt();
        int sy = in.nextInt();
        int[][] maze = new int[101][101];

        //maze 정보 채우기
        for(int x=1; x<=sx; x++) {
            String line = in.nextLine();
            for (int y = 1; y <= line.length(); y++) {
                maze[x][y] = line.charAt(y-1);
            }
        }

        System.out.println(findPath(maze, sx, sy));
    }

    private static int findPath(int[][] maze, int ex, int ey) {
        // 최단거리를 찾는 문제이기 때문에 BFS를 사용하는 것
        // 시작점은 (1,1) ----> 끝나는 점은(ex, ey)
        // Move dx = {0, 1, -1, -1}
        // Move yx = {1, 0, -1,  0}

        int[] dx = {0, 1, -1, -1};
        int[] dy = {1, 0, -1, 0};
        Queue<Point> q = new LinkedList<>();
        int[][] distance = new int[ex+1][ey+1];
        boolean[][] isVisited = new boolean[ex+1][ey+1];

        q.offer(new Point(1,1));
        isVisited[1][1] = true;
        distance[1][1] = 1;
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i=0; i<4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if( (nextX > 0 && nextX <= ex && nextY > 0 && nextY <=ey) && !isVisited[nextX][nextY]
                        && maze[nextX][nextY] == 1) {
                    q.offer(new Point(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                    distance[nextX][nextY] = distance[p.x][p.y] + 1;
                }
            }
        }

        return distance[ex][ey];
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void test() {
        /**
         * 101111
         101010
         101011
         111011
         */
        int[][] maze = {
                {1,0,1,1,1,1},
                {1,0,1,0,1,0},
                {1,0,1,0,1,1},
                {1,1,1,0,1,1}
        };

        assertEquals(15, findPath(maze, 4, 6), "4,6");
    }
}
