package ua.ithillet.lesson7;

import java.util.stream.Collectors;
import java.util.*;


public class FileNavigator {

    private final Map<String, List<FileBox>> filesLibrary;

    public FileNavigator() {
        filesLibrary = new HashMap<>();
    }

    protected Map<String, List<FileBox>> getFilesLibrary() {
        return filesLibrary;
    }

    public void add(String pathAsKey, FileBox fileBox) {
        if (!fileBox.getPath().equals(pathAsKey)) {
            throw new InconsistencyFileException("Keys used as paths are not equal");
        }
        if (!filesLibrary.containsKey(pathAsKey)) {
            List<FileBox> fileBoxList = new ArrayList<>();
            filesLibrary.put(pathAsKey, fileBoxList);
            fileBoxList.add(fileBox);
        } else {
            filesLibrary.get(pathAsKey).add(fileBox);
        }
    }

    public List<FileBox> find(String pathAsKey) {
        return filesLibrary.get(pathAsKey);
    }

    public List<FileBox> filterBySize(Map<String, List<FileBox>> filesLibrary, long maxSize) {
        return filesLibrary.values().stream()
                .flatMap(Collection::stream)
                .filter(fileBox -> fileBox.getFileSize() <= maxSize)
                .collect(Collectors.toList());
    }

    public void remove(String pathAsKey) {
        filesLibrary.remove(pathAsKey);
    }

    public List<FileBox> sortBySize() {
        for (Map.Entry<String, List<FileBox>> entry : filesLibrary.entrySet()) {
            List<FileBox> fileBoxList = entry.getValue();
            Collections.sort(fileBoxList, (file1, file2) -> Long.compare(file1.getFileSize(), file2.getFileSize()));
        }
        return filesLibrary.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
