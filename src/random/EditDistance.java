package random;

import datastructures.stack.GenericStack;
import datastructures.stack.common.Stack;
import util.Timer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by andrew on 3/4/17.
 */
public class EditDistance {
    public static void main(String args[]) throws Exception {
        String from = "asdcat";
        String to = "cat";
        Callable minEditDistance= () -> getMinEditDistance(from, to);
        Callable minEditDistanceDp = () -> getMinEditDistanceDp(from, to);
        Timer.time(minEditDistance);
        Timer.time(minEditDistanceDp);
    }

    private static int min(int x,int y,int z)
    {
        if (x<y && x<z) return x;
        if (y<x && y<z) return y;
        else return z;
    }

    public static int getMinEditDistance(String from, String to) {
        Distance input = new Distance();
        input.steps.add(from);
        Distance min = minEditDistance(from, to, from.length(), to.length(), input);
        System.out.println(min.distance);
        for(String step : min.steps) {
            System.out.println(step);
        }
        return min.distance;
    }

    public static int getMinEditDistanceDp(String from, String to) {
        int min = minEditDistanceDp(from, to, new HashMap<>(), from.length(), to.length());
        System.out.println(min);
        return min;
    }

    private static int minEditDistanceDp(String from, String to, Map<Integer, Map<Integer, Integer>> dp, int m, int n) {
        if(dp.containsKey(m) && dp.get(m).containsKey(n)) {
            return dp.get(m).get(n);
        }

        if(m ==0 ) {
            insert(dp, m, n, n);
            return n;
        }

        if(n == 0) {
            insert(dp, m, n, m);
            return m;
        }

        if(from.charAt(m-1) == to.charAt(n-1)) {
            int min = minEditDistanceDp(from, to, dp, m-1, n-1);
            insert(dp, m, n, min);
            return min;
        }

        int min = 1 + min(
                minEditDistanceDp(from, to, dp, m-1, n),  // Remove
                minEditDistanceDp(from, to, dp, m, n-1),  // Insert
                minEditDistanceDp(from, to, dp, m-1, n-1)
        );
        insert(dp, m, n, min);
        return min;
    }

    private static void insert(Map<Integer, Map<Integer, Integer>> dp, int m, int n, int val) {
        if(!dp.containsKey(m)) {
            dp.put(m, new HashMap<>());
        }
        dp.get(m).put(n, val);
    }

    static class Distance {
        int distance;
        List<String> steps = new ArrayList<>();

        public Distance() {
            this.distance =0;
            List<String> steps = new ArrayList<>();
        }
        public Distance(Distance distance) {
            this.distance = distance.distance;
            this.steps = new ArrayList<>(distance.steps);
        }
    }
    private static Distance minEditDistance(String from, String to, int m, int n, Distance distance) {
        if(m ==0 ) {
            distance.distance = n;
            return new Distance(distance);
        }

        if(n == 0) {
            distance.distance = m;
            return new Distance(distance);
        }

        if(from.charAt(m-1) == to.charAt(n-1)) {
            return minEditDistance(from, to, m-1, n-1, distance);
        }

        String insert;
        String replace;
        String remove;
        if(m + 1 > from.length()) {
            insert = from.substring(0, m) + to.charAt(n-1);
            replace = from.substring(0, m-1) + to.charAt(n-1);
            remove = from.substring(0, m-1);
        } else {
            insert = from.substring(0, m) + to.charAt(n-1) + from.substring(m+1, from.length());
            replace = from.substring(0, m-1) + to.charAt(n-1) + from.substring(m+1, from.length());
            remove = from.substring(0, m-1) + from.substring(m+1, from.length());
        }

        Distance x = minEditDistance(remove, to, m-1, n, distance);  // Remove
        Distance y = minEditDistance(insert, to, m, n-1, distance);  // Insert
        Distance z = minEditDistance(replace, to, m-1, n-1,distance );
        if (x.distance<y.distance && x.distance<z.distance) {
            Distance output = new Distance(x);
            output.distance +=1;
            output.steps.add(remove);
            return output;
        }
        if (y.distance<x.distance && y.distance<z.distance) {
            Distance output = new Distance(y);
            output.distance +=1;
            output.steps.add(insert);
            return output;
        } else {
            Distance output = new Distance(z);
            output.distance +=1;
            output.steps.add(replace);
            return  output;
        }
    }
}
