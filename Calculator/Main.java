import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入第一個數字: ");
        int num1 = scanner.nextInt();

        System.out.print("請輸入運算符號 (+ - * /): ");
        String operator = scanner.next();

        System.out.print("請輸入第二個數字: ");
        int num2 = scanner.nextInt();

        try {
            Operation operation = OperationFactory.createOperator(operator);
            double result = operation.getResult(num1, num2);
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("錯誤: " + e.getMessage());
        }

        scanner.close();
    }
}
