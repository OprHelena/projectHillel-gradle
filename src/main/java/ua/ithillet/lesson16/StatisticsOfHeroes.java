package ua.ithillet.lesson16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;

public class StatisticsOfHeroes {

    public static List<Hero> readHeroCsv(String csvPath) {
        List<Hero> heroesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String row;
            int rowNumber = 0;
            while ((row = br.readLine()) != null) {
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                String[] values = row.split(";");
                Hero hero = new Hero(
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

    public static double getAverageHeight(List<Hero> heroList) {
        return heroList.stream()
                .filter(hero -> hero.getHeight() > 0)
                .mapToDouble(Hero::getHeight)
                .average()
                .orElse(0);
    }

    public static String getTallestHeroName(List<Hero> heroList) {
        return heroList.stream()
                .filter(hero -> hero.getHeight() > 0)
                .reduce((h1, h2) -> h1.getHeight() > h2.getHeight() ? h1 : h2)
                .map(Hero::getName)
                .orElse("N/A");
    }

    public static String getHeaviestHeroName(List<Hero> heroList) {
        return heroList.stream()
                .filter(hero -> hero.getWeight() > 0)
                .reduce((h1, h2) -> h1.getWeight() > h2.getWeight() ? h1 : h2)
                .map(Hero::getName)
                .orElse("N/A");
    }

    public static Map<String, Long> getNumberOfHeroesByGender(List<Hero> heroList) {
        return heroList.stream()
                .collect(Collectors.groupingBy(Hero::getGender, Collectors.counting()));
    }

    public static Map<String, Long> getNumberOfHeroesByGroup(List<Hero> heroList) {
        return heroList.stream()
                .collect(Collectors.groupingBy(Hero::getGroup, Collectors.counting()));
    }

    public static List<String> getFiveTheMostPopularPublishers(List<Hero> heroList) {
        return heroList.stream()
                .collect(Collectors.groupingBy(Hero::getPublisher, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getThreeMostCommonHairColors(List<Hero> heroList) {
        return heroList.stream()
                .filter(hero -> !hero.getHairColor().equalsIgnoreCase("null"))
                .collect(Collectors.groupingBy(Hero::getHairColor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static String getMostCommonEyeColor(List<Hero> heroList) {
        return heroList.stream()
                .filter(hero -> !hero.getEyeColor().equalsIgnoreCase("null"))
                .collect(Collectors.groupingBy(Hero::getEyeColor, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }
}
