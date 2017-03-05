package random;

import java.util.*;

/**
 * Created by andrew on 3/4/17.
 */
public class SumOfNumbers {
    public static void main (String args[]) {
        System.out.println(getAllNumberSum(new int[]{1,2,3,1,4,1,5,1,2,3,4,1,5,1,4}, 9, 3));

    }

    public static List<List<Integer>> getAllNumberSum(int[] array, int sum, int n) {
        List<List<Integer>> results = new ArrayList<>();
        int num = helper(results, array, new ArrayList<>(), sum, 0, n);
        System.out.println(num);
        return results;
    }

    private static int helper(List<List<Integer>> results, int[] inputArray, List<Integer> testArray, int sum, int index, int n) {
        if(testArray.size() == n) {
            if (isEqualSum(testArray, sum)) {
                results.add(new ArrayList<>(testArray));
                return 1;
            } else {
                return 0;
            }
        }

        int num = 0;
        for(int i = index; i < inputArray.length; i++ ) {
            testArray.add(inputArray[i]);
            num += helper(results, inputArray, testArray, sum, i+1, n);
            testArray.remove(testArray.size()-1);
        }
        return num;
    }

    public static boolean isEqualSum(List<Integer> input, int sum) {
        return sum == input.stream().mapToInt(i -> i.intValue()).sum();
    }
}
