package ua.ithillet.lesson2.part1;

public class Car {

    public Car() {
    }

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startFuelSystem() {
        System.out.println("fuel system is started");
    }

    private void startCommand() {
        System.out.println("start command allowed");
    }

    private void startElectricity() {
        System.out.println("process started");
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
