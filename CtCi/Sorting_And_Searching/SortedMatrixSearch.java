package CtCi.Sorting_And_Searching;

public class SortedMatrixSearch {
    public static boolean find(int[][] grid, int elem){
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        int rows = grid.length;
        int cols = grid[0].length;

        // Start at top right corner
        int row = 0;
        int col = cols - 1;

        while(row < rows && col >= 0){
            if (grid[row][col] == elem) {
                return true;
            } else if (grid[row][col] > elem) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] sortedMatrix = {{ 1,  6,  8,  9 },
        { 3,  8,  9, 11 },
        { 6,  9, 11, 15 },
        { 7, 14, 17, 22 }};

        System.out.println(find(sortedMatrix, 6));
        System.out.println(find(sortedMatrix, 64));
    }
}
