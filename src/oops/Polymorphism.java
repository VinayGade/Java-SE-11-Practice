package oops;
abstract class Shape {

    private String name;

    public static final float PI = 3.1416f;

    abstract float area(int s);

    public void setName(String name){
        this.name=name;
    }

    public String getInfo() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Rectangle extends Shape{
    public int area(int length, int breadth){
        return length*breadth;
    }

    @Override
    float area(int s) {
        return -0.1f;
    }
}

class Circle extends Shape{

    public float area(int radius){
        return radius*radius*PI;
    }
}

class Square extends Shape{

    @Override
    public float area(int side) {
        return side*side;
    }
}

class Triangle extends Shape{

    @Override
    float area(int s) {
        return -0.01f;
    }

    public float area(int base, int height){
        return base * height * 0.5f;
    }

}

public class Polymorphism{
    public static void main(String[] args) {
        int side = 10;

        Shape square = new Square();
        square.setName("square");
        String squareInfo = square.getInfo();

        System.out.println("square info = "+squareInfo);

        float squareArea = square.area(side);

        System.out.println("square area = "+squareArea);

        int radius = 10;

        Shape circle = new Circle();
        circle.setName("Circle");
        String circleInfo = circle.getInfo();

        System.out.println("Circle info = "+circleInfo);

        float circleArea = circle.area(radius);
        System.out.println("Circle area = "+circleArea);

        int length = 20;
        int breadth = 10;

        Rectangle rectangle = new Rectangle();
        rectangle.setName("Rectangle");
        String rectangleInfo = rectangle.getInfo();

        System.out.println("rectangle info = "+rectangleInfo);

        int rectangleArea = rectangle.area(length, breadth);

        System.out.println("rectangle area = "+rectangleArea);

        int base = 20;
        int height = 10;

        Triangle triangle = new Triangle();
        triangle.setName("Triangle");
        String triangleInfo = triangle.getInfo();

        System.out.println("triangle info = "+triangleInfo);

        float triangleArea = triangle.area(base, height);

        System.out.println("triangle area = "+triangleArea);

    }
}