package ua.ithillet.lesson5;

public class ArrayImplementationOfList implements HillelList {

    private String[] array;

    public ArrayImplementationOfList(String[] initial) {
        array = initial;
    }

    public String[] getArray() {
        return array;
    }

    @Override
    public void add(String item) {
        String[] result = new String[array.length + 1];
        if (array.length == 0) {
            result[array.length] = item;
        }
        if (array.length > 0) {
            System.arraycopy(array, 0, result, 0, array.length);
            result[array.length] = item;
        }
        array = result;
    }

    @Override
    public String remove(int index) {
        if (array == null || index < 0 || index >= array.length) {
            throw new RuntimeException();
        }
        String[] removeResult = new String[array.length - 1];
        String removedVal = array[index];
        System.arraycopy(array, 0, removeResult, 0, index);
        System.arraycopy(array, index + 1, removeResult, index, array.length - index - 1);
        array = removeResult;
        return removedVal;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(item)) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public String[] getAll() {
        String[] newArray = new String[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
