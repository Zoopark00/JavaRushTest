import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {


    public static ArrayList<Character> initAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<>();

        for (char ch = 'À'; ch <= 'ÿ'; ch++) {
            alphabet.add(ch);
        }
        alphabet.add('¨');
        alphabet.add('¸');
        alphabet.add(',');
        alphabet.add('.');
        alphabet.add('"');
        alphabet.add(':');
        alphabet.add('-');
        alphabet.add('?');
        alphabet.add(' ');

      //  System.out.println(alphabet);
            return alphabet;


    }
}
