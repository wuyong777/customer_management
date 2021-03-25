package top.unclens.service.impl;

import top.unclens.bean.User;
import top.unclens.dao.UserDao;
import top.unclens.dao.impl.UserDaoImpl;
import top.unclens.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
