package CtCi.Recursion_and_Dynamic_Programming;

public class EightQueens {
    static int count = 0;
    public static void nQueens(int n){
        int[][] chess = new int[n][n];
        nQueens(chess, "", 0);
    }

    public static void nQueens(int[][] chess, String positions, int row){
        if(row == chess.length) {
            System.out.println(positions);
            count++;
            return;
        }
        for(int col = 0; col<chess.length; col++){
            if(isSafe(chess, row, col)){
                chess[row][col] = 1;
                nQueens(chess, positions + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isSafe(int[][] chess, int row, int col) {
        // check row
        for(int i = row-1, j = col; i >= 0; i--) {
            if(chess[i][j] == 1) return false;
        }

        // check diagonal left
        for(int i = row -1, j= col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 1) return false;
        }

        // check diagonal right
        for(int i = row -1, j= col+1; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        nQueens(8);
        System.out.println("Total possible solutions " + count);
    }
}
