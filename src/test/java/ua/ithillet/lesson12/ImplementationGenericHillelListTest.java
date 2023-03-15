package ua.ithillet.lesson12;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementationGenericHillelListTest {

    @Test
    public void CheckGetAllMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(arrayWords);
        assertTrue(Arrays.equals(implementationGeneric.getAll(), arrayWords));
    }

    @Test
    public void CheckAddMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        String[] arrayAddWord = {"have", "be", "bear", "lose", "mean", "bite"};
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(arrayWords);
        implementationGeneric.add("bite");
        assertTrue(Arrays.equals(implementationGeneric.getArray(), arrayAddWord));
    }

    @Test
    public void CheckContainsMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(arrayWords);
        assertTrue(implementationGeneric.contains("be"));
    }

    @Test
    public void CheckIndexOfMethod() {
        String[] array = new String[0];
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(array);
        implementationGeneric.add("one");
        implementationGeneric.add("two");
        assertEquals(0, implementationGeneric.indexOf("two"));
        assertEquals(0, implementationGeneric.indexOf("one"));
        assertEquals(-1, implementationGeneric.indexOf("three"));
    }

    @Test
    public void CheckSizeMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(arrayWords);
        assertEquals(5, implementationGeneric.size());
    }

    @Test
    public void CheckGetMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(arrayWords);
        assertEquals("lose", implementationGeneric.get(3));
    }

    @Test
    public void CheckRemoveMethod() {
        String[] arrayWords = {"have", "be", "bear", "lose", "mean"};
        String[] checkRemoveItem = {"have", "be", "lose", "mean"};
        ImplementationGenericHillelList implementationGeneric = new ImplementationGenericHillelList(arrayWords);
        assertEquals("bear", implementationGeneric.remove(2));
        assertTrue(Arrays.equals(implementationGeneric.getArray(), checkRemoveItem));
    }
}
