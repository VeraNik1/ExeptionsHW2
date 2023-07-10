import java.util.Scanner;

public class FloatNumInput {
    public static void main(String[] args) {
        float userInput = floatInput();
        System.out.println("Вы ввели число: " + userInput);
    }

    public static float floatInput() {
        Scanner scanner = new Scanner(System.in);
        float num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число в формате 5,324 или 8.2: ");
            try {
                String input = scanner.nextLine().replace(',', '.');
                num = Float.parseFloat(input);

                // Проверяем, не является ли число целым
                if (num == (int) num) {
                    System.out.println("Введено целое число. Пожалуйста, введите дробное число.");
                    continue; // В случае, если введено целое число, повторно запрашиваем ввод
                }

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод дробного числа. Попробуйте еще раз.");
            }
        }

        return num;
    }
}