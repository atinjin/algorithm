package com.github.atinjin.algorithm.famous;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ryanjin on 05/12/2016.
 */
public class EscapeMaze {

    public static void main(String[] args) {
        EscapeMaze maze = new EscapeMaze();
        Vertex escapePoint = new Vertex(5, 5);
        Vertex startPoint = new Vertex(1, 0);

        boolean canEscape = maze.escape(startPoint, escapePoint);

        if (!canEscape) {
            System.out.print("You can't escape this maze");
            System.out.println(" from "+startPoint+" to " +escapePoint);
        } else {
            System.out.print("You can escape this maze");
            System.out.println(" from "+startPoint+" to " +escapePoint);

            printTheWay(maze, escapePoint, startPoint);
        }
    }

    private static void printTheWay(EscapeMaze maze, Vertex escapePoint, Vertex startPoint) {
        Vertex pointer = escapePoint;
        Deque<Vertex> queue = new LinkedList<>();
        int count = 0;
        while (!pointer.equals(startPoint)) {
            queue.offerLast(pointer);
            pointer = maze.path[pointer.x][pointer.y];
            count++;
        }
        queue.offerLast(startPoint);

        while (!queue.isEmpty()) {
            Vertex v = queue.pollFirst();
            System.out.println(v.x + "," + v.y);
        }
        System.out.println("Total " + count + " steps");
    }


    int[][] maze = { //y =  0, 1, 2, 3, 4, 5
            /*x=0*/        {0, 1, 0, 1, 0, 0 },
            /*x=1*/        {1, 1, 1, 1, 1, 1 },
            /*x=2*/        {0, 0, 0, 1, 0, 1 },
            /*x=3*/        {0, 1, 1, 1, 0, 1 },
            /*x=4*/        {0, 1, 0, 0, 0, 1 },
            /*x=5*/        {1, 1, 1, 1, 1, 1 },
            /*x=6*/        {0, 1, 0, 0, 0, 0 }
    };

    int[] up = {0,-1};//up
    int[] down = {0, 1};//down
    int[] right = {1, 0};//right
    int[] left = {-1,0};//left

    Vertex[][] path = new Vertex[maze.length][maze[1].length];
    boolean[][] visited = new boolean[maze.length][maze[1].length];

    boolean escape(Vertex startPoint, Vertex escapePoint) {

        //Check the start point
        if(maze[startPoint.x][startPoint.y] == 0) {
            System.out.println("Start point is blocked.");
            return false;
        }

        //Initialization
        for(int i=0; i<maze.length; i++)
            for(int j=0; j<maze[1].length; j++) {
                path[i][j] = null;
                visited[i][j] = false;
            }

        //Find the way
        Deque<Vertex> queue = new LinkedList<>();
        path[startPoint.x][startPoint.y] = startPoint;
        queue.add(startPoint);
        while(!queue.isEmpty()) {
            Vertex v = queue.poll();
            visited[v.x][v.y] = true;
            List<Vertex> adjVertex = getAdjVertex(v);
            for(Vertex x: adjVertex)
                path[x.x][x.y] = v; //path
            if(adjVertex.contains(escapePoint))
                return true;

            queue.addAll(adjVertex);
        }
        return false;
    }

    private List<Vertex> getAdjVertex(Vertex v) {
        List<Vertex> adj = new ArrayList<>();
        Vertex left = move(v, this.left);
        Vertex right = move(v, this.right);
        Vertex up = move(v, this.up);
        Vertex down = move(v, this.down);
        if(left!=null) adj.add(left);
        if(right!=null) adj.add(right);
        if(up!=null) adj.add(up);
        if(down!=null) adj.add(down);

        return adj;
    }

    private Vertex move(Vertex v, int[] move) {
        int x = v.x +move[0];
        int y = v.y +move[1];
        if(x >= 0 && x < maze.length
                && y >= 0 && y < maze[v.x].length
                && maze[x][y] == 1
                && visited[x][y] == false) {
            return new Vertex(x, y);
        } else
            return null;
    }

    static class Vertex {
        int x;
        int y;
        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Vertex && ((Vertex)o).x == this.x && ((Vertex)o).y == this.y);
        }

        @Override
        public String toString() {
            return "("+x+","+y+")";
        }
    }

}
