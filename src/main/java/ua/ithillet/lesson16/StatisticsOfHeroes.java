package ua.ithillet.lesson16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

public class StatisticsOfHeroes {

    public static List<Heroes> readHeroCsv(String csvPath) {
        List<Heroes> heroesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String row;
            int rowNumber = 0;
            while ((row = br.readLine()) != null) {
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                String[] values = row.split(";");
                Heroes hero = new Heroes(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5],
                        parseDouble(values[6]),
                        values[7],
                        values[8],
                        values[9],
                        Integer.parseInt(values[10]));
                heroesList.add(hero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroesList;
    }

    public static double getAverageHeight(List<Heroes> heroList) {
        return heroList.stream()
                .filter(hero -> hero.getHeight() > 0)
                .mapToDouble(Heroes::getHeight)
                .average()
                .orElse(0);
    }

    public static String getTallestHeroName(List<Heroes> heroList) {
        return heroList.stream()
                .filter(hero -> hero.getHeight() > 0)
                .reduce((h1, h2) -> h1.getHeight() > h2.getHeight() ? h1 : h2)
                .map(Heroes::getName)
                .orElse("N/A");
    }

    public static String getHeaviestHeroName(List<Heroes> heroList) {
        return heroList.stream()
                .filter(hero -> hero.getWeight() > 0)
                .reduce((h1, h2) -> h1.getWeight() > h2.getWeight() ? h1 : h2)
                .map(Heroes::getName)
                .orElse("N/A");
    }

    public static Map<String, Long> getNumberOfHeroesByGender(List<Heroes> heroList) {
        return heroList.stream()
                .collect(Collectors.groupingBy(Heroes::getGender, Collectors.counting()));
    }

    public static Map<String, Long> getNumberOfHeroesByGroup(List<Heroes> heroList) {
        return heroList.stream()
                .collect(Collectors.groupingBy(Heroes::getGroup, Collectors.counting()));
    }

    public static List<String> getFiveTheMostPopularPublishers(List<Heroes> heroList) {
        return heroList.stream()
                .collect(Collectors.groupingBy(Heroes::getPublisher, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getThreeMostCommonHairColors(List<Heroes> heroList) {
        return heroList.stream()
                .filter(hero -> !hero.getHairColor().equalsIgnoreCase("null"))
                .collect(Collectors.groupingBy(Heroes::getHairColor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static String getMostCommonEyeColor(List<Heroes> heroList) {
        return heroList.stream()
                .filter(hero -> !hero.getEyeColor().equalsIgnoreCase("null"))
                .collect(Collectors.groupingBy(Heroes::getEyeColor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }
}
