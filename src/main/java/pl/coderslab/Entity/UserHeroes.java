package pl.coderslab.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private Long experiencePoints;
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
    @Column
    private Long ownerId;
    // TODO setheroClass automatycznie wywołuje pozostałe settery
    // TODO tak że użytkownik wybiera tylko imie i klase


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Long healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Long getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(Long manaPoints) {
        this.manaPoints = manaPoints;
    }

    public Long getStrength() {
        return strength;
    }

    public void setStrength(Long strength) {
        this.strength = strength;
    }

    public Long getAgility() {
        return agility;
    }

    public void setAgility(Long agility) {
        this.agility = agility;
    }

    public Long getInteligence() {
        return inteligence;
    }

    public void setInteligence(Long inteligence) {
        this.inteligence = inteligence;
    }

    public Long getLuck() {
        return luck;
    }

    public void setLuck(Long luck) {
        this.luck = luck;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Long experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public String toString() {
        return "UserHeroes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", heroClass='" + heroClass + '\'' +
                ", level=" + level +
                ", experiencePoints=" + experiencePoints +
                ", healthPoints=" + healthPoints +
                ", manaPoints=" + manaPoints +
                ", strength=" + strength +
                ", agility=" + agility +
                ", inteligence=" + inteligence +
                ", luck=" + luck +
                ", ownerId=" + ownerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHeroes that = (UserHeroes) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(heroClass, that.heroClass) &&
                Objects.equals(level, that.level) &&
                Objects.equals(experiencePoints, that.experiencePoints) &&
                Objects.equals(healthPoints, that.healthPoints) &&
                Objects.equals(manaPoints, that.manaPoints) &&
                Objects.equals(strength, that.strength) &&
                Objects.equals(agility, that.agility) &&
                Objects.equals(inteligence, that.inteligence) &&
                Objects.equals(luck, that.luck) &&
                Objects.equals(ownerId, that.ownerId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, heroClass, level, experiencePoints, healthPoints, manaPoints, strength, agility, inteligence, luck, ownerId);
    }
}
