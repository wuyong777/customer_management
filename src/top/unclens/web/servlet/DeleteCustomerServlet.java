package top.unclens.web.servlet;

import top.unclens.service.CustomerService;
import top.unclens.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        CustomerService service = new CustomerServiceImpl();
        service.deleteCustomer(id);
        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findCustomerByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
