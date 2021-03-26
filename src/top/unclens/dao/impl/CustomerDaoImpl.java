package top.unclens.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.unclens.bean.Customer;
import top.unclens.dao.CustomerDao;
import top.unclens.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from customer where 1 = 1 ";//注意空格
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");//注意空格
                params.add("%" + value + "%");// ? 条件的值,注意加 % 号
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<Customer> findByPage(int start, int row, Map<String, String[]> condition) {
        String sql = "select * from customer where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");//注意空格
                params.add("%" + value + "%");// ? 条件的值,注意加 % 号
            }
        }
        sb.append(" limit ? , ? ");
        params.add(start);
        params.add(row);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class),params.toArray());
    }
}
