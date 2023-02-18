package ua.ithillet.lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessWord {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", " pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        String wordRandom = selectedWordByRandom(words);

        do {
            System.out.println("\n" + "Input the world: ");
            Scanner scanner = new Scanner(System.in);
            String wordUser = scanner.nextLine();
            String result = playLogic(wordUser, wordRandom);
            if (wordUser.equalsIgnoreCase(wordRandom)) {
                System.out.println("\n" + "You are won! Congratulation!");
                break;
            }
        }
        while (true);
    }

    public static String playLogic(String wordUser, String wordRandom) {

        char[] array = new char[15];
        for (int i = 0; i < 15; i++) {
            array[i] = '#';
        }

        if (wordUser.length() >= wordRandom.length()) {
            for (int j = 0; j < wordRandom.length(); j++) {
                if (wordRandom.charAt(j) == wordUser.charAt(j)) {
                    array[j] = wordUser.charAt(j);
                }
            }

        } else if (wordUser.length() < wordRandom.length()) {
            for (int k = 0; k < wordUser.length(); k++) {
                if (wordUser.charAt(k) == wordRandom.charAt(k)) {
                    array[k] = wordUser.charAt(k);
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

        return Arrays.toString(array);
    }

    public static String selectedWordByRandom(String[] strArray) {
        Random random = new Random();
        int indexWord = random.nextInt(strArray.length);
        return strArray[indexWord];
    }
}

