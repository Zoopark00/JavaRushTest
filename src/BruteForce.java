import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BruteForce {


    public static void bruteForce(Path src){
        HashSet<String> wordList = WordList.GetList();
        Path encrpt = Path.of("out.txt");

        for (int i = -50; i <51 ; i++) {

         Encryption.encryption(src, i);
            List<String> list = new ArrayList<>();

            //Читаем строки из файла в ArrayList
            try {
                list = Files.readAllLines(encrpt);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < list.size(); j++) {
                if(list.contains(wordList));
                System.out.print("Ключ шифрования  = "+i);
                break;

            }

        }
    }
}
