package ua.ithillet.lesson6.phonebook;

import java.util.Objects;

public class RecordOnPhone {

    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public RecordOnPhone(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordOnPhone that = (RecordOnPhone) o;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
