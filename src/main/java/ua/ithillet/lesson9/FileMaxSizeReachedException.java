package ua.ithillet.lesson9;

public class FileMaxSizeReachedException extends RuntimeException {

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
