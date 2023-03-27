package dao;

import entities.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PostDao {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public PostDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu1");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void create(Post post) {
        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
    }

    public Post read(Long id) {
        return entityManager.find(Post.class, id);
    }

    public List<Post> readAll() {
        return entityManager.createQuery("SELECT p FROM Post p", Post.class).getResultList();
    }

    public void update(Post post) {
        entityManager.getTransaction().begin();
        entityManager.merge(post);
        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Post post = read(id);
        entityManager.getTransaction().begin();
        entityManager.remove(post);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
