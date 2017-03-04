package random;

/**
 * Created by andrew on 2/19/17.
 */
public class ReverseString {

    public static void main (final String args[]) {
        System.out.println(reverseString("cow"));
    }

    public static String reverseString(final String inputString) {
        StringBuilder sb = new StringBuilder();
        for(int i = inputString.length()-1; i >= 0; i--) {
            sb.append(inputString.charAt(i));
        }
        return sb.toString();
    }
}
