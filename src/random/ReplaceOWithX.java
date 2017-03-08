package random;

import arrays.util.Array2DUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a matrix of size NxM where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded
 * by ‘X’. A ‘O’ (or a set of ‘O’) is considered to be by surrounded by ‘X’ if there are ‘X’ at locations
 * just below, just above, just left and just right of it.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.
 * The first line of each test case contains two integers N and M denoting the size of the matrix.
 * Then in the next line are N*M space separated values of the matrix.
 *
 * Output:
 * For each test case print the space separated values of the new matrix.
 *
 * Input: mat[N][M] =
 * {'X', 'X', 'X', 'X'}
 * {'X', 'O', 'X', 'X'}
 * {'X', 'O', 'O', 'X'}
 * {'X', 'O', 'X', 'X'}
 * {'X', 'X', 'O', 'O'}
 *
 * Output: mat[N][M] =
 * {'X', 'X', 'X', 'X'}
 * {'X', 'X', 'X', 'X'}
 * {'X', 'X', 'X', 'X'}
 * {'X', 'X', 'X', 'X'}
 * {'X', 'X', 'O', 'O'}
 */
public class ReplaceOWithX {
    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            StringBuilder sb = new StringBuilder();
            sb.append("X:");
            sb.append(x);
            sb.append("Y:");
            sb.append(y);

            return sb.toString().hashCode();
        }
    }

    public static void main(String[] args) {
//        char[][] inputMap = new char[][] {{'X','X', 'X'},
//                {'X', 'O','X'},
//                {'X','X','X'}};

//        char[][] inputMap = new char[][] {{'X','X', 'X', 'O'},
//                {'X', 'X','O', 'X'},
//                {'X', 'O','O', 'X'},
//                {'X', 'X','X', 'X'}};

        char[][] inputMap = new char[][] {{'X','X', 'X', 'O', 'X', 'X'},
                                        {'X', 'X','X', 'X', 'O', 'X'},
                                        {'X', 'X','X', 'X', 'O', 'X'},
                                        {'X', 'O','O', 'O', 'O', 'X'},
                                        {'X', 'O','O', 'O', 'O', 'X'},
                                        {'X', 'O','O', 'O', 'O', 'X'},
                                        {'X', 'O','O', 'O', 'O', 'X'},
                                        {'X', 'O','X', 'X', 'X', 'X'},
                                        {'X', 'O','X', 'X', 'X', 'X'},
                                        {'X', 'O','X', 'X', 'X', 'X'},
                                        {'X', 'O','X', 'O', 'O', 'O'},
                                        {'X', 'O','X', 'X', 'X', 'X'},
                                        {'X', 'O','X', 'X', 'X', 'X'},
                                        {'X', 'X','X', 'X', 'X', 'X'}};
        char[][] inputMapForNaive = Array2DUtil.clone2dArray(inputMap);
        Array2DUtil.print2dArray(inputMap);
        Array2DUtil.print2dArray(replaceOWithX(inputMap));

    }

    /**
     * Replaces all the O's surrounded by X's with x.
     * @param inputArray
     * @return
     */
    public static char[][] replaceOWithX(char[][] inputArray) {
        for(int i =0; i < inputArray.length; i++ ){
            for(int j = 0; j < inputArray[0].length; j++ ){
                if(inputArray[i][j] == 'O') {
                    modifyIfSurrounded(inputArray, new Position(j, i));
                }
            }
        }
        return inputArray;
    }

    /**
     * Modifies the char in the current position and all adjacent O's if they are surrounded by X's. Otherwise
     * change to o.
     *
     * @param inputArray
     * @param pos
     * @return
     */
    private static char[][] modifyIfSurrounded(char[][] inputArray, final Position pos) {
        surroundedHelper(inputArray, pos, new HashSet<>(), true);
        return inputArray;
    }

    /**
     * Helper method for recursion
     *
     * @param inputArray
     * @param pos
     * @param visitedPos
     * @param flag
     * @return
     */
    private static boolean surroundedHelper(char[][] inputArray, Position pos, Set<Integer> visitedPos, boolean flag) {
        //Base condition. If smaller than 0 or greater than array dimensions
        if(pos.x-1 < 0 || pos.y -1 < 0 || pos.x +1 >= inputArray[0].length || pos.y +1 >= inputArray.length) {
            return false;
        }

        final Position leftPos = new Position(pos.x-1, pos.y);
        final Position upPos = new Position(pos.x, pos.y-1);
        final Position rightPos = new Position(pos.x+1, pos.y);
        final Position downPos = new Position(pos.x, pos.y+1);
        final Set<Integer> set = new HashSet<>(visitedPos);
        set.add(pos.hashCode());

        if(inputArray[upPos.y][upPos.x] == 'O' && !visitedPos.contains(upPos.hashCode())) {
            flag = surroundedHelper(inputArray, upPos, set, flag) && flag;
        }
        if(inputArray[leftPos.y][leftPos.x] == 'O' && !visitedPos.contains(leftPos.hashCode())) {
            flag = surroundedHelper(inputArray, leftPos, set, flag) && flag;
        }
        if(inputArray[downPos.y][downPos.x] == 'O' && !visitedPos.contains(downPos.hashCode())) {
            flag = surroundedHelper(inputArray, downPos, set, flag) && flag;
        }
        if(inputArray[rightPos.y][rightPos.x] == 'O' && !visitedPos.contains(rightPos.hashCode())) {
            flag = surroundedHelper(inputArray, rightPos, set, flag) && flag;
        }

        if(flag) {
            inputArray[pos.y][pos.x] = '#';
        } else {
            inputArray[pos.y][pos.x] = 'o';
        }
//        Array2DUtil.print2dArray(inputArray);
        return flag;

    }

}
