package ua.ithillet.lesson6;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class WorkWithListCollectionTest {

    @Test
    public void CheckCountOccurrenceMethod() {
        List<String> list = Arrays.asList("dilemma", "car", "disease", "health", "club", "car", "brook", "chariot",
                "cell", "justify", "century", "club", "brook", "stone", "suitcase", "legal", "car", "flee", "chariot",
                "expansive", "car", "desist", "sensation", "chariot", "aimless", "rash", "trigger", "javelin", "car",
                "exceed", "sensation", "car", "rash", "expansive", "mirage");
        assertEquals(6, WorkWithListCollection.countOccurrence(list, "car"));
    }

    @Test
    public void CheckToListMethod() {
        Integer[] list = {112, 5, 9, 7, 9, 11, 23, 45, 2};
        assertEquals(Arrays.stream(list).toList(), WorkWithListCollection.toList(list));
        assertThat(WorkWithListCollection.toList(list), containsInAnyOrder(Arrays.stream(list).toArray()));
    }

    @Test
    public void CheckUniqueDigitsMethod() {
        List<Integer> intList = new ArrayList<>(Arrays.asList(5, 9, 44, 55, 2, 1, 3, 6, 9, 111, 23, 9, 4, 1, 7, 4, 1, 8, 2, 46, 62, 100));
        List<Integer> uniqueList = new ArrayList<>(Arrays.asList(5, 9, 44, 55, 2, 1, 3, 6, 111, 23, 4, 7, 8, 46, 62, 100));
        assertEquals(uniqueList, WorkWithListCollection.findUnique(intList));
    }

    @Test
    public void CheckCalcOccurrenceMethod() {
        List<String> list = Arrays.asList("dilemma", "car", "rash", "health", "book", "car", "book", "chariot",
                "cell", "century", "book", "car", "car", "chariot", "car", "rash", "book", "car", "rash",
                "trigger", "car", "car", "rash");
        List<String> result = Arrays.asList("dilemma: 1", "car: 8", "rash: 4", "health: 1", "book: 4", "chariot: 2",
                "cell: 1", "century: 1", "trigger: 1");
        assertEquals(result, WorkWithListCollection.calcOccurrence(list));
    }

    @Test
    public void CheckFindOccurrenceMethod() {
        List<String> list = List.of("car", "rash", "health", "book", "car", "book", "chariot",
                "cell", "century", "book", "car", "car", "chariot", "car", "rash", "book", "car", "rash",
                "car", "car", "rash");
        List<String> resultList = List.of(Map.of("name", "car", "countOccurrance", "8").toString(),
                Map.of("name", "rash", "countOccurrance", "4").toString(),
                Map.of("name", "health", "countOccurrance", "1").toString(),
                Map.of("name", "book", "countOccurrance", "4").toString(),
                Map.of("name", "chariot", "countOccurrance", "2").toString(),
                Map.of("name", "cell", "countOccurrance", "1").toString(),
                Map.of("name", "century", "countOccurrance", "1").toString());

        assertEquals(WorkWithListCollection.findOccurrence(list), List.of(new WordOccurance("car", 8),new WordOccurance("rash", 4),
                new WordOccurance("health", 1), new WordOccurance("book", 4), new WordOccurance("chariot", 2),
                new WordOccurance("cell", 1), new WordOccurance("century", 1)));
    }
}
