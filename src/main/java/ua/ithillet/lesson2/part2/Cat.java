package ua.ithillet.lesson2.part2;

public class Cat extends Animals {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance < 200) {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat can not swim");
    }
}
