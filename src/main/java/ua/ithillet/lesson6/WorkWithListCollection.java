package ua.ithillet.lesson6;

import java.util.*;

public class WorkWithListCollection {

    public static int countOccurrence(List<String> list, String searchItem) {
        int count = 0;
        for (String item : list) {
            if (item.equals(searchItem)) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> toList(Integer[] list) {
        List<Integer> targetList = new ArrayList<>(List.of(list));
        return targetList;

    }

    public static List<Integer> findUnique(List<Integer> list) {
        List<Integer> uniqueList = new ArrayList<>();
        try {
            for (Integer i : list) {
                    if (!uniqueList.contains(i)) {
                        uniqueList.add(i);
                    }
            }
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        return uniqueList;
    }

    public static List<String> calcOccurrence(List<String> list) {
        List<String> countUniqueWords = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String str : list) {
            int count = countOccurrence(list, str);
            while (!countUniqueWords.contains(str)) {
                result.add(str + ": " + count);
                countUniqueWords.add(str);
                break;
            }
        }
        return result;
    }

    public static List<WordOccurance> findOccurrence(List<String> list) {
        List<WordOccurance> result = new ArrayList<>();
        List<String> processed = new ArrayList<>();
        for (String word : list) {
            if (!processed.contains(word)) {
                result.add(new WordOccurance(word, countOccurrence(list, word)));
                processed.add(word);
            }
        }
        return result;
    }
}
