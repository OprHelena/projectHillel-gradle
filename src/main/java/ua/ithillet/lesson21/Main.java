package ua.ithillet.lesson21;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {

        var dataSource = dataSource();
        var service = HeroFactory.createService(dataSource);

        service.findAll().stream().forEach(System.out::println);

        service.create(Hero.builder()
                .name("Helen")
                .gender("Female")
                .eyeColor("black")
                .race("Yoda")
                .hairColor("Grey")
                .height(100)
                .publisherId(19)
                .skinColor("green")
                .alignment("neutral")
                .weight(100)
                .build());

        service.update(Hero.builder().eyeColor("blue").name("Helen").build());

        service.delete(737L);

    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }
}

