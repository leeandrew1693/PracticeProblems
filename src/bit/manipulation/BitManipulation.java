package bit.manipulation;

/**
 * Created by andrew on 2/19/17.
 */
public class BitManipulation {
    public static void main(final String args[]) {
        System.out.println(clearBit(6,1));
        System.out.println(setBitAs(6,3,true));
        System.out.println(printAsBits(-8));
        System.out.println(printAsBits(8));
    }

    public static boolean getBit(final int num, final int i) {
        return ((num & 1 << i) != 0);
    }

    public static int setBit(final int num, final int i) {
        return (num | 1 << i);
    }

    public static int clearBit(final int num, final int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int setBitAs(final int num, final int i, final boolean value) {
        int bitValue = value ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | bitValue << i;
    }

    public static String printAsBits(final int num) {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i < 32; i++ ){
            int myInt = (getBit(num, i)) ? 1 : 0;

            sb.insert(0, myInt);
        }

        return sb.toString();
    }

    public static String convertToBits(int num) {
        final StringBuilder sb = new StringBuilder();
        while(num != 0) {
            sb.insert(0, num%2);
            num /=2;
        }
        return sb.toString();
    }
}
