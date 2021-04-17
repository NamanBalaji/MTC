package CtCi.Arrays_and_Strings;

public class RotateArray {
    
    public static void rotateArray(int[][] arr){
        if (arr[0].length != arr.length){
            return;
        }

        //Calculate transpose
        for (int i=0 ; i< arr.length; i++){
            for (int j=0; j< arr.length; j++){
                int temp = arr[i][j];
                arr[j][i] = arr[i][j];
                arr[j][i] = temp;
            }
        }

        //reverse the rows
        for(int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length/2; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-1-j];
                arr[i][arr.length-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3}, 
            {4, 5, 6},
            {7, 8, 9}
        };
        rotateArray(arr);

        for(int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
