package ua.ithillet.lesson6;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ua.ithillet.lesson6.phonebook.Phonebook;
import ua.ithillet.lesson6.phonebook.RecordOnPhone;

public class PhoneBookTest {

    @Test
    public void checkAddMethod() {
        RecordOnPhone recordOnPhone1 = new RecordOnPhone("Petro", "775677");
        Phonebook phonebook = new Phonebook();
        phonebook.add(recordOnPhone1);
        assertEquals(phonebook.getRecordOnPhoneList().size(), 1);
        RecordOnPhone recordOnPhone2 = new RecordOnPhone("Mykola", "898989");
        RecordOnPhone recordOnPhone3 = new RecordOnPhone("Daryna", "5656565");
        phonebook.add(recordOnPhone2);
        phonebook.add(recordOnPhone3);
        assertEquals(phonebook.getRecordOnPhoneList().size(), 3);
    }

    @Test
    public void checkFindMethod() {
        RecordOnPhone recordOnPhone1 = new RecordOnPhone("Petro", "775677");
        Phonebook phonebook = new Phonebook();
        phonebook.add(recordOnPhone1);
        assertTrue(phonebook.getRecordOnPhoneList().contains(phonebook.find("Petro")));
        assertThat(phonebook.find("Mario"), is(nullValue()));
    }

    @Test
    public void checkFindAllMethod() {
        Phonebook phonebook = new Phonebook();
        RecordOnPhone recordOnPhone1 = new RecordOnPhone("Petro", "775677");
        RecordOnPhone recordOnPhone2 = new RecordOnPhone("Mykola", "5656565");
        RecordOnPhone recordOnPhone3 = new RecordOnPhone("Mykola", "898989");
        RecordOnPhone recordOnPhone4 = new RecordOnPhone("Olena", "787878");
        RecordOnPhone recordOnPhone5 = new RecordOnPhone("Mykola", "898989");
        RecordOnPhone recordOnPhone6 = new RecordOnPhone("Danylo", "565565");
        phonebook.add(recordOnPhone1);
        phonebook.add(recordOnPhone2);
        phonebook.add(recordOnPhone3);
        phonebook.add(recordOnPhone4);
        phonebook.add(recordOnPhone5);
        phonebook.add(recordOnPhone6);
        assertEquals(phonebook.findAll("Mykola").size(), 3);
        assertEquals(phonebook.findAll("Olena").size(), 1);
        assertEquals(phonebook.findAll("Mario").size(), 0);
    }

}
