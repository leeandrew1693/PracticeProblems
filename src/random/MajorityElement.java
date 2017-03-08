package random;

import arrays.util.ArrayUtil;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrew on 3/7/17.
 */
public class MajorityElement {
    public static void main(String args[]){
//        int[] input = new int[] {1,1,1,4,1,3,2,4,5,55,3,5,4,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,4,5,2,3,4,4,4,2,2,24,3,1,4,1,3,23,3,5,5,1,3,1,2,5,9,5,9,5,5,5};
//        int[] input = new int[] {1,2,3,4,5,5,5,5,5};
        int[] input = new int[] {5,1,5,1,5,1,5,1,5,1,5,1,5};
        System.out.println(majorityElementMemoryHeavy(input));
        System.out.println(majorityElement(input));
    }

    public static int majorityElementMemoryHeavy(final int[] input) {
        final Map<Integer, Integer> map = new HashMap<>();
        for(int num: input) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) +1);
            } else {
                map.put(num, 1);
            }
        }
        int mostCommon = map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
        if(map.get(mostCommon) < input.length/2 + 1) {
            return -1;
        } else {
            return mostCommon;
        }
    }

    public static int majorityElement(final int[] input) {
        final int potentialMajority = getPotentialMajorityElement(input);
        final int timesSeen = ArrayUtil.getNumTimesInArray(input, potentialMajority);

        return timesSeen < (input.length/2 +1) ? -1 : potentialMajority;
    }

    private static int getPotentialMajorityElement(final int[] input) {
        int curNum = input[0];
        int curTimes = 1;
        for(int num: input) {
            if(num == curNum) {
                curTimes++;
            } else {
                curNum = curNum != num && curTimes == 1 ? num : curNum;
                curTimes --;
                curTimes = curTimes <= 0 ? 1 : curTimes;
            }
        }
        return curNum;
    }
}
