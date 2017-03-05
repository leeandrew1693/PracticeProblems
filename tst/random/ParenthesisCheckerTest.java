package random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by andrew on 3/4/17.
 */
public class ParenthesisCheckerTest {
    @Before
    public void setUp() {

    }

    @Test
    public void testIsBalanced() {
        Assert.assertTrue(ParenthesisChecker.isBalanced("()"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("(())"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("(()())"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("(((())))"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("()()()()()()"));
    }

    @Test
    public void testIsBalancedWithChars() {
        Assert.assertTrue(ParenthesisChecker.isBalanced("((asdf))"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("(z()z(zll))z"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("((asdf)zzz)"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("(z()z(z()()ll))z"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("((asdf)()())"));
        Assert.assertTrue(ParenthesisChecker.isBalanced("(z()z(z()l()(())()(())()(())()(())()(())()(())()(())()(())()(())l))z"));

    }

    @Test
    public void testIsBalancedFalse() {
        Assert.assertFalse(ParenthesisChecker.isBalanced("()()()()()("));
        Assert.assertFalse(ParenthesisChecker.isBalanced("("));
        Assert.assertFalse(ParenthesisChecker.isBalanced(")"));
        Assert.assertFalse(ParenthesisChecker.isBalanced("())"));
    }
}
