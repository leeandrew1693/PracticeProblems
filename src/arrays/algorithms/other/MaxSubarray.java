package arrays.algorithms.other;

import java.util.Arrays;

/**
 * Created by andrew on 2/26/17.
 */
public class MaxSubarray {
    public static void main(String args[]) {
        final int[] array = {100,-2,3,-4,5,-6,7,-8,-9,-10};
        System.out.println(getSumOfMaxSubArray(array));
        final int[] maxSubarray = getMaxSubarray(array);
        for(int i : maxSubarray) {
            System.out.print(i + ", ");
        }
    }

    static class MaxArray {
        int value;
        int start;
        int end;


    }

    public static int getSumOfMaxSubArray(int[] array) {
        int max = 0;
        int valueToHere = 0;
        for(int num : array) {
            final int curTotal = valueToHere + num;

            valueToHere = Math.max(curTotal, 0);

            max = Math.max(max, valueToHere);
        }
        return max;
    }

    public static int[] getMaxSubarray(int[] array) {
        MaxArray maxArray = new MaxArray();
        MaxArray curValueToHere = new MaxArray();
        for(int i = 0 ; i < array.length; i++ ) {
            final int curTotal = curValueToHere.value + array[i];

            if(curTotal > 0) {
                if(curValueToHere.start == -1) {
                    curValueToHere.start = i;
                }
                curValueToHere.end= i;
                curValueToHere.value = curTotal;
            } else {
                curValueToHere.value =0;
                curValueToHere.start = -1;
                curValueToHere.end = -1;
            }

            if(curValueToHere.value > maxArray.value ) {
                maxArray.start = curValueToHere.start;
                maxArray.end= curValueToHere.end;
                maxArray.value= curValueToHere.value;
            }
        }
        if(maxArray.start == -1) {
            return new int[0];
        } else {
            return Arrays.copyOfRange(array, maxArray.start, maxArray.end+1);
        }
    }
}
