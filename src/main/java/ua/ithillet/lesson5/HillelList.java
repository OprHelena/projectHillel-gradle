package ua.ithillet.lesson5;

public interface HillelList {

    void add(String item);

    String remove(int index);

    boolean contains(String item);

    int indexOf(String item);

    int size();

    String get(int index);

    String[] getAll();
}

