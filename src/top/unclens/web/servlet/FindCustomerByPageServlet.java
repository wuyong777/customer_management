package top.unclens.web.servlet;

import top.unclens.bean.Customer;
import top.unclens.bean.PageBean;
import top.unclens.service.CustomerService;
import top.unclens.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findCustomerByPageServlet")
public class FindCustomerByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        //防止其他页面转发或重定向到此Servlet出现空指针异常
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        //防止其他页面转发或重定向到此Servlet出现空指针异常
        if (rows == null || "".equals(rows)){
            rows = "10";
        }

        Map<String, String[]> condition = request.getParameterMap();
        CustomerService service = new CustomerServiceImpl();
        PageBean<Customer> pb = service.findCustomerByPage(currentPage,rows,condition);
        //System.out.println(pb);
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
