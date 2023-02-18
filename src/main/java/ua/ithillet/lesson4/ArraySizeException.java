package ua.ithillet.lesson4;

public class ArraySizeException extends IndexOutOfBoundsException{
    public ArraySizeException() {
    }

    public ArraySizeException(String message) {
        super(message);
    }
}
