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
        String decrypt = "������� 1, ����� �����������";
        String encrypt = "������� 2, ����� ������������";
        String bruteForce = "������� 3, ����� ��������";
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
        System.out.println("������� ���� � �����");
        Scanner scanner1 = new Scanner(System.in);
        while (sourcebln) {
            source = scanner1.nextLine();
            path = Path.of(source);
            if (Files.exists(path)) {
                sourcebln = false;
            } else {
                System.out.println("���� �� ������, ������� ���������� ����");
                scanner1.next();

            }
            if (choice == 3){
                BruteForce.bruteForce(path);
                System.exit(0);
            }
        }
        System.out.println("������� ���� � �����, � ������� ����� ������");
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
        System.out.println("������� ���� �� -30 �� 30");
        while (stepbln) {
            if (scanner2.hasNextInt()) {
                step = scanner2.nextInt();
                if (step < 51 && step > -51) {
                    stepbln= false;
                } else {
                    System.out.println("����� �� ������������ ��������, ������� ����");
                }
            } else {
                System.out.println("����� �� ������������ ��������, ������� ����  ");
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


