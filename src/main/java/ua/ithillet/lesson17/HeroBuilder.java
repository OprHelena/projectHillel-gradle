package ua.ithillet.lesson17;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class HeroBuilder {
    private int id;
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String group;
    private int weight;
}
