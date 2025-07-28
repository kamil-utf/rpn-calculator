package test.code;

import test.code.rpn.RpnCalculator;

public class Main {
    public static void main(String[] args) {
        final var expression = args[0];
        System.out.println("Expression: " + expression);

        Calculator calculator = new RpnCalculator();

        try {
            final var result = calculator.calculate(expression);
            System.out.println("Result: " + result);
        } catch (InvalidExpressionException ex) {
            System.out.println("Provided expression is invalid due to: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Unexpected error while calculating expression: " + ex.toString());
        }
    }
}