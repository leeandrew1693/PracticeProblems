package arrays.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andrew on 3/11/17.
 */
public class PalindromePermutationTest {
    @Test
    public void happyCaseTest() {
        Assert.assertTrue(PalindromePerumutation.palindromePermutation("abcdedcba"));
        Assert.assertTrue(PalindromePerumutation.palindromePermutation("aabbccddee"));
        Assert.assertTrue(PalindromePerumutation.palindromePermutation("aabbbccddee"));
        Assert.assertTrue(PalindromePerumutation.palindromePermutation("abadadaba"));
        Assert.assertTrue(PalindromePerumutation.palindromePermutation("asdfgfdsa"));
    }

    @Test
    public void failTestCase() {
        Assert.assertFalse(PalindromePerumutation.palindromePermutation("asdf"));
        Assert.assertFalse(PalindromePerumutation.palindromePermutation("aassdddfff"));
        Assert.assertFalse(PalindromePerumutation.palindromePermutation("oiuioo"));
        Assert.assertFalse(PalindromePerumutation.palindromePermutation("iiee8800ooaadcdddd"));
        Assert.assertFalse(PalindromePerumutation.palindromePermutation("this is not a palindrome"));
    }
}
