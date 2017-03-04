package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 2/18/17.
 */
public class TwoDimensionalArray {
    static int[] array = {2,3,1};
    static int[][] twoDimensionalArray = {{1,2}, {2,3}};
    static List<String> list = new ArrayList<>();
    public static void main(String args []) {
        System.out.println(tripletSum(5, array));
    }

    static boolean tripletSum(int x, int[] a) {
        Map<Integer, Integer> map = generateMap(a);
        String asdf = "asdf";
        StringBuilder builder = new StringBuilder();

        boolean flag = false;
        for(int num: a) {
            if(num >= x) {
                continue;
            }

            int difference = x - num;
            Map<Integer, Integer> curMap = removeFromMap(num, map);
            flag = doubleSum(difference, curMap);

            if(flag) {
                return true;
            }
        }

        return false;
    }

    private static boolean doubleSum(int x, Map<Integer, Integer> numbers) {
        for(Map.Entry entry: numbers.entrySet()) {
            int curNum = (int)entry.getKey();
            if(curNum > x || curNum <= 0) {
                continue;
            }

            Map<Integer, Integer> curMap = removeFromMap(curNum, numbers);
            int difference = x - curNum;

            if(curMap.containsKey(x-curNum)) {
                return true;
            }
        }
        return false;
    }

    private static Map<Integer,Integer> removeFromMap(int num, Map<Integer, Integer> map) {
        Map<Integer, Integer> modifiedMap = new HashMap<>(map);
        if(!modifiedMap.containsKey(num)){
            return map;
        }
        if(modifiedMap.get(num) > 1) {
            modifiedMap.put(num, modifiedMap.get(num)-1);
        } else {
            modifiedMap.remove(num);
        }
        return modifiedMap;
    }

    private static Map<Integer, Integer> generateMap(int[] arrayOfNumbers) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int num : arrayOfNumbers) {
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num,1);
            }
        }
        return map;
    }
}
