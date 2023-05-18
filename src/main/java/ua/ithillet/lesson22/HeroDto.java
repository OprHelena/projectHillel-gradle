package ua.ithillet.lesson22;

import java.util.List;

public class HeroDto {

    private String name;
    private List<String> movies;

    public HeroDto(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public List<String> getMovies() {
        return movies;
    }

    public static HeroDtoBuilder builder(){
        return new HeroDtoBuilder();
    }


}
