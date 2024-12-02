package basics;

public class AreaVar {
    public static void main(String[] args) {

        AreaVar a = new AreaVar();

        final var PI = 3.14f;    // val PI = 3.14   ... Scala

        // "val" is not a keyword in Java since "final var" satisfy the same purpose...

        var radius = 5;
        double area = a.areaCircle(radius, PI);
        System.out.println("Area of circle having "+radius+" radius = "+area);
    }

    private double areaCircle(int radius, float pi){
        return radius * Math.pow(pi,2);
    }
}
