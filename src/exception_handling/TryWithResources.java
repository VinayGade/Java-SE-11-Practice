package exception_handling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Java 9
public class TryWithResources {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        //Java 8
        /*
        try(BufferedReader bufferedReader = br) {
            System.out.println("Enter radius =");
            int radius = Integer.parseInt(bufferedReader.readLine());
            final float PI = 3.1414f;

            System.out.println("Circle area =" + PI * Math.pow(radius, 2));
        }
         */

        // Java 11
        try(br){    // Java 9
            System.out.println("Enter length :");
            var length = Integer.parseInt(br.readLine());
            System.out.println("Enter breadth :");
            var breadth = Integer.parseInt(br.readLine());

            System.out.println("Rectangle area ="+length * breadth);
        }

    }
}
