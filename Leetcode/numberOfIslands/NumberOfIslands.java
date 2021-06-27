package Leetcode.numberOfIslands;

import java.util.Scanner;

public class NumberOfIslands {
    public static int numIsland(char[][] matrix){
        int count = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='1'){
                    helper(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void helper(char[][] matrix, int i, int j){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length){
            return;
        }
        if(matrix[i][j]=='2' || matrix[i][j]=='0'){
            return;
        }
        matrix[i][j] = '2';
        helper(matrix,i-1,j);   
        helper(matrix,i+1,j); 
        helper(matrix,i,j-1); 
        helper(matrix,i,j+1);
        
        return;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        char[][] map = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = scan.next().charAt(0);
            }
        } 
        int ans = numIsland(map);
        System.out.println(ans);
    }
}
