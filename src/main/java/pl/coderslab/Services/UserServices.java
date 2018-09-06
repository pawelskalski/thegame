package pl.coderslab.Services;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.Entity.User;
import pl.coderslab.Entity.UserHeroes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class UserServices {
    @PersistenceContext
    private EntityManager entityManager;
    public void addUser(User entity) {
        entityManager.persist(entity);
    }
    public void updateUser(User entity){
        entityManager.merge(entity);
    }
    public void deleteUser(User entity){
        entityManager.remove(entityManager.contains(entity) ? entity: entityManager.merge(entity));
    }
    public User findUserById(Long id){
        return entityManager.find(User.class, id);
    }
    public User findUserByEmail(String email){
        return entityManager.find(User.class, email);
    }


    public List<User> findAllUsers(){
        TypedQuery<User> query = entityManager.createQuery("SELECT user from User user", User.class);
        List<User> Users = query.getResultList();
        return Users;
    }
        public List<UserHeroes> findAllHeroesForUserWhomIdIs(Long id){
        TypedQuery<UserHeroes> query = entityManager.createQuery("Select hero from UserHeroes hero where hero.ownerId = :id", UserHeroes.class);
        query.setParameter("id", id);
        List<UserHeroes> userHeroes = query.getResultList();
        return userHeroes;
    }
    public List<String> getAllHeroesNamesForUserId(Long id){
        List<String> result = new ArrayList<>();
        List<UserHeroes> allHeroes = findAllHeroesForUserWhomIdIs(id);
        for (UserHeroes hero:allHeroes
                ) {
            result.add(hero.getName());
        }
        return result;
    }
}
