import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        Path path  = Path.of("C:\\temp\\1.txt");
        Encryption encryption = new Encryption();
        encryption.encryption(path,-40);
        }

        }


