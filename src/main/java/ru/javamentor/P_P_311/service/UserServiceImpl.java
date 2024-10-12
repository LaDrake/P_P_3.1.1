package ru.javamentor.P_P_311.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.P_P_311.dao.UserDao;
import ru.javamentor.P_P_311.model.User;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);

    }

    @Override
    @Transactional
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(id);

    }

    @Override
    @Transactional
    public void update(User user) {
        userDao.update(user);

    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }
}
