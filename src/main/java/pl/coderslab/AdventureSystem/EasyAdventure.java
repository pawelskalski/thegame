package pl.coderslab.AdventureSystem;

import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.UserHeroes;

public class EasyAdventure {
    public boolean fight(String foe, String hero) {
        if (foe.equalsIgnoreCase("knight")) {
            if (hero.equalsIgnoreCase("knight")) {
                return true;
            } else if (hero.equalsIgnoreCase("wizard")) {
                return true;
            } else {
                return false;
            }

        } else if (foe.equalsIgnoreCase("rogue")) {
            if (hero.equalsIgnoreCase("knight")) {
                return true;
            } else if (hero.equalsIgnoreCase("rogue")) {
                return true;
            } else {
                return false;
            }
        } else if (foe.equalsIgnoreCase("wizard")) {
            if (hero.equalsIgnoreCase("wizard")) {
                return true;
            } else if (hero.equalsIgnoreCase("rogue")) {
                return true;
            } else {
                return false;}
        } else {
            return false;
        }

    }
}
