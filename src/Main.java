import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число №1:");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите число №2:");
        int number2 = new Scanner(System.in).nextInt();
        double quotient = (double) number1 / number2;
        System.out.println("Сумма этих чисел равна: " + (number1 + number2));
        System.out.println("Разность этих чисел равна: " + (number1 - number2));
        System.out.println("Произведение этих чисел равно: " + (number1 * number2));
        System.out.println("Частное этих чисел равно: " + quotient);
    }
}
