package day3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String[] cities = req.getParameterValues("city");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println(username + ", " + password + ", " + cities.length + ", " + hobbies.length);
//        DB

        resp.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
