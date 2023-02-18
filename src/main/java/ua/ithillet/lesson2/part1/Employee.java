package ua.ithillet.lesson2.part1;

public class Employee {

    private final String name;
    private final String position;
    private final String email;
    private final String phoneNumber;
    private final int age;

    public Employee(String name, String position, String email, String phoneNumber, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee data: " + '\n' +
                "- name " + name + "," + '\n' +
                "- his age " + age + " years old" + "," + '\n' +
                "- he works as a " + position + "," + '\n' +
                "- his email address " + email + "," + '\n' +
                "- his phoneNumber " + phoneNumber + ".";
    }
}
