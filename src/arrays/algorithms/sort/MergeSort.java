package arrays.algorithms.sort;

/**
 * Created by andrew on 2/9/17.
 */
public class MergeSort {
    public static void main(final String args[]) {
        final int[] array = {5,1,8,2};
        sort(array);
        for(int i : array) {
            System.out.print(i);
        }
    }
    private static int[] numbers;
    private static int[] helper;

    private static int number;

    public static void sort(int[] values) {
        numbers = values;
        number = values.length;
        helper = new int[number];
        mergesort(0, number - 1);
    }

    private static void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int leftArrayPointer = low;
        int rightArrayPointer = middle + 1;
        int mainArrayPointer = low;

        while(leftArrayPointer <= middle && rightArrayPointer <= high) {
            if(helper[leftArrayPointer] <= helper[rightArrayPointer]) {
                numbers[mainArrayPointer++] = helper[leftArrayPointer++];
            } else {
                numbers[mainArrayPointer++] = helper[rightArrayPointer++];
            }
        }


        while(leftArrayPointer<= middle) {
            numbers[mainArrayPointer++] = helper[leftArrayPointer++];
        }




//        // Copy the smallest values from either the left or the right side back
//        // to the original array
//        while (leftArrayPointer <= middle && rightArrayPointer <= high) {
//            if (helper[leftArrayPointer] <= helper[rightArrayPointer]) {
//                numbers[mainArrayPointer] = helper[leftArrayPointer];
//                leftArrayPointer++;
//            } else {
//                numbers[mainArrayPointer] = helper[rightArrayPointer];
//                rightArrayPointer++;
//            }
//            mainArrayPointer++;
//        }
//        // Copy the rest of the left side of the array into the target array
//        while (leftArrayPointer <= middle) {
//            numbers[mainArrayPointer] = helper[leftArrayPointer];
//            mainArrayPointer++;
//            leftArrayPointer++;
//        }


        for(int i: numbers) {
            System.out.print(i);
        }
        System.out.println();
    }

}
