package pl.coderslab.Services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.Entity.UserHeroes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import pl.coderslab.Entity.ShortAdventureFoes;


@Component
@Transactional
public class ShortAdventureFoesServices {
    @PersistenceContext
    private EntityManager entityManager;
    public void addShortAdventureFoe(ShortAdventureFoes entity) {
        entityManager.persist(entity);
    }
    public void updateShortAdventureFoe(ShortAdventureFoes entity){
        entityManager.merge(entity);
    }
    public void deleteShortAdventureFoes(ShortAdventureFoes entity){
        entityManager.remove(entityManager.contains(entity) ? entity: entityManager.merge(entity));
    }
    public ShortAdventureFoes findShortAdventureFoesById(Long id){
        return entityManager.find(ShortAdventureFoes.class, id);
    }
        public List<ShortAdventureFoes> findAllShortAdventureFoes(){
        TypedQuery<ShortAdventureFoes> query = entityManager.createQuery("SELECT foe from ShortAdventureFoes foe", ShortAdventureFoes.class);
        List<ShortAdventureFoes> Foes = query.getResultList();
        return Foes;
    }
    public ShortAdventureFoes findShortAdventureFoesByName(String name) {
        List<ShortAdventureFoes> list = findAllShortAdventureFoes();
        for (ShortAdventureFoes foe: list
             ) {
            if(foe.getName().equals(name)){
                return foe;
            }

        }
        return null;
    }

}


