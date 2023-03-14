package ua.ithillet.lesson12;

public class ImplementationGenericHillelList<T> implements GenericHillelList<T> {
    private T[] array;

    public ImplementationGenericHillelList(T[] initial) {
        array = initial;
    }

    public T[] getArray() {
        return array;
    }

    @Override
    public void add(T item) {
        T[] result = (T[]) new Object[array.length + 1];
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
    public T remove(int index) {
        if (array == null || index < 0 || index >= array.length) {
            throw new RuntimeException();
        }
        T[] removeResult = (T[]) new Object[array.length - 1];
        T removedVal = array[index];
        System.arraycopy(array, 0, removeResult, 0, index);
        System.arraycopy(array, index + 1, removeResult, index, array.length - index - 1);
        array = removeResult;
        return removedVal;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
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
    public T get(int index) {
        return array[index];
    }

    @Override
    public Object[] getAll() {
        return array;
    }
}
