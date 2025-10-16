public class OperationFactory {
    public static Operation createOperator(String operator) {
        switch (operator) {
            case "+":
                return new Add();
            case "-":
                return new Sub();
            case "*":
                return new Mul();
            case "/":
                return new Div();
            default:
                throw new IllegalArgumentException("不支援的運算符號: " + operator);
        }
    }
}
