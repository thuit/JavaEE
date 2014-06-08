package day4.demo;

import day4.demo.util.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Administrator on 14-6-7.
 */
public class UserAction extends HttpServlet {

    private static Connection connection = DB.getConnection();
    private static PreparedStatement preparedStatement;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("register")) {
            try {
                register(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("login")) {
            try {
                login(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("logout")) {
            logout(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect("index.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String register = "select * from user where username=? and password=?";
        preparedStatement = connection.prepareStatement(register);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();//Query
        boolean b = resultSet.next();
        DB.close(resultSet, preparedStatement, null);
        if (b) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("home.jsp");
        } else {
            req.setAttribute("message", "invalid username or password.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] cities = req.getParameterValues("city");//Beijing, Shanghai
        String[] hobbies = req.getParameterValues("hobbies");

        String register = "insert into user values(null, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(register);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, getString(cities));
        preparedStatement.setString(4, getString(hobbies));
        preparedStatement.executeUpdate();//Update: insert, update, delete DML
        DB.close(null, preparedStatement, null);
        resp.sendRedirect("index.jsp");
    }

    private String getString(String[] strings) {
        if (strings != null) {
            String s = "";
            for (int i = 0; i < strings.length; i++) {
                s += strings[i] + ", ";
            }
            return s;
        } else {
            return "";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
