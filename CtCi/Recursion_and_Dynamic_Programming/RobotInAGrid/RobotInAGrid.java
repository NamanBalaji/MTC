package CtCi.Recursion_and_Dynamic_Programming.RobotInAGrid;

import java.util.*;

public class RobotInAGrid {
    
    public static ArrayList<Point> getPath(boolean[][] maze) {
        if(maze == null || maze.length == 0) return  null;
        int lastRow = maze.length-1;
        int lastCol = maze[0].length-1;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> cache = new HashSet<Point>();

        if (getPath(maze, lastRow, lastCol, path, cache)){
            return path;
        }
        return null;
    }

    public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if (col < 0 ||  row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);
        if(failedPoints.contains(p)){
            return false;
        }
        boolean isAtOrigin = (row==0)&&(col==0);
        if (isAtOrigin || getPath(maze, row, col-1, path, failedPoints) || getPath(maze, row-1, col, path, failedPoints)){
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;
    }

    private static boolean[][] createMaze(int rows, int cols) {
        boolean[][] maze = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                maze[row][col] = true;
            }
        }
        return maze;
    }

    public static void main(String[] args) {
        boolean[][] maze = createMaze(3, 3);
        maze[1][1] = false;
        maze[2][1] = false;
        ArrayList<Point> path = getPath(maze);
        System.out.print("\n Path: " + path);
    }
}

