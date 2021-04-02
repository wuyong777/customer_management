package top.unclens.web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import top.unclens.bean.Customer;
import top.unclens.service.CustomerService;
import top.unclens.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addCustomerServlet")
@SuppressWarnings("all")
public class AddCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        //3.封装对象
        Customer customer = new Customer();
        try {
            BeanUtils.populate(customer,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Service保存
        CustomerService service = new CustomerServiceImpl();
        service.addCustomer(customer);
        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/findCustomerByPageServlet");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
