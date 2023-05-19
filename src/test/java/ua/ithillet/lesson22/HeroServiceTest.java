package ua.ithillet.lesson22;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.ithillet.lesson21.Hero;
import ua.ithillet.lesson21.HeroDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceTest {

    private HeroService target;

    @Test
    void checkHeroService() {
        var mockHeroDao = Mockito.mock(HeroDao.class);
        var mockHeroMovieService = Mockito.mock(HeroMovieService.class);
        target = new HeroService((HeroDao) mockHeroDao, mockHeroMovieService);

        Mockito.when(((HeroDao) mockHeroDao).findAll()).thenReturn(List.of(
                Hero.builder().name("Tor").build(),
                Hero.builder().name("Halk").build()));

        assertEquals(target.getHeroes().size(), 2);
    }
}
