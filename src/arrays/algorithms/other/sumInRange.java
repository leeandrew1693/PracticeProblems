package arrays.algorithms.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrew on 2/27/17.
 */
public class sumInRange {

    int sumInRange(int[] nums, int[][] queries) {
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
    int[] results = new int[queries.length];
    for(int i = 0; i < queries.length; i++ ){
        int startPos = queries[i][0];
        int endPos = queries[i][0];
        if(dp.containsKey(startPos) && dp.get(startPos).containsKey(endPos)) {
            results[i] = dp.get(startPos).get(endPos);
            continue;
        }
        for(int j = startPos; j <= endPos; j++) {
            if(j == startPos) {
                if(!dp.containsKey(new Integer(startPos))) {
                    dp.put(new Integer(startPos), new HashMap<Integer, Integer>());
                }
                dp.get(new Integer(startPos)).put(new Integer(j),new Integer(nums[j]));
                continue;
            }

            if(!dp.get(new Integer(startPos)).containsKey(new Integer(j))){

                dp.get(new Integer(startPos)).put(new Integer(j), new Integer(dp.get(new Integer(startPos)).get(new Integer(j-1)) + nums[j]));
            }

            if(j == endPos) {
                results[i] = dp.get(new Integer(startPos)).get(new Integer(endPos));
                break;
            }
        }
    }
    int sum = 0;
    for(int result : results) {
        sum += result;
    }

    return sum;
}

}
