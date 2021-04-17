package CtCi.Arrays_and_Strings;

public class ZeroMatrix {
    public static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}		
	}

	public static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}		
	}			
	
	public static void setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];	
		boolean[] column = new boolean[matrix[0].length];

		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = true; 
					column[j] = true;
		 		}
			}
		}
		
		// Nullify rows
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				nullifyRow(matrix, i);
			}
		}
		
		// Nullify columns
		for (int j = 0; j < column.length; j++) {
			if (column[j]) {
				nullifyColumn(matrix, j);
			}
		}
	}	

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3}, 
            {4, 0, 6},
            {7, 8, 9}
        };
        setZeros(arr);

        for(int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
