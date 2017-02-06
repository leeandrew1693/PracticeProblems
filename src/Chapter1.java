import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by andrew on 2/4/17.
 */
public class Chapter1 {
    public boolean isStringAllUniqueCharacters(final String string) {
        final Set<Character> setOfChars = new HashSet<>();
        for (char character : string.toCharArray()) {
            if (setOfChars.contains(character)) {
                return false;
            } else {
                setOfChars.add(character);
            }
        }
        return true;
    }

    public boolean isStringPermuationOfString(final String string1, final String string2) {
        final Map<Character, Integer> smallStringMapping;
        final Map<Character, Integer> largeStringMapping;
        if (string1.length() > string2.length()) {
            largeStringMapping = getNumCharsInString(string1);
            smallStringMapping = getNumCharsInString(string2);
        } else {
            largeStringMapping = getNumCharsInString(string2);
            smallStringMapping = getNumCharsInString(string1);
        }

        return true;
//        List<Boolean> list = smallStringMapping.entrySet().stream().filter(entry -> {
//            if(!largeStringMapping.containsKey(entry.getKey())) {
//                return false;
//            } else if (largeStringMapping.get(entry.getKey()) < entry.getValue()){
//                return false;
//            } else {
//                return true;
//            }
//        }).collect(Collectors.toList());
//        smallStringMapping.forEach((character, numChars) -> {
//            if(!largeStringMapping.containsKey(character)) {
//                return false;
//            }
//        });
    }

    private Map<Character, Integer> getNumCharsInString(final String string) {
        final Map<Character, Integer> mapping = new TreeMap<>();
        for (char character : string.toCharArray()) {
            if (mapping.containsKey(character)) {
                mapping.put(character, mapping.get(character));
            } else {
                mapping.put(character, 1);
            }
        }

        return mapping;
    }

    public String replaceSpacesWithEscaped(final char[] inputString) {
        Character curChar = null;
        int pointer = inputString.length - 1;
        for (int i = inputString.length - 1; i >= 0; i--) {
            if (curChar == null && inputString[i] == ' ') {
                continue;
            }
            curChar = inputString[i];
            if (curChar == ' ') {
                inputString[pointer --] = '0';
                inputString[pointer --] = '2';
                inputString[pointer --] = '%';
            } else {
                inputString[pointer --] = curChar;
            }
        }
        return new String(inputString);
    }

}
