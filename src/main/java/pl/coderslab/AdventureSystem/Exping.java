package pl.coderslab.AdventureSystem;

import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.UserHeroes;

public class Exping {
    public String WonEasyAdventure(UserHeroes userHeroes, ShortAdventureFoes shortAdventureFoes) {
        Long actualLevelCap = userHeroes.getLevel()*100;
        Long earnedExp = (shortAdventureFoes.getLevel()*25);
        Long exppointsAfterFight = userHeroes.getExperiencePoints()+earnedExp;
        userHeroes.setExperiencePoints(exppointsAfterFight);

        if(exppointsAfterFight>=actualLevelCap){

            userHeroes.setLevel(userHeroes.getLevel()+1);
            return "Your hero earned: "+earnedExp+" exp points and his level raised to " + userHeroes.getLevel();
        }
        return "Your hero earned:" + earnedExp;
    }
}
