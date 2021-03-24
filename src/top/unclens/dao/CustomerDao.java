package top.unclens.dao;

import top.unclens.bean.Customer;

import java.util.List;

public interface CustomerDao {
    public List<Customer> findAll();
}
