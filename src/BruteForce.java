import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class BruteForce {


    public static void bruteForce(Path src) {
        HashSet<String> wordList = WordList.GetList();

        for (int i = -30; i < 30; i++) {
            boolean bln = false;
            File f = null;
            Path dist = null;
            try {
                f = File.createTempFile("tmp", ".txt", null);
                dist = Path.of(f.getAbsolutePath());

            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.println(dist);

            Encryption.decryption(src, i, dist);
            List<String> list = new ArrayList<>();
            try {
                list = Files.readAllLines(dist);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                try {
                    f.deleteOnExit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
