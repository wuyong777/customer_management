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
     *添加用户信息
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     *删除用户信息
     * @param id
     */
    void deleteCustomer(String id);

    /**
     *根据id查询用户
     * @param id
     * @return
     */
    Customer findCustomerById(String id);

    /**
     *更新用户信息
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     *批量删除用户
     * @param cids
     */
    void delSelectedCustomer(String[] cids);

    /**
     *分页，条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Customer> findCustomerByPage(String currentPage, String rows, Map<String, String[]> condition);
}
