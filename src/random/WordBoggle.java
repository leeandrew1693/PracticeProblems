package random;

import arrays.util.Array2DUtil;
import helper.Position;

import java.util.*;

/**
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character.
 * Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any
 * of 8 adjacent characters, but a word should not have multiple instances of same cell.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases . Then T test cases follow. Each
 * test case contains an integer x denoting the no of words in the dictionary. Then in the next line are x space
 * separated strings denoting the contents of the dictinory. In the next line are two integers N and M denoting
 * the size of the boggle. The last line of each test case contains NxM space separated values of the boggle.
 *
 * Output:
 * For each test case in a new line print the space separated sorted distinct words of the dictionary which
 * could be formed from the boggle. If no word can be formed print -1.
 */
public class WordBoggle {
    public static void main (String[] args) {
        boolean[][] test = new boolean[][] {{false, false, false},
                                            {false, false, false},
                                            {false, false, false}};
        char[][] boggle = {{'G', 'I', 'Z'},
                            {'U', 'E', 'K'},
                            {'Q', 'S', 'E'}};
        Set<String> dictionary = new HashSet<String>();
        Collections.addAll(dictionary, new String[]{"GEEKS", "FOR", "QUIZ", "GO"});
//        char[][] boggle = {{'H', 'I'},
//                        {'U', 'E'}};
//        Set<String> dictionary = new HashSet<String>();
//        Collections.addAll(dictionary, new String[]{"HI", "HE"});

        List<Position> pos = getToVisit(test, new Position(2,2));
        pos.forEach(asdf-> System.out.println(asdf.x + " " + asdf.y));
//
//        System.out.println(getMaxWordLength(dictionary));
        System.out.println(getWordsInDictionary(dictionary, boggle));
    }

    public static int getWordsInDictionary(Set<String> dictionary, char[][] boggle) {
        //Max depth
        final int wordLength = getMaxWordLength(dictionary);
        int output = 0;
        Set<String> matches = new HashSet<>();
        for(int i =0; i < boggle[0].length; i++) {
            for(int j =0; j <boggle.length; j++) {
                boolean[][] visited = generateVisited(boggle[0].length, boggle.length);
                visited[i][j] = true;
                String curString = new String(String.valueOf(boggle[i][j]));
                helper(dictionary, boggle, visited, new Position(i,j), curString, wordLength, matches);
            }
        }
        return matches.size();
    }

    private static boolean[][] generateVisited(int x, int y) {
        boolean[][] visited = new boolean[x][y];
        for(int i =0; i < x; i++ ) {
            for(int j = 0; j < y; j++){
                visited[i][j] = false;
            }
        }
        return visited;
    }

    private static void helper(Set<String> dictionary, final char[][] boggle, boolean[][] visited, final Position position,
                             String curString, int maxLength, Set<String> results) {
        if(curString.length() > maxLength) {
            return;
        }

        if(dictionary.contains(curString)) {
            results.add(curString);
        }

        List<Position> toVisit = getToVisit(visited, position);
        for(Position pos: toVisit) {
            String nextString = curString + boggle[pos.x][pos.y];
            boolean[][] nextVisited = Array2DUtil.clone2dArray(visited);
            nextVisited[pos.x][pos.y] = true;
            helper(dictionary, boggle, nextVisited, pos, nextString, maxLength, results);
        }
    }

    private static List<Position> getToVisit(final boolean[][] visited, final Position position) {
        List<Position> toVisit = new ArrayList<>();
        for(int i = -1; i <= 1; i++ ){
            if(position.x -i < 0 || position.x -i > visited[0].length-1) {
                continue;
            }
            for(int j = -1; j <= 1; j++) {
                if(position.y -j < 0 || position.y -j > visited.length-1) {
                    continue;
                }
                if(!visited[position.x-i][position.y-j]) {
                    toVisit.add(new Position(position.x-i, position.y-j));
                }
            }
        }
        return toVisit;
    }

    private static int getMaxWordLength(Set<String> dictionary) {
        return dictionary.stream().map(word -> word.length()).max((w1, w2) -> Integer.compare(w1, w2)).get();
    }
}
