package ua.ithillet.lesson22;

import ua.ithillet.lesson21.Hero;
import ua.ithillet.lesson21.HeroDao;

import java.util.List;

public class DummyHeroDao implements HeroDao {

    private final List<Hero> dataBase;

    public DummyHeroDao(List<Hero> dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Hero> findAll() {
        return dataBase;
    }

    @Override
    public List<Hero> findByName(String name) {
        return dataBase.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public void create(Hero hero) {
dataBase.add(hero);
    }

    @Override
    public void update(Hero hero) {
dataBase.set(Math.toIntExact(hero.getPublisherId()),hero);
    }

    @Override
    public boolean delete(Long id) {
        return dataBase.remove(dataBase.get(Math.toIntExact(id)));
    }

}
