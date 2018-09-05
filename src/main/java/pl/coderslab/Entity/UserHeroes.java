package pl.coderslab.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserHeroes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String heroClass;
    @Column
    private Long level;
    @Column
    private Long healthPoints;
    @Column
    private Long manaPoints;
    @Column
    private Long strength;
    @Column
    private Long agility;
    @Column
    private Long inteligence;
    @Column
    private Long luck;
    @ManyToOne
    private User user;

    // TODO setheroClass automatycznie wywołuje pozostałe settery
    // TODO tak że użytkownik wybiera tylko imie i klase

}
