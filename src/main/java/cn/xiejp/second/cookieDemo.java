package cn.xiejp.second;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @author xiejp
 * 使用cookie，在用户第一次访问本站时将信息保存在客户端，保存名字老谢与上次访问的时间，
 * 后面访问时打印；
 * 部分浏览器会直接有JSEESSION这个cookie信息，所以不会指向if的前语句
 */
//保存用户上一次访问的时间
public class cookieDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            out.println("这是您第一次访问本网站");
            Cookie name = new Cookie("name", "老谢");
            resp.addCookie(name);
            Cookie lastedLoginTime = new Cookie("lastedLoginTime", System.currentTimeMillis() + "");
            resp.addCookie(lastedLoginTime);
        } else {
            out.println("您不是第一次访问本网站：");
            for (Cookie cookie: cookies) {
                if(cookie.getName().equals("name")) {
                    out.println("您的名字是："+cookie.getValue()+"!");
                }
                if (cookie.getName().equals("lastedLoginTime")) {
                    //获取到的是字符串，转为Long，再转为日期;
                    long lastedLoginTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastedLoginTime);
                    out.println("您上次访问的时间是：" + date.toString());
                    cookie.setValue(System.currentTimeMillis()+"");
                }
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
