import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int choice = 0;
        boolean b = true;
        String source;
        Path path = null;
        boolean sourcebln = true;
        int step = 0;
        boolean stepbln = true;
        String decrypt = "нажмите 1, чтобы зашифровать";
        String encrypt = "нажмите 2, чтобы расшифровать";


        Scanner scanner = new Scanner(System.in);

        System.out.println(decrypt);
        System.out.println(encrypt);
        while (b) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 3 && choice > 0) {
                    b = false;
                } else {
                    System.out.println(decrypt);
                    System.out.println(encrypt);
                }
            } else {
                System.out.println(decrypt);
                System.out.println(encrypt);
                scanner.next();
            }
        }
        System.out.println("Введите путь к файлу");
        Scanner scanner1 = new Scanner(System.in);
        while (sourcebln) {
            source = scanner1.nextLine();
            path = Path.of(source);
            if (Files.exists(path)) {
                sourcebln = false;
            } else {
                System.out.println("Введите путь к файлу");
                scanner1.next();

            }
        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Введите шаг");
        while (stepbln) {
            if (scanner2.hasNextInt()) {
                step = scanner2.nextInt();
                if (step < 51 && step > -51) {
                    stepbln= false;
                } else {
                    System.out.println("Введите шаг");
                }
            } else {
                System.out.println("Введите шаг");
                scanner2.next();
            }
        }

        if (choice == 1) {
        Encryption.encryption(path,step);
        }if (choice==2){
            Encryption.decryption(path,step);
        }


    }

}


