package pl.coderslab.Services;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.Entity.UserHeroes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserHeroesServices {
    @PersistenceContext
    private EntityManager entityManager;
    public void addUserHero(UserHeroes entity) {
        entityManager.persist(entity);
    }
    public void updateHero(UserHeroes entity){
        entityManager.merge(entity);
    }
    public void deleteHero(UserHeroes entity){
        entityManager.remove(entityManager.contains(entity) ? entity: entityManager.merge(entity));
    }
    public UserHeroes findHeroById(Long id){
        return entityManager.find(UserHeroes.class, id);
    }
//    public UserHeroes findHeroByEmail(String email){
//        return entityManager.find(UserHeroes.class, email);
//    }

    public List<UserHeroes> findAllHeroes(){
        TypedQuery<UserHeroes> query = entityManager.createQuery("SELECT userHeroes from UserHeroes userHeroes", UserHeroes.class);
        List<UserHeroes> Users = query.getResultList();
        return Users;
    }
    public UserHeroes findHeroeByName(String name){
        List<UserHeroes> allHeroes = findAllHeroes();
        for (UserHeroes hero: allHeroes
             ) {
            if (hero.getName().equals(name)){
                return hero;
            }

        }
        return null;
    }

}
