package pl.coderslab.AdventureSystem;

import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.UserHeroes;

public class Exping {

    public Long WonEasyAdventure(UserHeroes userHeroes, ShortAdventureFoes shortAdventureFoes) {
        //Long actualLevelCap = userHeroes.getLevel()*100;
        Long earnedExp = (shortAdventureFoes.getLevel()*25);
        //Long exppointsAfterFight = userHeroes.getExperiencePoints()+earnedExp;
        //userHeroes.setExperiencePoints(exppointsAfterFight);
        return earnedExp;
    }
}
