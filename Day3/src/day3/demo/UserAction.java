package day3.demo;

import com.mysql.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * Created by Administrator on 14-6-7.
 */
public class UserAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("register")) {
            register(req, resp);
        }
        if (action.equals("login")) {
            login(req, resp);
        }
        if (action.equals("logout")) {
            logout(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

//        DB

        if (username.equalsIgnoreCase("zhangsan") && password.equals("123")) {
            req.getSession().setAttribute("username", "zhangsan");//***
            resp.sendRedirect("home.jsp");
        } else {
            req.setAttribute("message", "invalid username or password.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] cities = req.getParameterValues("city");//Beijing, Shanghai
        String[] hobbies = req.getParameterValues("hobbies");

//        JDBC - Java Database Connectivity
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
//        1. Driver
            new Driver();
//        2. Connection
            connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "123456");
//        3. SQL
            String register = "insert into user values(null, ?, ?, ?, ?)";
//        4. Statement
            preparedStatement = connection.prepareStatement(register);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, getString(cities));
            preparedStatement.setString(4, getString(hobbies));
//        5. insert
            preparedStatement.executeUpdate();//Update: insert, update, delete DML
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        resp.sendRedirect("index.jsp");
    }

    private String getString(String[] strings) {
        String s = "";
        for (int i = 0; i < strings.length; i++) {
             s += strings[i] + ", ";
        }
        return s;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
