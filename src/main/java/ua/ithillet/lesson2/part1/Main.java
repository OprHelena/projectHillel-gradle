package ua.ithillet.lesson2.part1;

import ua.ithillet.lesson2.part1.home.WorkFrom;

public class Main {

    public static void main(String[] args) {

        Employee franko = new Employee("Franko Ivan Yakovych", "sales manager", "franko.ivan@gmail.com", "+380674445566", 38);
        System.out.println(franko);

        System.out.println("\n" + "Car with Start method");
        Car workCar = new Car();
        workCar.start();

        System.out.println("\n" + "Two classes with the same name");
        WorkFrom home = new WorkFrom();
        home.workingHomeHours(8);
        ua.ithillet.lesson2.part1.work.WorkFrom work = new ua.ithillet.lesson2.part1.work.WorkFrom();
        work.workingHours(9, "work");

    }
}
