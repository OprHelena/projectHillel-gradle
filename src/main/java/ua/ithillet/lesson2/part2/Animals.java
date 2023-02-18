package ua.ithillet.lesson2.part2;

public class Animals {

    private String name;

    public Animals(String name) {
        this.name = name;
    }

    public void run(int distance) {
        System.out.println(name + " ran " + distance + " meters");
    }

    public void swim(int distance) {
        System.out.println(name + " swam " + distance + " meters");
    }

}
