package recursion;

import util.*;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

/**
 * You have a stack of boxes with widths w, height h, depth d. Boxes cannot be rotated and can only be stacked
 * on top of one another if each box in the stack is strictly larger than the box above it. Implmeent a method
 * to compute the height of the tallest possible stack.
 */
public class StackOfBoxes {
    public static void main (String args[]) throws Exception {
        StackOfBoxes.Box box1 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box2 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box3 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box4 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box5 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box6 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box7 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box8 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box9 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box10 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box11 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box12 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box13 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box14 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box15 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box16 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box17 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box18 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box19 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box20 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box21 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box22 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box23 = new StackOfBoxes.Box(5,5,5);
        StackOfBoxes.Box box24 = new StackOfBoxes.Box(4,4,4);
        StackOfBoxes.Box box25 = new StackOfBoxes.Box(3,3,3);
        StackOfBoxes.Box box26 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box27 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box28 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box box29 = new StackOfBoxes.Box(2,2,2);
        StackOfBoxes.Box[] input = new StackOfBoxes.Box[]{box1, box2, box3, box4, box5, box6, box7, box8, box9,
                box10, box11, box12, box13, box14, box15, box16, box17, box18, box19,
                box20, box21, box22, box23, box24, box25, box26, box27, box28, box29};
        Callable regular = () -> getMaxHeight(input);
        Callable dp = () -> getMaxHeightDp(input);
        System.out.println(util.Timer.time(regular));
        System.out.println(util.Timer.time(dp));

    }
    public static class Box {
        int width;
        int height;
        int depth;
        public Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }

    public static int getMaxHeightDp(Box[] boxes) {
        Arrays.sort(boxes, Collections.reverseOrder(Comparator.comparingInt(value -> value.width)));
        int max = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for(int i =0; i < boxes.length; i++ ) {
            int temp = helperDp(i+1, boxes[i], boxes, dp) + boxes[i].height;
            max = max < temp ? temp : max;
        }
        return max;
    }

    private static int helperDp(int index, Box box, Box[] boxes, Map<Integer, Integer> dp) {
        if(index >= boxes.length) {
            return 0;
        }

        Box curBox = boxes[index];
        if(!doesStack(curBox, box)) {
            return 0;
        }

        int curMax = curBox.height;
        for(int i = index; i < boxes.length; i++ ){
            int temp = dp.containsKey(i+1) ? dp.get(i+1) : helperDp(i +1 , curBox, boxes, dp) + curBox.height;
            curMax = curMax < temp ? temp : curMax;
        }

        dp.put(index, curMax);
        return curMax;
    }

    public static int getMaxHeight(Box[] boxes) {
        Arrays.sort(boxes, Collections.reverseOrder(Comparator.comparingInt(value -> value.width)));
        int max = 0;
        for(int i =0; i < boxes.length; i++ ) {
            int temp = helper(i+1, boxes[i], boxes) + boxes[i].height;
            max = max < temp ? temp : max;
        }
        return max;
    }

    private static int helper(int index, Box box, Box[] boxes) {
        if(index >= boxes.length) {
            return 0;
        }

        Box curBox = boxes[index];
        if(!doesStack(curBox, box)) {
            return 0;
        }

        int curMax = curBox.height;
        for(int i = index; i < boxes.length; i++ ){
            int temp = helper(i +1 , curBox, boxes) + curBox.height;
            curMax = curMax < temp ? temp : curMax;
        }

        return curMax;
    }

    private static boolean doesStack(Box curBox, Box initialBox) {
        if(curBox.width > initialBox.width) {
            return false;
        }
        if(curBox.height > initialBox.height) {
            return false;
        }
        if(curBox.depth > initialBox.depth) {
            return false;
        }

        return true;
    }
}
