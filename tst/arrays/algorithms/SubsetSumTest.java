package arrays.algorithms;

import arrays.algorithms.other.SubsetSum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andrew on 2/27/17.
 */
public class SubsetSumTest {
    @Before
    public void setup() {

    }

    @Test
    public void testEqualSubsets() {
        int[] array = {3, 86, 77, 15, 93, 35, 86, 92, 49, 21, 62, 27, 90, 59, 63, 26, 40, 26, 72, 36, 11, 68, 67, 29, 82, 30, 62, 23, 67, 35, 29, 2, 22, 58, 69, 67, 93, 56, 11, 42, 29, 73, 21, 19, 84, 37, 98, 24, 15, 70, 13, 26, 91, 80, 56, 73, 62, 70, 96, 81, 5, 25, 84, 27, 36, 5, 46, 29, 13, 57, 24, 95, 82, 45, 14, 67, 34, 64, 43, 50, 87, 8, 76, 78, 88, 84, 3, 51, 54, 99, 32, 60, 76, 68, 39, 12, 26, 86, 94, 39};
        Assert.assertEquals(true, SubsetSum.divisbleTwoSubsetSum(array));
    }

    @Test
    public void testEqualSubsetsBad() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(false, SubsetSum.divisbleTwoSubsetSum(array));
    }

    @Test
    public void testSubsetSum() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(true, SubsetSum.getSubsetSum(array, 12));
    }
}
