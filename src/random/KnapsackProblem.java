package random;

import com.google.common.collect.Lists;
import util.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
 * weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find
 * out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapsackProblem {
   public static void main (String args[]) throws Exception {
//      int val[] = new int[]{4,1,2,3,2,2};
//      int wt[] = new int[]{5,8,4,0,5,3};
      int val[] = new int[]{60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120  };
      int wt[] = new int[]{10, 20, 30, 10, 20, 30, 10, 20, 30, 10, 20, 30, 10, 20, 30, 10, 20, 30, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120, 60, 100, 120 };
      int weight = 50;
//      int val[] = new int[]{4,2,3};
//      int wt[] = new int[]{1,2,3};
//      int weight = 7;
//      int maxItems = 5;
//      System.out.println(getMaxValueKnapsack(val, wt, weight));
//      System.out.println(getMaxValueKnapSackDp(val, wt, weight));
      Callable knapSack = () -> getMaxValueKnapsack(val, wt, weight);
      Callable knapSackDp = () -> getMaxValueKnapSackDp(val, wt, weight);
      Timer.time(knapSack);
      Timer.time(knapSackDp);
   }

   public static int maxKnapSackWithDup(int[] value, int[] weight, int maxWeight, int maxItems) {
      return helperDupes(value, weight, maxWeight, maxItems, 0);
   }

   private static int helperDupes(int[] value, int[] weight, int weightLeft, int itemsLeft, int curValue) {
      if(weightLeft < 0 || itemsLeft < 0) {
         return -1;
      }

      int curMax = curValue;

      for(int i =0; i < value.length; i++) {
         int temp = helperDupes(value, weight, weightLeft - weight[i], itemsLeft -1, curValue + value[i]);
         curMax = curMax < temp ? temp : curMax;
      }

      return curMax;
   }

   public static int getMaxValueKnapSackDp(int[] value, int[] weight, int maxWeight) {
      int[][] dp = new int[value.length+1][maxWeight+1];
      for(int y = 0; y < dp.length; y++) {
         for(int x = 0; x < dp[0].length; x++ ) {
            if (x == 0 || y == 0) {
               dp[y][x] = 0;
               continue;
            }
            if(weight[y-1] > x) {
               dp[y][x] = dp[y-1][x];
            } else {
               dp[y][x] = max(value[y-1] + dp[y-1][x-weight[y-1]], dp[y-1][x]);
            }
         }
      }
      return dp[dp.length-1][dp[0].length-1];
   }

   public static int getMaxValueKnapsack(int[] value, int[] weight, int maxWeight) {
      List<Integer> knapSack = Lists.newArrayList();
      return naiveHelper(value, weight, maxWeight, knapSack, 0);
   }
   private static int naiveHelper(int[] value, int[] weight, int maxWeight, List<Integer> knapSack, int curPos) {
      int curWeight = knapSack.stream().mapToInt(i -> weight[i]).sum();
      int maxValue = knapSack.stream().mapToInt(i -> value[i]).sum();
      if(curWeight > maxWeight) {
         return -1;
      }

      for(int i = curPos; i < value.length ; i++) {
         List<Integer> newKnapSack = new ArrayList<>(knapSack);
         newKnapSack.add(i);

         int temp = naiveHelper(value, weight, maxWeight, newKnapSack, i+1);
         maxValue = maxValue < temp ? temp : maxValue;
      }

      return maxValue;
   }

   private static int max(int a, int b) { return (a > b)? a : b; }
}
