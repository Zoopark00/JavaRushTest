import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Encryption {

    //Создаем метод для шифрования
    public static void encryption(Path src, int step, Path dist) {
        //Создаем алфавит
        ArrayList<Character> alphabet = Alphabet.initAlphabet();
        Path path = dist;

        List<String> list = new ArrayList<>();

        //Записываем исходныей файл в ArrayList построково
        try {
            list = Files.readAllLines(src);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Переводим ArrayList в массив char построково
        for (int i = 0; i < list.size(); i++) {


            char[] stringChar = list.get(i).toString().toCharArray();
            ArrayList<Character> stringArray = new ArrayList<>();

            //переводим полученный массив чаров в  ArrayList
            for (int j = 0; j < stringChar.length; j++) {
                stringArray.add(stringChar[j]);
            }
            if (step >= 0) {
                for (int k = 0; k < stringArray.size(); k++) {
                    for (int j = 0; j < alphabet.size(); j++) {

                        //сравниваем элементы полученного ArrayList с элементами из алфавита
                        if (stringArray.get(k).equals(alphabet.get(j))) {

                            // Меняем элемент полученногл ArrayList на (элемент из алфавита + шаг шифрования)
                            if ((j + step) >= 0 && (j + step) < alphabet.size()) {
                                stringArray.set(k, alphabet.get(j + step));
                                break;
                                //обрабатываем переполнение ArrayList
                            } else if ((j + step) > alphabet.size()) {
                                stringArray.set(k, alphabet.get((j + step) - alphabet.size()));
                                break;
                            }

                        }
                    }
                }
                //Склеиваем полученный ArrayList в строку
                StringBuilder sb = new StringBuilder();
                for (Character s : stringArray) {
                    sb.append(s);
                }
                System.out.println(sb.toString());

                //записываем в файл
                try {
                    Files.write(path, Collections.singleton(sb.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //Всё то же самое, только с обработкой отрицательного шага шифрования
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
    // Метод дешифрования (всё то же самое, что и шифрование, только сдвиг в обратную сторону)
    public static void decryption(Path src, int step, Path dist) {

        ArrayList<Character> alphabet = Alphabet.initAlphabet();
        Path path = dist;

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
                            if ((j - step) >= 0 && (j - step) < alphabet.size()) {
                                stringArray.set(k, alphabet.get(j - step));
                                break;
                            } else if ((j - step) > alphabet.size()) {
                                stringArray.set(k, alphabet.get((j - step) - alphabet.size()));
                                break;
                            } else if ((j - step) < 0) {
                                stringArray.set(k, alphabet.get(alphabet.size() + (j - step)));
                                break;
                            }

                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (Character s : stringArray) {
                    sb.append(s);
                }
                //System.out.println(sb.toString());
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
                           // if ((j - step) >= 0 && (j - step) < alphabet.size()) {
                            if(j >= (-step)){
                                stringArray.set(k, alphabet.get(j + step));
                                break;

                            } else if ((j - step) > alphabet.size()) {
                                stringArray.set(k, alphabet.get(alphabet.size() + (j + step)));
                                break;

                            }

                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                for (Character s : stringArray) {
                    sb.append(s);
                }
                //System.out.println(sb.toString());
                try {
                    Files.write(path, Collections.singleton(sb.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}