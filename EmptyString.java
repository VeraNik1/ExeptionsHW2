import java.util.Scanner;

public class EmptyString {
    public static void main(String[] args) {
        while (true){
        try {
            String userInput = getInput();
            System.out.println("Ввод пользователя: " + userInput);
            break;
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        }}
    }
    public static String getInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new Exception("Пустые строки вводить нельзя!");
        }
        return input;
    }
}