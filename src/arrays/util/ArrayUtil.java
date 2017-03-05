package arrays.util;

/**
 * Created by andrew on 3/4/17.
 */
public class ArrayUtil {
    public static boolean[][] clone2dArray(boolean[][] toClone) {
        boolean[][] clone = new boolean[toClone[0].length][toClone.length];
        for(int i =0; i < toClone[0].length ; i++) {
            for(int j =0; j < toClone.length ; j++) {
                clone[i][j] = toClone[i][j];
            }
        }

        return clone;
    }
}
