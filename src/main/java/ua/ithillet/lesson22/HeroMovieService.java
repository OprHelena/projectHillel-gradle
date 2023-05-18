package ua.ithillet.lesson22;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroMovieService {

    List<String> moviesList = new ArrayList<>();

    public List<String> getPlayedIn(String heroName) {
      return  moviesList.stream()
                .filter(film -> {
                    int matchingLettersCount = 0;
                    for (char c : heroName.toCharArray()) {
                        if (film.contains(Character.toString(c))) {
                            matchingLettersCount++;
                        }
                    }
                    return matchingLettersCount >= 2;
                })
                .collect(Collectors.toList());
    }

}
