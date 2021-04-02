package top.unclens.service;

import top.unclens.bean.User;

public interface UserService {
    /**
     * 登录方法
     * @param user
     * @return
     */
    public User login(User user);
}
