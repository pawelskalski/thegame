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

import java.util.List;
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
    private String showHome() {
        return "home";
    }

    @GetMapping("/add")
    private String addUserGet(Model model) {
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
    private String addUserPost(@ModelAttribute User user) {
        String string = "Created user: " + user.getUsername()
                + " World will know him as: " + user.getLeaderName();
        userServices.addUser(user);
        return string;
    }

    @RequestMapping("/showUsers")
    @ResponseBody
    private String showAllUsersPost() {
        String string = "";
        List<User> list = userServices.findAllUsers();
        for (User user : list
                ) {
            string += "Id: " + user.getId()
                    + ", Username: " + user.getUsername()
                    + ", email: " + user.getEmail()
                    + ", Leader name: " + user.getLeaderName()
                    + "<br>";


        }
        return string;
    }

    @RequestMapping("/deleteUser/{id}")
    @ResponseBody
    private String deleteUserWhereIdIs(@PathVariable long id) {
        try {
            userServices.deleteUser(userServices.findUserById(id));
            List<UserHeroes> list = userHeroesServices.findAllHeroesFromUser(id);
            for (UserHeroes hero : list
                    ) {
                userHeroesServices.deleteHero(hero);

            }
            return "Delete user and all his heroes";
        } catch (Exception e) {
            return "Cant find user";
        }

    }

    @GetMapping("/editUser")
    private String updateUser(Model model) {
        model.addAttribute("User", new User());
        return "editUser";
    }

    @PostMapping("/editUser")
    @ResponseBody
    private String updateUserPost(@ModelAttribute User updatedUser) {
        try {
            User oldUser = userServices.findUserById(updatedUser.getId());
            oldUser.setEmail(updatedUser.getEmail());
            oldUser.setLeaderName(updatedUser.getLeaderName());
            oldUser.setPassword(updatedUser.getPassword());
            userServices.updateUser(oldUser);
            return "User changed";
        } catch (Exception e) {
            return "Cant find User";
        }
    }

    @GetMapping("/createHero")
    private String createHeroGet(Model model) {
        model.addAttribute("UserHeroes", new UserHeroes());
        return "createHero";

    }

    @PostMapping("/createHero")
    @ResponseBody
    private String createHeroPost(@ModelAttribute UserHeroes userHeroes) {
        userHeroes.setLevel(Long.valueOf(1));
        userHeroes.setExperiencePoints(Long.valueOf(0));


        userHeroesServices.addUserHero(userHeroes);

        return "Hero: " + userHeroes.getHeroClass() + " created for user which id is:  " + userHeroes.getOwnerId();
    }

    @GetMapping("/updateHero")
    private String updateHero(Model model) {
        model.addAttribute("UserHeroes", new UserHeroes());
        return "updateHero";
    }

    @PostMapping("/updateHero")
    @ResponseBody
    String updateHeroPost(@ModelAttribute UserHeroes updatedHero) {
        try {
            UserHeroes oldHero = userHeroesServices.findHeroById(updatedHero.getId());
            oldHero.setName(updatedHero.getName());
            userHeroesServices.updateHero(oldHero);
            return "Changed hero name";
        } catch (Exception e) {
            return "Hero not found";
        }
    }
    @GetMapping("/deleteHero")
    private String deleteHeroGet(Model model){
        model.addAttribute("UserHeroes", new UserHeroes());
        return "deleteHero";
    }
    @PostMapping("/deleteHero")
    @ResponseBody
    private String deleteHeroPost(@ModelAttribute UserHeroes hero) {
        try {
            userHeroesServices.deleteHero(userHeroesServices.findHeroById(hero.getId()));
            return "Hero deleted";
        } catch (Exception e) {
            return "hero not found";
        }
    }
}
