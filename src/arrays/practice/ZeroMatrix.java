package arrays.practice;

import arrays.util.Array2DUtil;
import helper.Position;

import java.util.HashSet;
import java.util.Set;

/**
 * Write algorithm such that if an element in MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    public static void main(String args[]) {
        int[][] input = new int[][] {
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,0,5,1,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,4,5,0,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1},
                {5,4,3,4,5,1,5,3,4,1}
        };
        Array2DUtil.print2dArray(input);
        input = zeroMatrix(input);
        Array2DUtil.print2dArray(input);
    }

    public static int[][] zeroMatrix(final int[][] input) {
        final Set<Position> zeroPositions = new HashSet<>();
        for(int y =0; y < input.length; y++ ) {
            for(int x = 0; x < input[0].length; x++) {
                if(input[y][x] == 0) {
                    zeroPositions.add(new Position(x, y));
                }
            }
        }

        for(Position pos: zeroPositions) {
            for(int i =0; i < input.length; i++) {
                input[i][pos.x] = 0;
            }
            for(int i =0; i < input[0].length; i++) {
                input[pos.y][i] = 0;
            }
        }
        return input;
    }
}
