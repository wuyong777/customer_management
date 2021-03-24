package top.unclens.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.unclens.bean.Customer;
import top.unclens.dao.CustomerDao;
import top.unclens.util.JDBCUtils;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Customer> findAll() {

        String sql = "select * from customer";
        List<Customer> customers = template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class));
        //使用jdbc操作数据库
        return customers;
    }
}
