package ua.ithillet.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class FileNavigatorTest {

    FileNavigator fileNavigator = new FileNavigator();

    private final static FileBox FILE1 = new FileBox("src/test_files/pictures", "file1.jpg", 955);
    private final static FileBox FILE2 = new FileBox("src/test_files/pictures", "file2.jpg", 2560);
    private final static FileBox FILE3 = new FileBox("src/test_files/pictures", "file3.jpg", 1560);
    private final static FileBox FILE4 = new FileBox("src/test_files/textFiles", "file4.txt", 150);
    private final static FileBox FILE5 = new FileBox("src/test_files/textFiles", "file5.txt", 200);
    private final static FileBox FALSE_PATH = new FileBox("src/test_path", "file6.txt", 1000);


    @Test
    public void checkAddMethod() {
        fileNavigator.add("src/test_files/pictures", FILE1);
        fileNavigator.add("src/test_files/pictures", FILE2);
        fileNavigator.add("src/test_files/textFiles", FILE4);
        assertThat(fileNavigator.getFilesLibrary().size(), equalTo(2));
    }

    @Test
    public void checkAddMethodWithException() throws InconsistencyFileException {
        fileNavigator.add("src/test_files/pictures", FILE1);
        assertThrows(InconsistencyFileException.class, () -> fileNavigator.add("src/test_files/pictures", FALSE_PATH));
    }

    @Test
    public void checkFindMethod() {
        fileNavigator.add("src/test_files/pictures", FILE1);
        fileNavigator.add("src/test_files/pictures", FILE2);
        fileNavigator.add("src/test_files/pictures", FILE3);
        fileNavigator.add("src/test_files/textFiles", FILE4);
        fileNavigator.add("src/test_files/textFiles", FILE5);
        Assertions.assertEquals(2, fileNavigator.find("src/test_files/textFiles").size());
        Assertions.assertEquals(3, fileNavigator.find("src/test_files/pictures").size());
        Assertions.assertTrue(fileNavigator.find("src/test_files/pictures").contains(FILE3));
        Assertions.assertFalse(fileNavigator.find("src/test_files/pictures").contains(FILE4));
    }

    @Test
    public void checkRemoveMethod() {
        fileNavigator.add("src/test_files/pictures", FILE1);
        fileNavigator.add("src/test_files/pictures", FILE2);
        fileNavigator.add("src/test_files/pictures", FILE3);
        fileNavigator.add("src/test_files/textFiles", FILE4);
        fileNavigator.add("src/test_files/textFiles", FILE5);
        fileNavigator.remove("src/test_files/pictures");
        Assertions.assertFalse(fileNavigator.getFilesLibrary().containsKey("src/test_files/pictures"));
    }

    @Test
    public void checkFilterBySizeMethod() {
        fileNavigator.add("src/test_files/pictures", FILE1);
        fileNavigator.add("src/test_files/pictures", FILE2);
        fileNavigator.add("src/test_files/pictures", FILE3);
        fileNavigator.add("src/test_files/textFiles", FILE4);
        fileNavigator.add("src/test_files/textFiles", FILE5);

        List<FileBox> filterOfFiles = fileNavigator.filterBySize(fileNavigator.getFilesLibrary(), 1650);
        assertEquals(4, filterOfFiles.size());
        List<FileBox> filterOfFiles1 = fileNavigator.filterBySize(fileNavigator.getFilesLibrary(), 150);
        assertEquals(1, filterOfFiles1.size());
    }

    @Test
    public void checkSortBySizeMethod() {
        fileNavigator.add("src/test_files/pictures", FILE1);
        fileNavigator.add("src/test_files/pictures", FILE2);
        fileNavigator.add("src/test_files/pictures", FILE3);
        fileNavigator.add("src/test_files/textFiles", FILE4);
        fileNavigator.add("src/test_files/textFiles", FILE5);

        List<FileBox> sortedFiles = fileNavigator.sortBySize();
        fileNavigator.sortBySize();
        assertEquals(FILE4, sortedFiles.get(0));
        assertEquals(FILE2, sortedFiles.get(4));
    }
}

