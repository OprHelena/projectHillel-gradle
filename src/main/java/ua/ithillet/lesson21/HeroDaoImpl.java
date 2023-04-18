package ua.ithillet.lesson21;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class HeroDaoImpl implements HeroDao {
    private final DataSource dataSource;

    @Override
    public List<Hero> findAll() {
        var sql = "select * from heroes_adv order by id";
        try (
                var connection = dataSource.getConnection();
                var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Hero> mapHeroes(ResultSet result) throws SQLException {
        var heroList = new ArrayList<Hero>();
        while (result.next()) {
            heroList.add(Hero.builder()
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eyeColor(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hairColor(result.getString("hair_color"))
                    .height(result.getDouble("height"))
                    .publisherId(result.getLong("publisher_id"))
                    .skinColor(result.getString("skin_color"))
                    .alignment(result.getString("alignment"))
                    .weight(result.getInt("weight"))
                    .build());
        }
        return heroList;
    }

    @Override
    public List<Hero> findByName(String name) {
        return null;
    }

    @Override
    public void create(Hero hero) {
        String temp = "'" + hero.getName() + "', " + "'" + hero.getGender() + "', " + "'" + hero.getEyeColor() + "', " + "'" + hero.getRace() + "', "
                + "'" + hero.getHairColor() + "', " + hero.getHeight() + ", " + hero.getPublisherId() + ", " + "'" + hero.getSkinColor() + "', " + "'" +
                hero.getAlignment() + "', " + hero.getWeight();
        var sql = "insert into heroes_adv (name, gender, eye_color, race, hair_color, height, publisher_id, skin_color, alignment, weight) values (" + temp + ")";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes_adv set eye_color = '" + hero.getEyeColor() + "' where name = '" + hero.getName() + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean delete(Long idVal) {
        var sql = "delete from heroes_adv where id = '" + idVal + "'";
        try (
                var connection = dataSource.getConnection();
                var statement = connection.createStatement()) {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
