package ua.ithillet.lesson21;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HeroService {
    private final HeroDao dao;

    public List<HeroDto> findAll() {
        return dao.findAll().stream().map(HeroDto::from).toList();
    }

    public List<HeroDto> findByName(String name) {
        return dao.findByName(name).stream().map(HeroDto::from).toList();
    }

    public void create(Hero hero) {
        dao.create(hero);
    }

    public void update(Hero hero) {
        dao.update(hero);
    }

    public boolean delete(Long id){
        return dao.delete(id);
    }

}
