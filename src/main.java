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
        String decrypt = "Нажмите 1, чтобы зашифровать файл";
        String encrypt = "Нажмите 2, чтобы расшифровать файл";
        String bruteForce = "нажмите 3, чтобы взломать файл";
        String pathDist;
        Path dist = null;
        boolean distbln = true;


        Scanner scanner = new Scanner(System.in);

        System.out.println(decrypt);
        System.out.println(encrypt);
        System.out.println(bruteForce);
        while (b) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 4 && choice > 0) {
                    b = false;
                } else {
                    System.out.println(decrypt);
                    System.out.println(encrypt);
                    System.out.println(bruteForce);
                }
            } else {
                System.out.println(decrypt);
                System.out.println(encrypt);
                System.out.println(bruteForce);
                scanner.next();
            }
        }
        System.out.println("Выбираем файл с исходным текстом");
        Scanner scanner1 = new Scanner(System.in);
        while (sourcebln) {
            source = scanner1.nextLine();
            path = Path.of(source);
            if (Files.exists(path)) {
                sourcebln = false;
            } else {
                System.out.println("Такого файла не существует, попробуйте еще раз");
                scanner1.next();

            }
            if (choice == 3){
                BruteForce.bruteForce(path);
                System.exit(0);
            }
        }
        System.out.println("напишите адрес, куда положим получившийся файл");
        Scanner scanner3 = new Scanner(System.in);
            pathDist = scanner3.nextLine();
            dist = Path.of(pathDist);
            if(!Files.exists(dist)){
                try{
                    Files.createFile(dist);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        Scanner scanner2 = new Scanner(System.in);
        System.out.println("напишите ключ шифрования от -40 до 40");
        while (stepbln) {
            if (scanner2.hasNextInt()) {
                step = scanner2.nextInt();
                if (step < 41 && step > -42) {
                    stepbln= false;
                } else {
                    System.out.println("Ключ не соответсвует условию, попробуйте еще раз");
                }
            } else {
                System.out.println("Ключ не соответсвует условию, попробуйте еще раз ");
                scanner2.next();
            }
        }

        if (choice == 1) {
        Encryption.encryption(path,step,dist);
        }if (choice==2){
            Encryption.decryption(path,step,dist);
        }


    }

}


