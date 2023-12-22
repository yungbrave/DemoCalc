import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] splitedExpression = expression.split("\"");
        String operandFirst = splitedExpression[1];
        String operandSecond = splitedExpression[3];
        String operation = splitedExpression[2].substring(1, 2);
        String result = "";
        switch (operation) {
            case "+":
                result = operandFirst + operandSecond;
                break;
            case "-": {
                result = operandFirst.replace(operandSecond, "");
                break;
            }
            case "*": {
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