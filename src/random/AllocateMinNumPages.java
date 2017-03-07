package random;

import util.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * You are given N number of books. Every ith book has Pi number of pages.
 * You have to allocate books to M number of students. There can be many ways or permutations to do so.
 * In each permutation one of the M students will be allocated the maximum number of pages.
 * Out of all these permutations, the task is to find that particular permutation in which the maximum number
 * of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value.
 *
 * Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.
 *
 * Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order
 * (see explanation for better understanding).
 *
 * Input:
 * The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
 * Each case begins with a single positive integer N denoting the number of books.
 * The second line contains N space separated positive integers denoting the pages of each book.
 * And the third line contains another integer M, denoting the number of students.
 *
 * Output:
 * For each test case, output a single line containing minimum number of pages each student has to read
 * for corresponding test case.
 */
public class AllocateMinNumPages {
    public static void main(String[] args) throws Exception {
        int[] books = {1,1,1,1,1,1,1,1,10,5,5,5,5,5};
//        int[] books = {12, 34, 67, 98, 90};
        int students = 4;

//        Callable onlineAnswer = () -> books(Arrays.asList(books), students);
//        Timer.time(onlineAnswer);
        System.out.println(books(books, students));
        System.out.println(getMinPagesPerStudent(books, students));
    }

    /**
     * Not optimal solution. We're currently in exponential or even factorial time...
     *
     * @param books
     * @param students
     * @return
     */
    public static int getMinPagesPerStudent(int[] books, int students) {
        if(students > books.length) {
            return -1;
        }

        List<Integer> input = new ArrayList<>();
        for(int i =0; i < students; i++) {
            input.add(i);
        }

        return helper(books, students, input, Integer.MAX_VALUE);
    }

    private static int helper(int[] books, int students, List<Integer> pos, int min) {
        int temp = getMaxOfPermutations(books, pos);
        min = min < temp ? min : temp;

        List<Integer> newList = new ArrayList<>(pos);
        for(int i =pos.size()-1; i >= 1 ; i--) {
            int tempPosition = newList.get(i) +1;
            if(tempPosition >= books.length) {
                continue;
            }
            if(i+1 < pos.size()-1) {
                if(pos.get(i) +1 == pos.get(i+1)) {
                    continue;
                }
            }
            newList.remove(i);
            newList.add(i, new Integer(tempPosition));
            int newTemp = helper(books, students, newList, min);
            min = min < newTemp ? min : newTemp;

        }
        return min;
    }

    private static int sumOfArrayFrom(int[] books, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += books[i];
        }
        return sum;
    }

    private static int getMaxOfPermutations(int[] books, List<Integer> pos) {
        int max = 0;
        for(int i =0; i < pos.size(); i ++) {
            int curMax =0;
            if(i >= pos.size()-1) {
               curMax = sumOfArrayFrom(books, pos.get(i), books.length);
            } else {
               curMax = sumOfArrayFrom(books, pos.get(i), pos.get(i+1));
            }
            if(curMax > max) {
                max = curMax;
            }
        }
        return max;
    }

    public static int books(int[] listOfBooks, int students) {
        long low = 0;
        long target, result = 0;

        if (students > listOfBooks.length)
            return -1;

        long sum = 0;

        for (int pages : listOfBooks)
            sum += pages;
        long high = sum;

        while (low <= high) {
            target = low + ((high - low) /2);
            System.out.println(String.format("Low: %d Target: %d High: %d", low, target, high));

            if (isPossible(listOfBooks, students, target, sum)) {
                result = target;
                high = target - 1;
            } else {
                low = target + 1;
            }
        }

        return (int) result;

    }

    private static boolean isPossible(int[] listOfBooks, int numStudents, long targetPages, long totalPages) {
        // Target can't be less than average
        if (targetPages < totalPages / numStudents)
            return false;

        int index = 0;
        int n = listOfBooks.length;


        for (int i = 0; i < numStudents && index < n; i++) {
            long total = 0;

            while (total < targetPages && index < n) {
                total += listOfBooks[index];
                if (total > targetPages)
                    break;
                index++;
            }
        }

        if (index < n)
            return false;

        return true;
    }


}
