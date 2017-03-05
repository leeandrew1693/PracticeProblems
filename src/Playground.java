import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by andrew on 2/3/17.
 */
public class Playground {
    public static void main (final String args[]) {
        final Set<String> outputSet = new HashSet<>();
//        String a = "foo"; String b = "food".substring(0,3); String c = b.intern(); System.out.println(a == c);
        int[] array = new int[]{1,2,3};

        testModifyArray(array);
        for(int value : array) {
            System.out.println(value);
        }
        String test = "asdf";
        System.out.println(test.substring(0,3));
        System.out.println(tryFinally());
        int x = 1;
        System.out.println(++x);
        Map<int[], String> asdf = new HashMap<>();
        Set<String> set = new HashSet<>();
        int[] index = {0,0};
        List<String> list= new ArrayList<>();
        asdf.put(index, "ASDF");
        System.out.println(asdf.get(index));
//        Set<String> set =  getPermutations("asdflkj");
//        set.forEach((value) -> {
//            System.out.println(value);
//        });
    }
    public static void testModifyArray(int[] array) {
        array[0] = 100;
    }
    public static boolean tryFinally() {
        try{
            return true;
        } finally{
            return false;
        }
    }

    public static Set<String> getPermutations(final String inputString) {
        final Set<String> outputSet = new HashSet<>();
        for(int i = 0; i< Math.pow(2, inputString.length()); i++ ){
            final StringBuilder stringBuilder = new StringBuilder();
            for(int j =1 ; j <= inputString.length(); j ++) {
                if(getBinaryForPos(j, i)) {
                    stringBuilder.append(inputString.charAt(j-1));
                }
            }
            outputSet.add(stringBuilder.toString());
        }
        return outputSet;
    }

    private static boolean getBinaryForPos(final int characterPosition, final int num) {
        if(num ==0 ) {
            return false;
        }

        final int tempNum = characterPosition -1 == 0 ? num :num/((characterPosition-1) * 2);
        return tempNum%2 == 1 ? true : false;
    }

    public static int tripleStep(final int numSteps) {
        int total = 0;
        if(numSteps == 0) {
            return 1;
        } else if( numSteps < 0) {
            return 0;
        }

        total += tripleStep(numSteps-1);
        total += tripleStep(numSteps-2);
        total += tripleStep(numSteps-3);
        return total;
    }

    public static String robotInGrid(int x, int y, final String steps, final boolean[][] board) {
        if(x == board[0].length-1 && y == board.length-1) {
            return steps;
        }

        if(x > board.length-1 || y > board.length-1) {
            return null;
        }

        if(steps == null) {
            return null;
        }

        y++;
        String temp = robotInGrid(x,y,goDown(x, y, steps, board), board);
        if(temp == null) {
            y--;
            x++;
            temp = robotInGrid(x,y, goRight(x, y, steps, board), board);
        }
        return temp;
    }

    private static String goDown(final int x, final int y, final String steps, final boolean[][] board){
        if(y> board.length-1) {
            return null;
        } else if(board[x][y]) {
            return null;
        } else {
            return steps + " down";
        }
    }

    private static String goRight(final int x, final int y, final String steps, final boolean[][] board){
        if(x> board.length-1) {
            return null;
        } else if(board[x][y]) {
            return null;
        } else {
            return steps + " right";
        }
    }
}
