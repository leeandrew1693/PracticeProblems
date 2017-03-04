package random;

/**
 * Created by andrew on 2/18/17.
 */
public class StringSubstraction {

    public static void main(String args[]) {
        String baseWord = "w0wwhatacow";
        String removeWord = "what";

        System.out.println(subtractFromString(baseWord, removeWord));
    }
    public static String subtractFromString(final String baseWord, final String subtractedString){
        for(int i = 0; i < baseWord.length(); i++ ) {
            boolean flag = true;
            for(int j = 0; j < subtractedString.length(); j++) {
                if(baseWord.charAt(i+j) != subtractedString.charAt(j))
                    flag = false;
            }
            if(flag) {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append(baseWord.substring(0, i));
                stringbuilder.append(baseWord.substring(i+subtractedString.length(), baseWord.length()));
                return stringbuilder.toString();
            }
        }
        return baseWord;
    }



}
