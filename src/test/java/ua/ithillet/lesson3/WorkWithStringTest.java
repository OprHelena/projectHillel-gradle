package ua.ithillet.lesson3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkWithStringTest {

    WorkWithString workWithString = new WorkWithString();

    private final static String STRING_TO_BE_CHECK = "I don’t know. He’s vanished into thin air.";
    private final static String REVERSED_STRING = ".ria niht otni dehsinav s’eH .wonk t’nod I";
    private final static String WORD_TO_BE_FOUND = "know";
    private final static String PALINDROME = "Top spot";
    private final static char SYMBOL_TO_BE_FOUND = 'o';

    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    @Test
    void checkTheNumberOfOccurrencesOfASymbol() {
        assertEquals(3, workWithString.findSymbolOccurrence(STRING_TO_BE_CHECK, SYMBOL_TO_BE_FOUND), "The number of occurrences is not match");
    }

    @Test
    void checkWorldPosition() {
        assertEquals(8, workWithString.findWordPosition(STRING_TO_BE_CHECK, WORD_TO_BE_FOUND), "The word position is not correct");
    }

    @Test
    void theStringShouldBeReversed() {
        assertEquals(REVERSED_STRING, workWithString.stringReverse(STRING_TO_BE_CHECK), "The strings are not the same");
    }

    @Test
    void itIsAPalindromeCheck() {
        assertTrue(workWithString.isPalindrome(PALINDROME), "The sentence is not palindrome");
    }

}