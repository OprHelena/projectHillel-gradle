package ua.ithillet.lesson17;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroLombokTest {

    HeroLombok heroLombok = new HeroLombok(731, "Yoda", "Male", "brown", "Yoda's species", "White", 66, "George Lucas", "green", "good", 17);

    @Test
    public void checkLombokAnnotation() {
        Assertions.assertEquals(17, heroLombok.getWeight());
    }


    HeroBuilder heroBuild1 = HeroBuilder.builder().name("Tor")
            .gender("Male")
            .weight(700)
            .publisher("Newspaper")
            .build();
    HeroBuilder heroBuild2 = heroBuild1.toBuilder().name("Fiona")
            .gender("Female")
            .weight(600)
            .publisher("Newspaper")
            .build();

    @Test
    public void checkBuilderAnnotation() {
        Assertions.assertNotEquals(heroBuild1.getGender(), heroBuild2.getGender());
        Assertions.assertEquals(600, heroBuild2.getWeight());
        Assertions.assertEquals(heroBuild1.getPublisher(), heroBuild2.getPublisher());
    }

    HeroValue hero1 = new HeroValue(731, "Yoda", "Male", "blue", "Yoda's species", "White", 66, "George Lucas", "green", "good", 17);
    HeroValue hero2 = new HeroValue(722, "Wonder Woman", "Female", "blue", "Amazon", "Black", 183, "DC Comics", "-", "good", 74);

    @Test
    public void checkValueAnnotation(){
       Assertions.assertEquals(hero1.getEyeColor(), hero2.getEyeColor());
       Assertions.assertNotEquals(hero1.getGender(), hero2.getGender());
    }

}
