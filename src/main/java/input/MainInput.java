package input;

import java.util.Scanner;

public class MainInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = 0;
        int numberTwo = 0;

        System.out.println("Введите 1-ое слогаемое (целое число): ");
        if (scanner.hasNextInt()) {
            numberOne = scanner.nextInt();
        }

        System.out.println("Введите 2-ое слогаемое (целое число): ");
        if (scanner.hasNextInt()) {
            numberTwo = scanner.nextInt();
        }

        System.out.println("Сумма двух чисел: " + (numberOne + numberTwo));
    }
}
