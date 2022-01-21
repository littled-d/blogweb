package cn.xiejp.second;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author xiejp
 * 向给用户的Session对象增加键值对
 * 一般进浏览器的瞬间，服务器会直接给生成Session对象，所以不执行创建Session的输出语句
 */
public class SessionDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("UTF-8");

        //得到Session对象
        HttpSession session = req.getSession();

        //给Session中存东西
        session.setAttribute("name","老谢");

        //获取Session中的id
        String id = session.getId();

        //判断Session是不是新的
        if (session.isNew()) {
            resp.getWriter().write("Session创建成功，ID="+id);
        } else {
            resp.getWriter().write("Session已经存在，ID="+id);
        }

        //Session创建之后做了什么事：给客户端一个SessionId，对应服务器中的一个Session，客户端凭借此ID取的在服务器中的数据
        //Cookie sessionId = new Cookie("JSESSIONID", sessionId);
        //resp.addCookie(sessionId);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
