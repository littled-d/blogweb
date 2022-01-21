package cn.xiejp.first;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author xiejp
 * 验证码的生成，并设置浏览器禁止缓存，且固定时间刷新一次
 */
public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器五秒刷新一次
        resp.setHeader("refresh","5");

        //在内存中创建图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);

        //得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0,0,80,20);
        //给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(Font.getFont(Font.DIALOG));
        graphics.drawString(makeNum(),0,20);

        //告诉浏览器，我们请求用图片方式打开
        resp.setContentType("image/jpg");

        //设置不让浏览器缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");

        //把图片传输给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }
    private String makeNum() {
        Random random = new Random();
        String s = random.nextInt(999999) + "";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 6-s.length(); i++) {
            buffer.append("0");
        }
        return buffer.toString() + s;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
