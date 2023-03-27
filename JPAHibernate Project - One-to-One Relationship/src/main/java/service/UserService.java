package service;

import dao.UserDao;
import entities.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public void create(User user) {
        userDao.create(user);
    }

    public User read(Long id) {
        return userDao.read(id);
    }

    public List<User> readAll() {
        return userDao.readAll();
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }

    public void close() {
        userDao.close();
    }
}
