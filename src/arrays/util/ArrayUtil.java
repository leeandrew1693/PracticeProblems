package arrays.util;

/**
 * Created by andrew on 3/7/17.
 */
public class ArrayUtil {
    public static int getNumTimesInArray(final int[] input, final int curNum) {
        int timesSeen = 0;
        for(int num: input) {
            if(curNum == num) {
                timesSeen ++;
            }
        }

        return timesSeen;
    }
}
