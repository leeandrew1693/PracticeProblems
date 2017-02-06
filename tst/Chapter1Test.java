import org.junit.Assert;
import org.junit.Test;

/**
 * Created by andrew on 2/4/17.
 */
public class Chapter1Test {
    Chapter1 chapter1= new Chapter1();

    @Test
    public void isStringAllUniqueCharactersTest() {
        Assert.assertEquals(true, chapter1.isStringAllUniqueCharacters("asdf"));
        Assert.assertEquals(false, chapter1.isStringAllUniqueCharacters("aasdf"));
    }

    @Test
    public void replaceSpacesWithEscaped() {
        char [] input = {'h', ' ' , 'i' ,' ', ' '};
        char [] result ={'h', '%', '2', '0', 'i'};
        Assert.assertEquals("h%20i", chapter1.replaceSpacesWithEscaped(input));
    }
}
