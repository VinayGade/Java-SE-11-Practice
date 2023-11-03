package exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//try with resources
public class StackTraceTest {

    /**
     * Computes the factorial of a number * @param n a non-negative integer
     * @return n! = 1 * 2 * . . . * n
     */
    public static int factorial(int n){

        System.out.println("Factorial of ("+n+") =");
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);

        var r=1;
        if(n<=1)
            return r;
        else
            r = n * factorial(n-1);

        System.out.println("return "+r);
        return r;
    }

    public static void main(String[] args) {

        try(var in = new Scanner(System.in)){
            System.out.println("Enter n :");
            var n = in.nextInt();
            factorial(n);
        }

    }
}
