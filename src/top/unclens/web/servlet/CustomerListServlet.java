package top.unclens.web.servlet;

import top.unclens.bean.Customer;
import top.unclens.service.CustomerService;
import top.unclens.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerListServlet")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        CustomerService service = new CustomerServiceImpl();
        List<Customer> customers = service.fianALL();
        //2.将list存入request域
        request.setAttribute("customers",customers);
        //3.转发到list.jsp
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
