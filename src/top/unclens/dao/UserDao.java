package top.unclens.dao;

import top.unclens.bean.User;

public interface UserDao {
    /**
     * 通过用户名和密码查询用户是否存在
     * @param username
     * @param password
     * @return
     */
    public User findUserByUsernameAndPassword(String username, String password);
}

