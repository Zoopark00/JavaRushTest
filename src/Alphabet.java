import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {


    public ArrayList<Character> initAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<>();

        for (char ch = 'А'; ch <= 'я'; ch++) {
            alphabet.add(ch);
        }
        alphabet.add('Ё');
        alphabet.add('ё');
        alphabet.add(',');
        alphabet.add('.');
        alphabet.add('"');
        alphabet.add(':');
        alphabet.add('-');
        alphabet.add('?');
        alphabet.add(' ');


            return alphabet;


    }
}
