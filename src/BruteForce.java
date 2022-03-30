import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BruteForce {

    //Метод для подбора пароля
    public static void bruteForce(Path src) {
        //Создаем набор слов для проверки
        HashSet<String> wordList = WordList.GetList();
        //создаем цикл для перебора ключей
        for (int i = -50; i < 51; i++) {
            boolean bln = false;
            File f = null;
            Path dist = null;
            //Создаем временны файл для записи итогов сдвига на 1 шаг
            try {
                f = File.createTempFile("tmp", ".txt", null);
                dist = Path.of(f.getAbsolutePath());

            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(dist);

            //вызываем метод дешифровки со сдвигом на 1 шаг
            Encryption.decryption(src, i, dist);
            List<String> list = new ArrayList<>();
            try {
                list = Files.readAllLines(dist);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Сравниваем полученный файл со список проверочных слов
            for (String s : list) {

                for (String example : wordList) {
                    if (s.toLowerCase().contains(example)) {
                        System.out.println("Ключ шифрования= " + i);
                        System.out.println("Найденное слово - " + example);
                        bln = true;
                        break;

                    }
                }
                }
                if (bln) {
                    break;
                }
                //Удвляем временный файл
                try {
                    f.deleteOnExit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
