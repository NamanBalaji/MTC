package CtCi.Sorting_And_Searching;

public class SortedSearchNoSize {
    public static int search(Listy list, int value){
        int index = 1;
        while(list.elementAt(index) != -1 && list.elementAt(index) < value){
            index *= 2;
        }

        return binarySearch(list, value, index / 2, index);
    }

    private static int binarySearch(Listy listy, int value, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = listy.elementAt(mid);
            if (midValue == -1 || midValue > value) {
                end = mid - 1;
            } else if (midValue < value) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array =  { 1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18 };
        Listy list = new Listy(array);
        for (int num : array) {
            System.out.format("%2d is at index %2d\n", num, search(list, num));
        }
        System.out.println(search(list, 91291873)); // Should print -1 if not in array
        System.out.println(search(list, 9) + "\n");
    }
}

class Listy {
    private int[] array;

    Listy(int[] array){
        this.array = array;
    }

    int elementAt(int index){
        if (index >= array.length) {
            return -1;
        }
        return array[index];
    }
}