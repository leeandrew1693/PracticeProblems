package random;

import arrays.util.Array2DUtil;
import datastructures.queue.GenericQueue;
import datastructures.queue.Queue;
import helper.Position;
import javafx.geometry.Pos;

/**
 * Created by andrew on 3/8/17.
 */
public class FloodFill {
    public static void main (String[] args) {
        char[][] matrix = new char[][]
                        {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                        {'X', 'c', 'c', 'c', 'c', 'c', 'c', 'X'},
                        {'X', 'c', 'X', 'X', 'X', 'X', 'c', 'X'},
                        {'X', 'c', 'X', 'X', 'X', 'X', 'c', 'X'},
                        {'X', 'c', 'X', 'X', 'X', 'X', 'c', 'X'},
                        {'X', 'c', 'X', 'X', 'X', 'X', 'c', 'X'},
                        {'X', 'c', 'X', 'X', 'X', 'X', 'c', 'X'},
                        {'X', 'c', 'X', 'X', 'X', 'X', 'c', 'X'},
                        {'X', 'c', 'c', 'c', 'c', 'c', 'c', 'X'},
                        {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                        {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};
        Array2DUtil.print2dArray(matrix);
        matrix = floodFill(matrix, new Position(1, 1), 'O');
        Array2DUtil.print2dArray(matrix);
    }



    public static char[][] floodFill(char[][] matrix, Position pos, char replacementChar) {
        Queue queue = new GenericQueue();
        queue.enqueue(pos);
        char curChar = matrix[pos.y][pos.x];

        while(queue.size() > 0) {
            Position curPos = (Position) queue.dequeue();
            matrix[curPos.y][curPos.x] = replacementChar;

            for(int y = -1; y <= 1; y++) {
                for(int x = -1; x <= 1; x++) {
                    if(x == 0 && y == 0) {
                        continue;
                    }

                    Position newPos = new Position(curPos.x + x, curPos.y + y);

                    if(newPos.x >= matrix[0].length || newPos.y >= matrix.length || newPos.x < 0 || newPos.y < 0) {
                        continue;
                    }

                    if(matrix[newPos.y][newPos.x] == curChar) {
                        queue.enqueue(newPos);
                    }
                }
            }
        }

        return matrix;
    }

    private static void fillIfPossible(char[][] matrix, Position pos, char replacementChar, char curChar) {
    }
}
