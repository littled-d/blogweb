package cn.xiejp.first;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xiejp
 * 向页面输出Hello Servlet！并向ServletContext对象存一个数据，以验证getHelloServlet的跨Servlet的数据共享
 */
public class HelloServlet extends HttpServlet {
    //get与post只是请求实现的不同方式，可以相互调用，业务逻辑都一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("hello,servlet!");

        ServletContext servletContext = this.getServletContext();
        String userName = "老谢";
        servletContext.setAttribute("username",userName);


        //this.getInitParameter();  获得初始参数
        //this.getServletContext();  获得servlet的配置
        //this.getServletConfig(); 获得servlet的上下文参数
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
