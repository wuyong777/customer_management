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
    @SuppressWarnings("all")
    public int findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from customer where 1 = 1 ";//注意空格
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值则追加条件
                sb.append(" and " + key + " like ? ");//注意空格
                params.add("%" + value + "%");// ? 条件的值,注意加 % 号
            }
        }
        //System.out.println(sb.toString());
        //System.out.println(params);
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    @SuppressWarnings("all")
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
        //添加分页查询
        sb.append(" limit ? , ? ");
        //添加分页查询参数值
        params.add(start);
        params.add(row);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Customer>(Customer.class),params.toArray());
    }
}
