package pl.gerkeprojects.calcinjava.logic;

public class Main {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "X";
    private static final String DIVIDE = "/";

    public double calculate(double a, String operator, double b) {
        double result = 0;
        switch (operator){
            case PLUS:
                result = a + b;
                break;
            case MINUS:
                result = a - b;
                break;
            case MULTIPLY:
                result = a * b;
                break;
            case DIVIDE:
                if (b == 0)
                    throw new ArithmeticException();
                result = a / b;
                break;
        }
        return result;
    }
}
