package cn.xiejp.first;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiejp
 * 1、接收请求，打印出存放在ServletContext中的数据，在HelloServlet.java中会向ServletContext中存放一个数据（要验证得先注释掉请求转发语句）
 * 2、ServletContext对象的请求转发的实现
 */
public class getHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 数据放上面
        ServletContext servletContext = this.getServletContext();
        String username = (String) servletContext.getAttribute("username");
        // 响应放下面
        resp.setContentType("text/html;charset=utf-8");
        //等价于
        // resp.setContentType("text/html");
        // resp.setCharacterEncoding("utf-8");
        resp.getWriter().println("名字是："+username);
        System.out.println("打印了名字！！");


        //请求转发
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/UrlDemo");//转发的请求路径
        requestDispatcher.forward(req,resp);
        //等价于
        //servletContext.getRequestDispatcher("/hello/UrlDemo").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
