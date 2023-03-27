package dao;

import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDao {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public UserDao(){
        entityManagerFactory = Persistence.createEntityManagerFactory("pu1");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void create(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public User read(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> readAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void update(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        User user = read(id);
        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
