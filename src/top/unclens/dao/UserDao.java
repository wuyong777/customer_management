package top.unclens.dao;

import top.unclens.bean.User;

public interface UserDao {
    public User findUserByUsernameAndPassword(String username, String password);
}

