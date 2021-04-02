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
        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示条数


        //防止其他页面转发或重定向到此Servlet出现空指针异常
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        //防止其他页面转发或重定向到此Servlet出现空指针异常
        if (rows == null || "".equals(rows)){
            rows = "10";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //2.调用service查询
        CustomerService service = new CustomerServiceImpl();
        PageBean<Customer> pb = service.findCustomerByPage(currentPage,rows,condition);
        //System.out.println(pb);
        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//将查询条件存入request
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
