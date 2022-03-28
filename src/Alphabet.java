import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {

    //Класс, создающий алфавит на основе которого будем делать сдвиг по ключу
    public static ArrayList<Character> initAlphabet() {
        ArrayList<Character> alphabet = new ArrayList<>();

        for (char ch = 'а'; ch <= 'я'; ch++) {
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

      //  System.out.println(alphabet);
            return alphabet;


    }
}
