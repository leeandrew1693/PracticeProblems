package arrays.algorithms.search;

/**
 * Created by andrew on 2/11/17.
 */
public class BinarySearch {
    public static void main(String args[]) {
        final int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(array, 19));
    }



    public static int binarySearch(final int[] sortedArray, final int number){
        return binarySearchRecursive(sortedArray, number, 0, sortedArray.length-1);
    }

    private static int binarySearchRecursive(final int[] sortedArray, final int number, final int start, final int end) {
        final int middle = (start+end)/2;

        if(start > end ) {
            return -1; // Number don't exist yo
        }

        if(number < sortedArray[middle]) {
            return binarySearchRecursive(sortedArray, number, start, middle-1);
        } else if (number > sortedArray[middle]) {
            return binarySearchRecursive(sortedArray, number, middle+1, end);
        } else if (number == sortedArray[middle]) {
            return number;
        }
        return -1;
    }
}
