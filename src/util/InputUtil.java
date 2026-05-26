package util;

import java.util.Scanner;

public class InputUtil {

    public static int lerInteiro(Scanner scanner) {

        while (!scanner.hasNextInt()) {

            System.out.println("Digite apenas números.");
            scanner.nextLine();
        }

        int numero = scanner.nextInt();
        scanner.nextLine();

        return numero;
    }
}