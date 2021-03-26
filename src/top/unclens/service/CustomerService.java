package top.unclens.service;

import top.unclens.bean.Customer;
import top.unclens.bean.PageBean;

import java.util.List;
import java.util.Map;

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

    /**
     *
     * @param cids
     */
    void delSelectedCustomer(String[] cids);

    /**
     *
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Customer> findCustomerByPage(String currentPage, String rows, Map<String, String[]> condition);
}
