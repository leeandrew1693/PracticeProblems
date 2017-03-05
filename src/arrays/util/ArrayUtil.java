package arrays.util;

/**
 * Created by andrew on 3/4/17.
 */
public class ArrayUtil {
    public static char[][] clone2dArray(char[][] toClone) {
        char[][] clone = new char[toClone.length][toClone[0].length];
        for(int i =0; i < toClone[0].length ; i++) {
            for(int j =0; j < toClone.length ; j++) {
                clone[j][i] = toClone[j][i];
            }
        }

        return clone;
    }
    public static boolean[][] clone2dArray(boolean[][] toClone) {
        boolean[][] clone = new boolean[toClone.length][toClone[0].length];
        for(int i =0; i < toClone[0].length ; i++) {
            for(int j =0; j < toClone.length ; j++) {
                clone[j][i] = toClone[j][i];
            }
        }

        return clone;
    }

    public static void print2dArray(char[][] array) {
        for(int y = 0; y < array.length; y++ ){
            for(int x = 0; x < array[0].length; x++ ) {
                System.out.print(array[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
