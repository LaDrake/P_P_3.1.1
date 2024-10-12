package ru.javamentor.P_P_311.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.javamentor.P_P_311.model.User;


import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(User user) {
    em.persist(user);
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        User user = em.find(User.class, id);
        em.remove(user);
    }

    @Override
    public void update(User user) {
    em.merge(user);
    }

    @Override
    public List<User> findAll() {
    List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        return users;
    }
}
