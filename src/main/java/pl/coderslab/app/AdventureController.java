package pl.coderslab.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.AdventureSystem.EasyAdventure;
import pl.coderslab.AdventureSystem.Exping;
import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.UserHeroes;
import pl.coderslab.Services.ShortAdventureFoesServices;
import pl.coderslab.Services.UserHeroesServices;
import pl.coderslab.Services.UserServices;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/adventures")
public class AdventureController {

    @Autowired
    private ShortAdventureFoesServices shortAdventureFoesServices;

    @Autowired
    private UserHeroesServices userHeroesServices;

    @Autowired
    private UserServices userServices;


    @ModelAttribute("allHeroesNames")
    public Collection<String> allHeroesNames() {
        return userServices.getAllHeroesNamesForUserId(new Long(1));
    }
    //TODO change id, let action geti it from session

    @ModelAttribute("urFoe")
    public String randomizedFoe() {
        Random r = new Random();
        List<ShortAdventureFoes> allFoes = shortAdventureFoesServices.findAllShortAdventureFoes();
        int randomInt = r.nextInt(allFoes.size());
        ShortAdventureFoes foe = allFoes.get(randomInt);
        return foe.getName();
    }

    @RequestMapping("/main")
    public String adventure() {

        return "adventureMain";
    }

    @GetMapping("/sendHero")
    public String sendHeroGet(Model model) {
        model.addAttribute("UserHeroes", new UserHeroes());
        model.addAttribute("ShortAdventureFoes", new ShortAdventureFoes());
        return "chooseHeroForAdventure";
    }

    @PostMapping("/sendHero")
    @ResponseBody
    public String sendHeroPost(@ModelAttribute UserHeroes userHeroes) {
        EasyAdventure adventure = new EasyAdventure();
        Exping exping = new Exping();
        UserHeroes hero = userHeroesServices.findHeroeByName(userHeroes.getName());
        ShortAdventureFoes foe = shortAdventureFoesServices.findShortAdventureFoesByName(randomizedFoe());
        if (adventure.fight(foe.getFoeClass(), hero.getHeroClass())) {
            Long levelcap = hero.getLevel()*100;
            Long earnedExp = exping.WonEasyAdventure(hero, foe);
            hero.setExperiencePoints(hero.getExperiencePoints()+earnedExp);
            if(hero.getExperiencePoints()>levelcap){
                hero.setLevel(hero.getLevel()+1);
                userHeroesServices.updateHero(hero);
                return hero.getName() + " won got promotet his current level is " + hero.getLevel();

            }else{
                userHeroesServices.updateHero(hero);

                return hero.getName() + " won and earned: " + earnedExp+ "experience points";
            }
        }
        return "Your hero lost";
    }
}




