public class AdvanceMath {
    private BasicMath basicMath;

    public double multiplyDifferenceBy5(double input1, double input2) {
//        double sum = basicMath.subtract(input1, input2);
//        return sum * 5;
        return basicMath.subtract(input1, input2) * 5;
    }

    public double multiplySumBy5(double input1, double input2) {
//        double sum = basicMath.add(input1, input2);
//        return sum * 5;
        return basicMath.multiply(basicMath.add(input1, input2), 5);
    }

    public double squareOfSum(double input1, double input2){
//        double sum = basicMath.add(input1, input2);
//        return sum * sum;
        return basicMath.add(input1, input2) * basicMath.add(input1, input2);

    }

    public double getPercentage(double input1, double input2){
        return basicMath.divide(input1, input2) * 100;
    }
}
