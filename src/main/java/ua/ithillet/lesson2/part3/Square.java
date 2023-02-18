package ua.ithillet.lesson2.part3;

public class Square implements Figure {

    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(this.sideLength, 2);
    }
}
