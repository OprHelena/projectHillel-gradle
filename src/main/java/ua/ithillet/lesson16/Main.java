package ua.ithillet.lesson16;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/list of heroes.csv";
        List<Hero> heroList = StatisticsOfHeroes.readHeroCsv(path);
        System.out.println("The average height of heroes (excluding height <= 0): " + StatisticsOfHeroes.getAverageHeight(heroList));
        System.out.println("The name of the tallest hero: " + StatisticsOfHeroes.getTallestHeroName(heroList));
        System.out.println("The name of the heaviest hero: " + StatisticsOfHeroes.getHeaviestHeroName(heroList));
        System.out.println("The number of heroes by group: " + StatisticsOfHeroes.getNumberOfHeroesByGroup(heroList));
        System.out.println("The number of heroes by gender: " + StatisticsOfHeroes.getNumberOfHeroesByGender(heroList));
        System.out.println("The five most popular publishers: " + StatisticsOfHeroes.getFiveTheMostPopularPublishers(heroList));
        System.out.println("The three most common hair colors: " + StatisticsOfHeroes.getThreeMostCommonHairColors(heroList));
        System.out.println("The most common eye colors:" + StatisticsOfHeroes.getMostCommonEyeColor(heroList));
    }
}
