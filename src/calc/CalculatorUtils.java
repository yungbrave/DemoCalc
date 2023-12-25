package calc;

public class CalculatorUtils {

    public static final String SUBTRACTION = "-";
    public static final String PLUS = "+";
    public static final String MULTIPLICATION = "*";
    public static final String DIVISION = "/";

    public static String[] getOperandFromExpression(String operation, String expression) throws Exception {
        String[] resultExpression = null;
        switch (operation) {
            case PLUS -> {
                String regexOperation = operation.replaceAll("\\+", "\\\\+");
                resultExpression = expression.split(regexOperation);
            }
            case MULTIPLICATION -> {
                String regexOperation = operation.replaceAll("\\*", "\\\\*");
                resultExpression = expression.split(regexOperation);
            }
            case SUBTRACTION, DIVISION -> resultExpression = expression.split(" " + operation + " ");
            default -> throw new Exception();
        }
        return resultExpression;
    }

    public static String getDivisionResult(int intOperand, String operandFirst) throws Exception {
        if (intOperand <= 10 && intOperand > 0) {
            int numberLength = operandFirst.length();
            int newNumberLength = numberLength / intOperand;
            return operandFirst.substring(0, newNumberLength);
        } else {
            throw new Exception();
        }
    }

    public static String getFinalResult(String result) {
        if (result.length() > 40) {
            result = result.substring(0, 39);
            return result + "...";
        }
        return result;
    }

    public static String getOperationFromExpression(String[] expression) throws Exception {
        String operation = null;
        for (String s : expression) {
            if (s.equals(PLUS) || s.equals(SUBTRACTION) || s.equals(MULTIPLICATION) || s.equals(DIVISION)) {
                operation = s;
            }
        }
        if (operation == null) {
            throw new Exception();
        }
        return operation;
    }

}
