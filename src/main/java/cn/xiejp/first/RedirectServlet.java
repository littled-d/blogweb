package cn.xiejp.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiejp
 * 重定向语句的使用
 */
public class RedirectServlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 重定向，此页面的状态码为3++, 一定注意路径问题，负责就会404
        resp.sendRedirect(getServletContext().getContextPath()+"/img");
        /*等价的：
        resp.setHeader("location","/img");
        resp.setStatus(HttpServletResponse.SC_FOUND);
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
