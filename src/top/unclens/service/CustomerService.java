package top.unclens.service;

import top.unclens.bean.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<Customer> fianALL();
}
