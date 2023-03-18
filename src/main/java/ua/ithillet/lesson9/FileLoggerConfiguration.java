package ua.ithillet.lesson9;

public class FileLoggerConfiguration {
    private String path;
    private LoggingLevel level;
    private long maxSize;

    public FileLoggerConfiguration(String path, LoggingLevel level, long maxSize) {
        this.path = path;
        this.level = level;
        this.maxSize = maxSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }
}
