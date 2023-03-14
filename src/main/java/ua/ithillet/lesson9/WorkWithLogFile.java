package ua.ithillet.lesson9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkWithLogFile {
    private String path;

    public WorkWithLogFile(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String readTextFromFile(String path, String searchText, String date) {
        String line = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                if (line.contains(searchText) && line.contains(date)) {
                    return line;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public String getCurrentDate() {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return  LocalDate.now().format(myFormat);
    }
}
