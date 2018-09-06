package pl.coderslab.AdventureSystem;

import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.UserHeroes;

public class EasyAdventure {
    public boolean fight(ShortAdventureFoes foe, UserHeroes userHeroes) {
        String HeroClass = userHeroes.getHeroClass();
        if (foe.getFoeClass().equalsIgnoreCase("knight")) {
            if (HeroClass.equalsIgnoreCase("knight")) {
                return true;
            }
            if (HeroClass.equalsIgnoreCase("rogue")) {
                return false;
            }
            if (HeroClass.equalsIgnoreCase("wizard")) {
                return true;
            }
            return false;
        } else if (foe.getFoeClass().equalsIgnoreCase("rogue")) {
            if (HeroClass.equalsIgnoreCase("knight")) {
                return true;
            }
            if (HeroClass.equalsIgnoreCase("rogue")) {
                return true;
            }
            if (HeroClass.equalsIgnoreCase("wizard")) {
                return false;
            }
        } else if (foe.getFoeClass().equalsIgnoreCase("wizard")) {
            if (HeroClass.equalsIgnoreCase("knight")) {
                return false;
            }
            if (HeroClass.equalsIgnoreCase("rogue")) {
                return true;
            }
            if (HeroClass.equalsIgnoreCase("wizard")) {
                return true;
            }
            return false;
        } else {
            return false;
        }

        return false;
    }
}
