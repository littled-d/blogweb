package cn.xiejp.second;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author xiejp
 * 得到用户的Session对象中保存的指定数据，并注销此Session或此键值对
 */
public class getSessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        //得到Session对象
        HttpSession session = req.getSession();
        String name = session.getAttribute("name") + "";

        System.out.println(name);
        resp.getWriter().println("从Session中取得数据name="+name);

        session.removeAttribute("name");
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

