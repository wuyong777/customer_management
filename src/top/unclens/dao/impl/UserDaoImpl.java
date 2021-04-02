package top.unclens.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.unclens.bean.User;
import top.unclens.dao.UserDao;
import top.unclens.util.JDBCUtils;

public class UserDaoImpl implements UserDao {
    //获取连接
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            //1.定义SQL
            String sql = "select * from user where username = ? and password = ? ";
            //2.执行SQL
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}