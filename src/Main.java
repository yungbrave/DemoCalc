import java.util.Scanner;

import static calc.CalculatorUtils.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        String[] splitedExpressionBySpace = expression.split(" ");
        String operation = getOperationFromExpression(splitedExpressionBySpace);
        String operandFirst;
        String operandSecond;
        String result = "";
        String[] splitedExpressionBySign;
        switch (operation) {

            case PLUS: {
                splitedExpressionBySign = getOperandFromExpression(operation, expression);
                operandFirst = removeQuotes(splitedExpressionBySign[0]);
                operandSecond = removeQuotes(splitedExpressionBySign[1]);
                result = operandFirst + operandSecond;
                break;
            }
            case SUBTRACTION: {
                splitedExpressionBySign = getOperandFromExpression(operation, expression);
                operandFirst = removeQuotes(splitedExpressionBySign[0]);
                operandSecond = removeQuotes(splitedExpressionBySign[1]);
                result = operandFirst.replace(operandSecond, "");
                break;
            }
            case MULTIPLICATION: {
                splitedExpressionBySign = getOperandFromExpression(operation, expression);
                operandFirst = removeQuotes(splitedExpressionBySign[0]);
                operandSecond = splitedExpressionBySign[1].trim();
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
            case DIVISION: {
                splitedExpressionBySign = getOperandFromExpression(operation, expression);
                operandFirst = removeQuotes(splitedExpressionBySign[0]);
                operandSecond = splitedExpressionBySign[1].trim();
                int intValue = Integer.parseInt(operandSecond);
                result = getDivisionResult(intValue, operandFirst);
                break;
            }
        }
        System.out.println("\"" + getFinalResult(result) + "\"");
    }

}