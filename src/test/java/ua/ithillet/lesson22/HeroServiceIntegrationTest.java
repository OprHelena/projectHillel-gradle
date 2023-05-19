package ua.ithillet.lesson22;

import org.junit.jupiter.api.Test;
import ua.ithillet.lesson21.Hero;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceIntegrationTest {
    private final HeroService target = HeroFabric.createDummyService(List.of(
            Hero.builder().name("Tor").build(),
            Hero.builder().name("Alf").build()));

    @Test
    void shouldReturnListOfHeroes() {
        var heroDtos = target.getHeroes();
        assertEquals(heroDtos.size(), 2);
    }
}
