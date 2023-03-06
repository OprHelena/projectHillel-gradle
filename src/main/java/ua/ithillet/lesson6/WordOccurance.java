package ua.ithillet.lesson6;

import java.util.Objects;

public class WordOccurance {

    private String name;
    public int countOccurrance;

    public WordOccurance(String name, int countOccurrance) {
        this.name = name;
        this.countOccurrance = countOccurrance;
    }

    @Override
    public String toString() {
        return "{" +
                "name=" + name +
                ", countOccurrance=" + countOccurrance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordOccurance that = (WordOccurance) o;
        return countOccurrance == that.countOccurrance && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, countOccurrance);
    }
}
