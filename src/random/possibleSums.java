package random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by andrew on 3/10/17.
 */
public class possibleSums {
    public static void main (String[] args) {
        int[] coins = new int[]{10,50,100};
        int[] quantity = new int[]{1,2,1};
        System.out.println(possibleSumsRecursive(coins, quantity));
        System.out.println(possibleSumsIterative(coins, quantity));
    }

    public static int possibleSumsIterative(int[] coins, int[] quantity) {
        Set<Integer> setOfNumbers = new HashSet<>();
        for(int i =0; i < coins.length; i++ ){
            Set<Integer> setOfCombinationsWithCurrent = new HashSet<>();
            for(int j = 0; j < quantity[i]; j++ ) {
                setOfCombinationsWithCurrent.add((j+1) * coins[i]);
            }

            Set<Integer> newSetOfNumbers = new HashSet<>();
            for(int newNum:setOfCombinationsWithCurrent) {
                newSetOfNumbers.add(newNum);
                for(int baseNum:setOfNumbers) {
                    newSetOfNumbers.add(baseNum + newNum);
                }
            }
            setOfNumbers.addAll(newSetOfNumbers);
        }
        return setOfNumbers.size();
    }
//
//    private static boolean checkIfPossible(int[] coins, int[] quantity, int value) {
//
//    }

    public static int possibleSumsRecursive(int[] coins, int[] quantity) {
        return possibleSumsRecursionHelper(coins, quantity, new HashSet<Integer>(), 0);
    }

    private static int possibleSumsRecursionHelper(int[] coins, int[]quantity, Set<Integer> sums, int curSum) {
        int numLeft = 0;
        for(int i = 0; i < coins.length; i++) {
            numLeft += quantity[i];
        }

        if(numLeft ==0) {
            return 0;
        }

        int numSums = 0;
        for(int i = 0; i < coins.length; i++) {
            if(quantity[i] <=0 ) {
                continue;
            }
            int[] newQuant = quantity.clone();
            newQuant[i] = newQuant[i] - 1;
            int newSum = curSum + coins[i];
            if(!sums.contains(curSum)) {
                numSums++;
                sums.add(curSum);
            }

            numSums += possibleSumsRecursionHelper(coins, newQuant, sums, newSum);
        }

        return numSums;
    }

}
