package random;

import java.util.*;

/**
 * Given an array A of size N, find all combination of four elements in the array whose sum is equal to a given value
 * K. For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8”
 * (3 + 5 + 7 + 8 = 23).
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
 * Each test case contains two lines. The first line of input contains two integers N and K. Then in the
 * next line are N space separated values of the array.
 *
 * Output:
 * For each test case in a new line print all the quadruples present in the array separated by space which
 * sums up to value of K. Each quadruple is unique which are separated by a delimeter "$" and are in
 * increasing order.
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
