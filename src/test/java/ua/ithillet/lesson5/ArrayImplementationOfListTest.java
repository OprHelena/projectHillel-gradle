package ua.ithillet.lesson5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayImplementationOfListTest {

    @Test
    public void CheckGetAllMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        var arrayImplementationOfList = new ArrayImplementationOfList(arrayWords);
        assertTrue(Arrays.equals(arrayImplementationOfList.getAll(), arrayWords));
    }

    @Test
    public void CheckAddMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        String[] arrayAddWord = {"have", "be", "bear", "lose", "mean", "bite"};
        var arrayImplementationOfList = new ArrayImplementationOfList(arrayWords);
        arrayImplementationOfList.add("bite");
        assertTrue(Arrays.equals(arrayImplementationOfList.getArray(), arrayAddWord));
    }

    @Test
    public void CheckContainsMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        var arrayImplementationOfList = new ArrayImplementationOfList(arrayWords);
        assertTrue(arrayImplementationOfList.contains("be"));
    }

    @Test
    public void CheckIndexOfMethod() {
        String[] array = new String[0];
        var arrayImplementationOfList = new ArrayImplementationOfList(array);
        arrayImplementationOfList.add("one");
        arrayImplementationOfList.add("two");
        assertEquals(0, arrayImplementationOfList.indexOf("two"));
        assertEquals(0, arrayImplementationOfList.indexOf("one"));
        assertEquals(-1, arrayImplementationOfList.indexOf("three"));
    }

    @Test
    public void CheckSizeMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        var arrayImplementationOfList = new ArrayImplementationOfList(arrayWords);
        assertEquals(5, arrayImplementationOfList.size());
    }

    @Test
    public void CheckGetMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        var arrayImplementationOfList = new ArrayImplementationOfList(arrayWords);
        assertEquals("lose", arrayImplementationOfList.get(3));
    }

    @Test
    public void CheckRemoveMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        String[] checkRemoveItem = {"have", "be", "lose", "mean"};
        var arrayImplementationOfList = new ArrayImplementationOfList(arrayWords);
        assertEquals("bear", arrayImplementationOfList.remove(2));
        assertTrue(Arrays.equals(arrayImplementationOfList.getArray(), checkRemoveItem));
    }
}