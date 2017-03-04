package arrays.algorithms.other;

/**
 * Created by andrew on 2/27/17.
 */
public class SubsetSum {
    public static boolean divisbleTwoSubsetSum(int[] arr) {
        int target = 0;
        for(int i =0; i < arr.length; i++) {
            target += arr[i];
        }

        if(target %2 == 1) {
            return false;
        }

        return getSubsetSum(arr, arr.length, target/2);
    }

    public static boolean getSubsetSum(int[] arr, int sum) {
        return getSubsetSum(arr, arr.length, sum);
    }

    private static boolean getSubsetSum(int[] arr, int n, int sum) {
        boolean[][] matrix = new boolean[n][sum+1];
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }

        for(int i = 1; i < n; i ++) {
            for(int j = 0; j < sum+1; j++) {
                int arrValue = arr[i];
                boolean value;
                if(i > 0 && matrix[i-1][j]){
                    value = true;
                } else {
                    value = j - arrValue < 0 ? false : matrix[i][j-arrValue];
                }
                matrix[i][j] = value;
            }
        }

        return matrix[n-1][sum];
    }

}
