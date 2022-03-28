import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BruteForce {

    //Подбор ключа
    public static void bruteForce(Path src) {
        //Создаем список слов с которыми будем сравнивать
        HashSet<String> wordList = WordList.GetList();
        //цикл для перебора всего множеста ключей
        for (int i = -30; i < 30; i++) {
            boolean bln = false;
            File f = null;
            Path dist = null;
            //Создаем временный файл, в который будем сохраняфть сдвиг на 1 шаг
            try {
                f = File.createTempFile("tmp", ".txt", null);
                dist = Path.of(f.getAbsolutePath());

            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(dist);

            //Применяем метод расшифровки со свигом на 1 шаг
            Encryption.decryption(src, i, dist);
            List<String> list = new ArrayList<>();
            try {
                list = Files.readAllLines(dist);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //читаем полученный файл и сравниваем слова в нем с проверочным набором слов
            for (String s : list) {

                for (String example : wordList) {
                    if (s.toLowerCase().contains(example)) {
                        System.out.println("Ключ ширования = " + i);
                        System.out.println("Найденное словоe - " + example);
                        bln = true;
                        break;

                    }
                }
                }
                if (bln) {
                    break;
                }
                //удаляем временный файл
                try {
                    f.deleteOnExit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
