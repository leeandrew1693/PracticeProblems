package random;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 * in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
 * weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find
 * out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapsackProblem {
   public static void main (String args[]) {
//      int val[] = new int[]{4,1,2,3,2,2};
//      int wt[] = new int[]{5,8,4,0,5,3};
      int val[] = new int[]{60, 100, 120};
      int wt[] = new int[]{10, 20, 30};
      int weight = 50;
      System.out.println(getMaxValueKnapsack(val, wt, weight));
      System.out.println(maxKnapSack(weight, wt, val, val.length));
      System.out.println(maxKnap(weight, val, wt, 0));
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

   private static int maxKnap(int curWeight, int[] val, int[] weight, int pos) {
      if(pos > val.length -1) {
         return 0;
      }

      int temp = 0;
      if(curWeight - weight[pos] >= 0) {
         temp = val[pos] + maxKnap(curWeight - weight[pos], val, weight, pos+1);
      }

      return max(temp, maxKnap(curWeight, val, weight, pos+1));
   }
















   // Returns the maximum value that can be put in a knapsack of capacity W
   private static int maxKnapSack(int W, int wt[], int val[], int n) {
      if (n == 0 || W == 0)
         return 0;

      if (wt[n-1] > W)
         return maxKnapSack(W, wt, val, n-1);

         // Return the maximum of two cases:
         // (1) nth item included
         // (2) not included
      else return max( val[n-1] + maxKnapSack(W-wt[n-1], wt, val, n-1),
              maxKnapSack(W, wt, val, n-1)
      );
   }

}
