package ua.ithillet.lesson2.part3;

public class Triangle implements Figure {

    private final double height;
    private final double lengthOfTheBase;

    public Triangle(double height, double lengthOfTheBase) {
        this.height = height;
        this.lengthOfTheBase = lengthOfTheBase;
    }

    @Override
    public double getArea() {
        return 0.5 * lengthOfTheBase * height;
    }
}
