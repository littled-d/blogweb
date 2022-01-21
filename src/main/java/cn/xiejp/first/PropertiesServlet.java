package cn.xiejp.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xiejp
 * ServletContext对象获取资源文件并加载
 */
public class PropertiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 资源读取，先得到该资源的流
        InputStream is = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
        // 流加载器，Properties对象加载该流
        Properties properties = new Properties();
        properties.load(is);
        // 通过该加载器，读到相应键的值
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        resp.getWriter().println(username+" "+password);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
