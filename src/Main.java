import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] splitedExpression = expression.split(" ");
        System.out.println(Arrays.toString(splitedExpression));
        String operandFirst = splitedExpression[0];
        String operandSecond = splitedExpression[2];
        String operation = splitedExpression[1];
        String result = "";
        switch (operation) {
            case "+":
                operandFirst = operandFirst.substring(1, operandFirst.length() - 1);
                operandSecond = operandSecond.substring(1, operandSecond.length() - 1);
                result = operandFirst + operandSecond;
                break;
            case "-": {
                operandFirst = operandFirst.substring(1, operandFirst.length() - 1);
                operandSecond = operandSecond.substring(1, operandSecond.length() - 1);
                result = operandFirst.replace(operandSecond, "");
                break;
            }
            case "*": {
                operandFirst = operandFirst.substring(1, operandFirst.length() - 1);
                int intValue = Integer.parseInt(operandSecond);
                if (intValue <= 10 && intValue > 0) {
                    for (int i = 0; i < intValue; i++) {
                        result = result + operandFirst;
                    }
                } else {
                    throw new Exception();
                }
                break;
            }
            case "/": {
                operandFirst = operandFirst.substring(1, operandFirst.length() - 1);
                int intValue = Integer.parseInt(operandSecond);
                if (intValue <= 10 && intValue > 0) {
                    int numberLength = operandFirst.length();
                    int newNumberLength = numberLength / intValue;
                    result = operandFirst.substring(0, newNumberLength);
                } else {
                    throw new Exception();
                }
                break;
            }
            default:
                throw new Exception();
        }
        if (result.length() > 40) {
            result = result.substring(0, 39);
            result = result + "...";
        }
        System.out.println("\"" + result + "\"");
    }
}