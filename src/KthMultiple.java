/**
 * Created by andrew on 2/12/17.
 */
public class KthMultiple {
    public static void main(String args[]) {
        long[] array = {13};
        System.out.println(getKthNumber(50, array));
    }

    public static long getKthNumber(final long n, final long[] primeFactors) {
        long numFound = 0;
        for(long i =1; i< Long.MAX_VALUE; i++ ){
            if(isPrimeFactors(i, primeFactors)) {
                numFound ++;
            }
            if(numFound == n) {
                return i;
            }
        }
        return -1;
    }


    private static boolean isPrimeFactors(long n, long[] primeFactors) {
        while(true) {
            boolean flag = false;
            for(long number : primeFactors) {
                if(n%number == 0) {
                    n /= number;
                    flag = true;
                }
            }

            if(n == 1) {
                return true;
            }
            if(!flag) {
                return false;
            }
        }
    }
}
