package ua.ithillet.lesson21;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private long publisherId;
    private String skinColor;
    private String alignment;
    private int weight;
}
