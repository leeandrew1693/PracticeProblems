package random;

import java.util.*;

/**
 * Created by andrew on 2/18/17.
 */
public class SumOfSubsets {
    public static void main(String args[]) {
        int[] input = {1,1,2,3,4,5,6,7,8};
        int[][] matrix = sumSubsets(input, 5);
        int pos = 0;
        for(int[] arr: matrix) {
            for(int num : arr) {
                System.out.print(num + " " );
            }
            System.out.println();
        }
    }
   public static int[][] sumSubsets(int[] arr, int num) {
       if (arr.length == 0) {
           int[][] output = {{}};
           return output;
       }
        List<Integer> numList = new ArrayList<Integer>();
        for(int number: arr){
            numList.add(number);
        }
        Set<List<Integer>> listOutput = getSubsets(numList, num, new ArrayList<Integer>());

        int[][] matrix = new int[listOutput.size()][];
        int pos = 0;

        for(List<Integer> list : listOutput){
            int[] array = list.stream().mapToInt(i->i).toArray();
            matrix[pos] = array;
            pos++;
        }

        return matrix;
    }

    private static Set<List<Integer>> getSubsets(List<Integer> numbers, int targetSum, List<Integer> currentPath) {
        Set<List<Integer>> pathsEqualingSum = new LinkedHashSet<>();
        int currentSum = getSumOfList(currentPath);

        while(numbers.size() != 0){
            int num = numbers.get(0);
            numbers.remove(0);
            if(num+ currentSum == targetSum){
                List<Integer> goodPath = getNewPath(currentPath, num);
                pathsEqualingSum.add(goodPath);
            } else if (num + currentSum < targetSum) {
                List<Integer> leftoverNumbers = new ArrayList<Integer>(numbers);
                List<Integer> newPath = new ArrayList<Integer>(currentPath);
                newPath.add(num);
                pathsEqualingSum.addAll(getSubsets(leftoverNumbers, targetSum, newPath));
            } else {
                break;
            }
        }

        return pathsEqualingSum;
    }

    private static List<Integer> getNewPath(List<Integer> currentPath, int newNode){
        List<Integer> newPath = new ArrayList<>(currentPath);
        newPath.add(newNode);
        return newPath;
    }



    private static int getSumOfList(List<Integer> list) {
        int total = 0;
        for(Integer num: list){
            total += num;
        }

        return total;
    }



}
