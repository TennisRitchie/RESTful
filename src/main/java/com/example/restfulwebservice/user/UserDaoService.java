package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private int usersCount = 3;

    static {
        users.add(new User(1, "keen", new Date()));
        users.add(new User(1, "geen", new Date()));
        users.add(new User(1, "qeen", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
