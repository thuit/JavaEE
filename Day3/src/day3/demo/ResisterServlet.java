package day3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 14-6-7.
 */
//servlet 服务器端小程序
//1. 接收请求
//2. 处理请求
//3. 返回响应
public class ResisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] cities = req.getParameterValues("city");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println(username + ", " + password + ", " + cities.length + ", " + hobbies.length);
//        DB

        resp.sendRedirect("index.jsp");
    }
}
