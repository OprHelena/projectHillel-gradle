package ua.ithillet.lesson2.part2;

public class Dog extends Animals {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance < 500) {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 10) {
            super.swim(distance);
        }
    }
}
