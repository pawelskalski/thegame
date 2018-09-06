package pl.coderslab.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Entity.ShortAdventureFoes;
import pl.coderslab.Entity.User;
import pl.coderslab.Entity.UserHeroes;
import pl.coderslab.Services.ShortAdventureFoesServices;
import pl.coderslab.Services.UserHeroesServices;
import pl.coderslab.Services.UserServices;

import java.util.Random;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private UserHeroesServices userHeroesServices;
    @Autowired
    private ShortAdventureFoesServices shortAdventureFoesServices;

    @RequestMapping("/main")
    private String showHome(){
        return "home";
    }
    @GetMapping("/add")
    private String addUserGet(Model model){
        Random r = new Random();
        int randomInt = r.nextInt(3) + 1;
        ShortAdventureFoes foe1 = new ShortAdventureFoes();
        foe1.setName("Wolf");
        foe1.setFoeClass("rogue");
        foe1.setLevel((long) randomInt);
        ShortAdventureFoes foe2 = new ShortAdventureFoes();
        foe2.setName("Bear");
        foe2.setFoeClass("knight");
        foe2.setLevel((long) randomInt);
        ShortAdventureFoes foe3 = new ShortAdventureFoes();
        foe3.setName("Gnoll");
        foe3.setFoeClass("wizard");
        foe3.setLevel((long) randomInt);
        shortAdventureFoesServices.addShortAdventureFoe(foe1);
        shortAdventureFoesServices.addShortAdventureFoe(foe2);
        shortAdventureFoesServices.addShortAdventureFoe(foe3);
        model.addAttribute("User", new User());
        return "addUser";
    }
    @PostMapping("/add")
    @ResponseBody
    private String addUserPost(@ModelAttribute User user){
        String string = "Utworzono użytkownika " + user.getUsername()
                + " Nazwa lidera " + user.getLeaderName();
        userServices.addUser(user);
        return string;
    }

    @GetMapping("/createHero")
    private String createHeroGet(Model model){
        model.addAttribute("UserHeroes", new UserHeroes());
        return "createHero";

    }
    @PostMapping("/createHero")
    @ResponseBody
    private String createHeroPost(@ModelAttribute UserHeroes userHeroes){
        userHeroes.setLevel(Long.valueOf(1));
        userHeroes.setExperiencePoints(Long.valueOf(0));


        userHeroesServices.addUserHero(userHeroes);

        return "Utworzono bohater o klasie "+ userHeroes.getHeroClass()+" dla uzytkownika o id "+ userHeroes.getOwnerId();
    }
}
