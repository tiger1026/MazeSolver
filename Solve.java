package com.company;


import java.util.List;
public class Solve {

    public static boolean findPath(int[][] maze, int x, int y, List<Integer> path ) {
        if (maze[y][x] == 4) { // if reached end point denoted by int 4, then we return true,
            path.add(x);       // if false,
            path.add(y);
            return true;
        }

        if (maze[y][x] == 0) {
            maze[y][x] = 2;

            int dx = -1; //see if there's a path to the left
            int dy = 0;

            if (findPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;   //the right
            dy = 0;

            if (findPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0; //top
            dy = -1;

            if (findPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0; //down
            dy = 1;

            if (findPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }

        }
        return false;
    }
}
