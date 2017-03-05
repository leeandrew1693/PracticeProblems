package random;

/**
 * Created by andrew on 3/4/17.
 */
public class ParenthesisChecker {
    public static void main(String args[]) {
    }

    public static boolean isBalanced(String str) {
        return isBalancedHelper(str, 0);
    }

    public static boolean isBalancedHelper(final String str, int numLeftParen) {
        if(numLeftParen > 0 && str.length() == 0) {
            return false;
        } else if (numLeftParen == 0 && str.length() ==0 ) {
            return true;
        }

        if(numLeftParen == 0 && str.charAt(0) == ')') {
            return false;
        }

        if (str.charAt(0) == '(') {
            return isBalancedHelper(str.substring(1), numLeftParen + 1);
        } else if (str.charAt(0) == ')') {
            return isBalancedHelper(str.substring(1), numLeftParen - 1);
        } else {
            return isBalancedHelper(str.substring(1), numLeftParen);
        }
    }
}
