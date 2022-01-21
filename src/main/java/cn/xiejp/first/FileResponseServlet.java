package cn.xiejp.first;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


/**
 * @author xiejp
 * 客户端发送请求来，ServletContext获取指定图片资源文件
 */
public class FileResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 要获取的文件路径
        String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/background.jpg");
        System.out.println("获取到的路径：" + realPath);
        // 下载的文件名
        String fileName = realPath.substring(realPath.lastIndexOf("/") + 1);
        System.out.println(realPath);
        // 设置要浏览器支持我们下载需要的东西 文件传输必要的响应头
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        // 获取下载文件的缓冲流
        FileInputStream fileInputStream = new FileInputStream(fileName);
        // 创建缓冲区 把字节数组作为缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 获取outPutSteam对象
        ServletOutputStream outputStream = resp.getOutputStream();
        // 将outPutStream流写入buffer缓冲区  使用outPutStream流将缓冲区中的数据输出到客户端
        while ((len=fileInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
