package ua.ithillet.lesson6.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Phonebook {
    private List<RecordOnPhone> recordOnPhoneList = new ArrayList<>();

    public List<RecordOnPhone> getRecordOnPhoneList() {
        return recordOnPhoneList;
    }

    public void add(RecordOnPhone recordOnPhone) {
        recordOnPhoneList.add(recordOnPhone);
    }

    public RecordOnPhone find(String name) {
        return recordOnPhoneList.stream().filter(el -> el.getName().equals(name)).findFirst().orElse(null);
    }

    public List<RecordOnPhone> findAll(String name) {
        return recordOnPhoneList.stream().filter(el -> el.getName().equals(name)).collect(Collectors.toList());
    }
}
