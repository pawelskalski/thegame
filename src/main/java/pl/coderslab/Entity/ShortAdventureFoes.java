package pl.coderslab.Entity;

import javax.persistence.*;
import java.util.Objects;

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

    public String getFoeClass() {
        return foeClass;
    }

    public void setFoeClass(String foeClass) {
        this.foeClass = foeClass;
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

    @Override
    public String toString() {
        return "ShortAdventureFoes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foeClass='" + foeClass + '\'' +
                ", level=" + level +
                ", healthPoints=" + healthPoints +
                ", manaPoints=" + manaPoints +
                ", strength=" + strength +
                ", agility=" + agility +
                ", inteligence=" + inteligence +
                ", luck=" + luck +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortAdventureFoes that = (ShortAdventureFoes) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(foeClass, that.foeClass) &&
                Objects.equals(level, that.level) &&
                Objects.equals(healthPoints, that.healthPoints) &&
                Objects.equals(manaPoints, that.manaPoints) &&
                Objects.equals(strength, that.strength) &&
                Objects.equals(agility, that.agility) &&
                Objects.equals(inteligence, that.inteligence) &&
                Objects.equals(luck, that.luck);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, foeClass, level, healthPoints, manaPoints, strength, agility, inteligence, luck);
    }
}
