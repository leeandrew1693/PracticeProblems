package bit.manipulation;

import static bit.manipulation.BitManipulation.convertToBits;

/**
 * Find number of bits you need to flip to convert integer A to integer B
 */
public class Conversion {
    public static void main(String args[]) {
        int a = 150;
        int b = 0;
        System.out.println(convertToBits(a));
        System.out.println(convertToBits(b));
        System.out.println(numBitsNeeded(a, b));
    }

    public static int numBitsNeeded(final int a, final int b) {
        final String aInBits = convertToBits(a);
        final String bInBits = convertToBits(b);
        final int difference = Math.abs(aInBits.length() - bInBits.length());
        int numBitsNeeded = difference;

        if(a > b) {
            for(int i = 0; i < bInBits.length(); i++) {
                if(aInBits.charAt(i + difference) != bInBits.charAt(i)) {
                    numBitsNeeded ++;
                }
            }
        } else {
            for(int i = 0; i < aInBits.length(); i++) {
                if(bInBits.charAt(i + difference) != aInBits.charAt(i)) {
                    numBitsNeeded ++;
                }
            }

        }
        return numBitsNeeded;
    }


}
