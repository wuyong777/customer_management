package top.unclens.service.impl;

import top.unclens.bean.Customer;
import top.unclens.dao.CustomerDao;
import top.unclens.dao.impl.CustomerDaoImpl;
import top.unclens.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao = new CustomerDaoImpl();
    @Override
    public List<Customer> fianALL() {
        //调用dao完成查询
        return dao.findAll();
    }
}
