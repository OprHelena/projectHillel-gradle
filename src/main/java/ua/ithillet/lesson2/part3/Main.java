package ua.ithillet.lesson2.part3;

public class Main {
    public static void main(String[] args) {

        var square = new Square(5);
        var triangle = new Triangle(4, 6);
        var circle = new Circle(5.55);

        double[] figures = new double[3];
        figures[0] = square.getArea();
        figures[1] = triangle.getArea();
        figures[2] = circle.getArea();
        double sumArea = 0;
        for (int i = 0; i < figures.length; i++) {
            sumArea = sumArea + figures[i];
        }
        System.out.println("Area of all shapes = " + sumArea);
    }
}