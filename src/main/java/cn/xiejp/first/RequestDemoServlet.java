package cn.xiejp.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author xiejp
 * 表单加载，获取index.jsp传进来的表单内容，并打印在输出台，页面跳转到重定向页面，重定向页面跳转到验证码页面
 */
public class RequestDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username+" "+password);

        String[] hobbies = req.getParameterValues("hobbies");
        System.out.println(Arrays.toString(hobbies));

        //请求转发到重定向页面
        req.getRequestDispatcher("/redirect").forward(req,resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
