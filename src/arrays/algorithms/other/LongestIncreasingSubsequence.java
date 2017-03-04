package arrays.algorithms.other;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import util.Timer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by andrew on 2/26/17.
 */
public class LongestIncreasingSubsequence {
    public static void main(String args[]) throws Exception {
//        final int[] array = {100,-2,3,-4,5,-6,7,-8,-9,-10};
        final int[] array = {16,15,14,13, 12, 11, 12, 13, 14, 100,-2,3,-4,5,-6,7,-8,-9,-10, 14, 8, 9 ,10};
        Callable callable = () -> longestIncreasingSubsquence(array);
        Timer.time(callable);
        final List<Integer> longestIncreasingSubsequence = longestIncreasingSubsquence(array);
        for(int i : longestIncreasingSubsequence) {
            System.out.print(i + ", ");
        }
    }

    public static List<Integer> longestIncreasingSubsquence(final int[] array) {
        int min = Integer.MAX_VALUE;
        List<List<Integer>> longestIncreasing = new ArrayList<>();
        for(int num : array) {
            for(List<Integer> list : longestIncreasing) {
                if(num > list.get(list.size()-1)) {
                    list.add(num);
                }
            }
            if(num < min) {
                longestIncreasing.add(Lists.newArrayList(num));
                min = num;
            }
        }
        List<Integer> longestList = new ArrayList<>();
        for(List<Integer> list : longestIncreasing) {
            if(list.size() > longestList.size()) {
                longestList = list;
            }
        }

        return longestList;
    }

//    public static List<List<Integer>> cleanLists(final List<List<Integer>> lists) {
//
//    }
}
