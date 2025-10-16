public class Div extends Operation {
    @Override
    public double getResult(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("除數不可為 0");
        }
        return (double) num1 / num2;
    }
}
