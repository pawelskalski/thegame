package pl.coderslab.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String leaderName;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserHeroes>  userHeroes = new ArrayList<>();


    //TODO sprawdzic czy ManyToOne działa tak jak chce

}
