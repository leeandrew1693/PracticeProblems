import datastructures.stack.MinStack;
import datastructures.stack.Stack;
import util.Timer;

import java.util.concurrent.Callable;

/**
 * Created by andrew on 1/27/17.
 */
public class TowersOfHanoi {
    static Stack stack1 = new MinStack();
    static Stack stack2 = new MinStack();
    static Stack stack3 = new MinStack();

    public static void main(final String args[]) throws Exception {
        initialize(26);
        final Callable callable = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
//                solveRecursively(stack1.size(), stack1, stack2, stack3);
//                solveRecursivelyMovements(5, "A", "B", "C");
                solveIteratively(stack1, stack2, stack3);
                return null;
            }
        };
        Timer.time(callable);
    }

    private static void moveDisc(final Stack fromStack, final Stack toStack) throws Exception {
        toStack.push(fromStack.pop());
//        printStacks();
    }

    private static void solveRecursively(final int n, final Stack start, final Stack extra, final Stack end) throws Exception {
        if (n == 1) {
            moveDisc(start, end);
        } else {
            solveRecursively(n - 1, start, end, extra);
            moveDisc(start, end);
            solveRecursively(n - 1, extra, start, end);
        }
    }

    private static void solveRecursivelyMovements(final int n, final String start, final String extra, final String end) throws Exception {
        if (n == 1) {
            System.out.println(start + " -> " + end);
        } else {
            solveRecursivelyMovements(n - 1, start, end, extra);
            System.out.println(start + " -> " + end);
            solveRecursivelyMovements(n - 1, extra, start, end);
        }
    }
    private static void solveIteratively(final Stack start, final Stack extra, final Stack end) throws Exception {
        final long numIterations = (long) (Math.pow(2, start.size()) -1);
        final Stack aux;
        final Stack destination;

        if(start.size() %2 == 0) {
            aux = end;
            destination = extra;
        } else {
            aux = extra;
            destination = end;
        }

        for(int i =1; i<= numIterations ; i++ ){
            switch(i%3) {
                case 1:
                    moveDiscsForIterative(start, destination);
                    break;
                case 2:
                    moveDiscsForIterative(start, aux);
                    break;
                case 0:
                    moveDiscsForIterative(aux, destination);
                    break;
                default:
                    throw new Exception("Whoa there's an error here!");
            }
        }
    }

    private static void moveDiscsForIterative(final Stack stack, final Stack otherStack) throws Exception {
        if(otherStack.size() == 0) {
            moveDisc(stack, otherStack);
        } else if (stack.size() == 0) {
            moveDisc(otherStack, stack);
        } else if ((int) otherStack.peek() > (int) stack.peek()) {
            moveDisc(stack, otherStack);
        } else if ((int) stack.peek() > (int) otherStack.peek()) {
            moveDisc(otherStack, stack);
        }

    }

    private static void printStacks() {
        System.out.println("Stack 1: " + stack1.stackVariables());
        System.out.println("Stack 2: " + stack2.stackVariables());
        System.out.println("Stack 3: " + stack3.stackVariables());
        System.out.println();
    }

    private static void initialize(final int numDiscs) throws Exception {
        for(int i =numDiscs; i > 0; i-- ) {
           stack1.push(i);
        }
    }
}
