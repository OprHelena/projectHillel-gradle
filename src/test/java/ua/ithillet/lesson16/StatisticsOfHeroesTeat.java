package ua.ithillet.lesson16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class StatisticsOfHeroesTeat {

    String path = "src/main/resources/list of heroes.csv";
    List<Heroes> heroList = StatisticsOfHeroes.readHeroCsv(path);

    @Test
    public void checkGetAverageHeightMethod() {
        Assertions.assertEquals(186.88081395348837, StatisticsOfHeroes.getAverageHeight(heroList));
    }

    @Test
    public void checkGetTallestHeroNameMethod() {
        Assertions.assertEquals("Fin Fang Foom", StatisticsOfHeroes.getTallestHeroName(heroList));
    }

    @Test
    public void checkGetHeaviestHeroNameMethod() {
        Assertions.assertEquals("Sasquatch", StatisticsOfHeroes.getHeaviestHeroName(heroList));
    }

    @Test
    public void checkGetNumberOfHeroesByGenderMethod() {
        Assertions.assertEquals(505, StatisticsOfHeroes.getNumberOfHeroesByGender(heroList).get("Male"));
        Assertions.assertEquals(200, StatisticsOfHeroes.getNumberOfHeroesByGender(heroList).get("Female"));
        Assertions.assertEquals(28, StatisticsOfHeroes.getNumberOfHeroesByGender(heroList).get("-"));
    }

    @Test
    public void checkGetNumberOfHeroesByGroupMethod() {
        Assertions.assertEquals(206, StatisticsOfHeroes.getNumberOfHeroesByGroup(heroList).get("bad"));
        Assertions.assertEquals(24, StatisticsOfHeroes.getNumberOfHeroesByGroup(heroList).get("neutral"));
        Assertions.assertEquals(496, StatisticsOfHeroes.getNumberOfHeroesByGroup(heroList).get("good"));
    }

    @Test
    public void checkGetFiveTheMostPopularPublishersMethod() {
        List<String> publishList = Arrays.asList("Marvel Comics", "DC Comics", "NBC - Heroes", "Dark Horse Comics", "George Lucas");
        assertThat(StatisticsOfHeroes.getFiveTheMostPopularPublishers(heroList), containsInAnyOrder(publishList.toArray()));
    }

    @Test
    public void checkGetThreeMostCommonHairColorsMethod() {
        List<String> hairColorList = Arrays.asList("Black", "Blond", "-");
        assertThat(StatisticsOfHeroes.getThreeMostCommonHairColors(heroList), containsInAnyOrder(hairColorList.toArray()));
    }

    @Test
    public void checkGetMostCommonEyeColorMethod() {
        Assertions.assertEquals("blue", StatisticsOfHeroes.getMostCommonEyeColor(heroList));

    }
}