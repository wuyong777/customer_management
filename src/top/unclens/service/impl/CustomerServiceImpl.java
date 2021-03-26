package top.unclens.service.impl;

import top.unclens.bean.Customer;
import top.unclens.bean.PageBean;
import top.unclens.dao.CustomerDao;
import top.unclens.dao.impl.CustomerDaoImpl;
import top.unclens.service.CustomerService;

import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao = new CustomerDaoImpl();

    @Override
    public List<Customer> fianALL() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public void addCustomer(Customer customer) {
        dao.add(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Customer findCustomerById(String id) {
        return dao.findCustomerById(Integer.parseInt(id));
    }

    @Override
    public void updateCustomer(Customer customer) {
        dao.update(customer);
    }

    @Override
    public void delSelectedCustomer(String[] cids) {
        if (cids != null && cids.length > 0) {
            for (String cid : cids) {
                dao.delete(Integer.parseInt(cid));
            }
        }
    }

    @Override
    public PageBean<Customer> findCustomerByPage(String currentPage, String rows, Map<String, String[]> condition) {
        int curpage = Integer.parseInt(currentPage);
        int row = Integer.parseInt(rows);
        //System.out.println(row);

        PageBean<Customer> cPB = new PageBean<Customer>();
        cPB.setCurrentPage(curpage);
        cPB.setRows(row);

        int totalCount = dao.findTotalCount(condition);
        cPB.setTotalCount(totalCount);
        int start = (curpage - 1) * row;
        //System.out.println(start);
        List<Customer> list = dao.findByPage(start,row,condition);
        cPB.setList(list);
        int totalPage = (totalCount % row == 0) ? (totalCount / row) : ((totalCount / row) + 1);
        //System.out.println(totalCount+"====="+totalPage);
        cPB.setTotalPage(totalPage);
        return cPB;
    }
}
