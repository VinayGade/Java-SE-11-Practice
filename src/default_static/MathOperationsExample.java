package default_static;

import beans.inrerfaces.Calculator;

public class MathOperationsExample implements Calculator {

    public static void main(String[] args) {
        MathOperationsExample mathOperationsExample = new MathOperationsExample();
        System.out.println("Sum: " + mathOperationsExample.sum(2,4));

        //our implementation using lambda expression for sum and divide
        Calculator calculator = (num1, num2) -> num1%num2;
        System.out.println("Calculator sum override using lambda " + calculator.sum(3,2));

        System.out.println("Subtract: " + mathOperationsExample.subtract(4,2));
        System.out.println("Multiply: " + mathOperationsExample.multiply(14,2));

        System.out.println("Divide: " + Calculator.divide(24,3));
    }


    @Override
    public int sum(int num1, int num2) {
       return num1 + num2;
    }

}
