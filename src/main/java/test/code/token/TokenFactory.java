package test.code.token;

public class TokenFactory {

    public Token create(String value) {
        if (isInteger(value)) {
            return IntegerToken.of(value);
        } else if (isAdditionOperator(value)) {
            return new AdditionOperator();
        } else if (isSubtractionOperator(value)) {
            return new SubtractionOperator();
        } else if (isMultiplicationOperator(value)) {
            return new MultiplicationOperator();
        } else if (isDivisionOperator(value)) {
            return new DivisionOperator();
        } else if (isPowerOperator(value)) {
            return new PowerOperator();
        } else {
            throw new IllegalArgumentException("Cannot recognize token by value: " + value);
        }
    }

    private boolean isPowerOperator(String value) {
        return PowerOperator.TOKEN.equals(value);
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isAdditionOperator(String value) {
        return AdditionOperator.TOKEN.equals(value);
    }

    private boolean isSubtractionOperator(String value) {
        return SubtractionOperator.TOKEN.equals(value);
    }

    private boolean isMultiplicationOperator(String value) {
        return MultiplicationOperator.TOKEN.equals(value);
    }

    private boolean isDivisionOperator(String value) {
        return DivisionOperator.TOKEN.equals(value);
    }
}
