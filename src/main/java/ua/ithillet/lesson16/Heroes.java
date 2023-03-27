package ua.ithillet.lesson16;

public class Heroes {
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

    public Heroes(int id, String name, String gender, String eyeColor, String race, String hairColor,
                  double height, String publisher, String skinColor, String group, int weight) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.race = race;
        this.hairColor = hairColor;
        this.height = height;
        this.publisher = publisher;
        this.skinColor = skinColor;
        this.group = group;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public double getHeight() {
        return height;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGroup() {
        return group;
    }

    public int getWeight() {
        return weight;
    }

}
