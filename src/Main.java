import java.util.Scanner;

public class Main {
    static boolean isRun = true;
    static  Calculator calculator = new Calculator();

    public static void main(String[] args) throws Exception {
        while (isRun) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a expression: ");
            String num = in.nextLine();
            System.out.println(calc(num));
        }
    }

    public static String calc(String input) throws Exception{
        return calculator.setExpression(input);
    }
}
