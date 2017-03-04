package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andrew on 2/19/17.
 */
public class LambdaFun {

    static class Person {
        int age;
        String firstName;
        String lastName;
        String occupation;

        public Person(int age, String firstName, String lastName, String occupation) {
            this.age = age;
            this.firstName = firstName;
            this.lastName = lastName;
            this.occupation = occupation;
        }
    }
    public static void main (String args[] ){
        Person albert = new Person(25, "Albert", "Sung", "Pipe Layer");
        Person andrew = new Person(25, "Andrew", "Lee", "Software Engineer");
        Person tiffany = new Person(21, "Tiffany", "Chiu", "Purchasing");
        Person jonathan = new Person(25, "Jonathan", "Lau", "Entrpernisur");
        List<Person> myList = Arrays.asList(jonathan, tiffany, albert, andrew);
//        myList.stream()
//                .filter(s -> {return s.startsWith("A");})
//                .map(s-> {return s.toUpperCase();})
//                .forEach(s -> {
//                    System.out.println("anyMatch: " + s);
//                });

        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(0);
        Map<String, String > sortedList = myList.stream()
                .filter(s -> {
                    return s.firstName.startsWith("A");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s2, s1);
                    return s1.firstName.compareTo(s2.firstName);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    s.firstName = s.firstName.toUpperCase();
                    return s;
                })
                .collect(Collectors.toMap(s -> s.firstName, s-> s.lastName));

        sortedList.forEach((first, last) -> {
            System.out.println(first + " " + last);
        });

        String word = "ohmygodsow0ww0w0wasdfw0w0w0w";
//        word.sub
        System.out.println(word.indexOf("xxxxx"));
    }


    int strstr(String s, String x) {
        List<Integer> listOfCurrentPos = new ArrayList<Integer>();

        for(int i =0; i < s.length(); i++) {
            if(s.charAt(i) == x.charAt(0)) {
                listOfCurrentPos.add(0);
            }

            for(int j = listOfCurrentPos.size()-1; j>= 0; j--) {
                int currentPos = listOfCurrentPos.get(j);
                if(s.charAt(i) != x.charAt(j)){
                    listOfCurrentPos.remove(j);
                } else {
                    if(currentPos == x.length()-1) {
                        return i-currentPos;
                    }
                    listOfCurrentPos.set(j, currentPos++);
                }
            }
        }

        return -1;
    }

}
