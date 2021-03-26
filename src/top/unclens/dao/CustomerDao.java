package top.unclens.dao;

import top.unclens.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
    public List<Customer> findAll();

    void add(Customer customer);

    void delete(int id);

    Customer findCustomerById(int id);

    void update(Customer customer);

    int findTotalCount(Map<String, String[]> condition);

    List<Customer> findByPage(int start, int row, Map<String, String[]> condition);
}
