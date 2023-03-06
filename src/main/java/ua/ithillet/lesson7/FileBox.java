package ua.ithillet.lesson7;

public class FileBox {

    private String path;
    private String fileName;
    private long fileSize;

    public FileBox(String path, String fileName, long fileSize) {
        this.path = path;
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getPath() {
        return path;
    }
}
