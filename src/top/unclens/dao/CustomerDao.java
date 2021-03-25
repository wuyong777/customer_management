package top.unclens.dao;

import top.unclens.bean.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findAll();

    void add(Customer customer);

    void delete(int id);

    Customer findCustomerById(int id);

    void update(Customer customer);
}
