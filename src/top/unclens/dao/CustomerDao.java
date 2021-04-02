package top.unclens.dao;

import top.unclens.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<Customer> findAll();

    /**
     * 添加用户
     * @param customer
     */
    void add(Customer customer);

    /**
     * 通过id删除用户
     * @param id
     */
    void delete(int id);

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    Customer findCustomerById(int id);

    /**
     * 跟新用户数据
     * @param customer
     */
    void update(Customer customer);

    /**
     * 查总记录数，且可条件查询
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页，条件查询
     * @param start
     * @param row
     * @param condition
     * @return
     */
    List<Customer> findByPage(int start, int row, Map<String, String[]> condition);
}
