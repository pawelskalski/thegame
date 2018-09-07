package pl.coderslab.AdventureSystem;

import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.UserHeroes;

public class Exping {

    public Long WonEasyAdventure(UserHeroes userHeroes, ShortAdventureFoes shortAdventureFoes) {
        Long earnedExp = (shortAdventureFoes.getLevel()*25);
        return earnedExp;
    }
}
