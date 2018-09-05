package pl.coderslab.Entity;

import javax.persistence.*;

@Entity
public class ShortAdventureFoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String foeClass;
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

}
