package top.unclens.service;

import top.unclens.bean.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<Customer> fianALL();

    /**
     *
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     *
     * @param id
     */
    void deleteCustomer(String id);

    /**
     *
     * @param id
     * @return
     */
    Customer findCustomerById(String id);

    /**
     *
     * @param customer
     */
    void updateCustomer(Customer customer);
}
