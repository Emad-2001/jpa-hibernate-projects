package service;

import dao.PostDao;
import entities.Post;

import java.util.List;

public class PostService {
    private final PostDao postDao;

    public PostService() {
        postDao = new PostDao();
    }

    public void create(Post post) {
        postDao.create(post);
    }

    public Post read(Long id) {
        return postDao.read(id);
    }

    public List<Post> readAll() {
        return postDao.readAll();
    }

    public void update(Post post) {
        postDao.update(post);
    }

    public void delete(Long id) {
        postDao.delete(id);
    }

    public void close() {
        postDao.close();
    }
}
