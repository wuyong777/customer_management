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

    @Override
    public void add(Customer customer) {
        String sql = "insert into customer values(null,?,?,?,?,?,?)";
        template.update(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getAddress(), customer.getQq(), customer.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from customer where id= ?";
        template.update(sql, id);
    }

    @Override
    public Customer findCustomerById(int id) {
        String sql = "select * from customer where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), id);
    }

    @Override
    public void update(Customer customer) {
        String sql = "update customer set name = ?,gender = ?,age = ?,address = ?,qq = ?, email = ? where id = ?";
        template.update(sql, customer.getName(), customer.getGender(), customer.getAge(), customer.getAddress(), customer.getQq(), customer.getEmail(), customer.getId());
    }
}
