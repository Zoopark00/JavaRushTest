import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Encryption {
    public void encryption(Path src, int step) {
        Alphabet alph = new Alphabet();
        ArrayList<Character> alphabet = alph.initAlphabet();
        Path path = Path.of("out.txt");

        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(src);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < list.size(); i++) {


            char[] stringChar = list.get(i).toString().toCharArray();
            ArrayList<Character> stringArray = new ArrayList<>();
            for (int j = 0; j < stringChar.length; j++) {
                stringArray.add(stringChar[j]);
            }
            if (step >= 0) {
                for (int k = 0; k < stringArray.size(); k++) {
                    for (int j = 0; j < alphabet.size(); j++) {

                        if (stringArray.get(k).equals(alphabet.get(j))) {
                            if ((j + step) >= 0 && (j + step) < alphabet.size()) {
                                stringArray.set(k, alphabet.get(j + step));
                                break;
                            } else if ((j + step) > alphabet.size()) {
                             stringArray.set(k, alphabet.get((j + step) - alphabet.size()));
                                break;
                             }

                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (Character s : stringArray) {
                    sb.append(s);
                }
                System.out.println(sb.toString());
                try {
                    Files.write(path, Collections.singleton(sb.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (step < 0) {
                for (int k = 0; k < stringArray.size(); k++) {
                    for (int j = 0; j < alphabet.size(); j++) {

                        if (stringArray.get(k).equals(alphabet.get(j))) {
                            if ((j + step) >= 0 && (j + step) < alphabet.size()) {
                                stringArray.set(k, alphabet.get(j + step));
                                break;
                            } else if ((j + step) < 0) {
                                stringArray.set(k, alphabet.get(alphabet.size() + (j + step)));
                                break;
                            } else if ((j + step) > alphabet.size()) {
                                stringArray.set(k, alphabet.get(alphabet.size() - (j + step)));
                                break;

                            }

                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (Character s : stringArray) {
                    sb.append(s);
                }
                System.out.println(sb.toString());
                try {
                    Files.write(path, Collections.singleton(sb.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}