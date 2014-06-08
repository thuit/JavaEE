package day4.demo;

import day4.demo.entity.Book;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-6-8.
 */
public class BookAction extends HttpServlet {

    private static Connection connection = DB.getConnection();
    private static PreparedStatement preparedStatement;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("add")) {
            try {
                add(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("list")) {
            try {
                list(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("search")) {
            try {
                search(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("update")) {
            try {
                update(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (action.equals("remove")) {
            try {
                remove(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String press = req.getParameter("press");
        String picture = req.getParameter("picture");
        String date = req.getParameter("date");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");

        String sql = "insert into book values(null, ?, ?, ?, ?, ?, ?, ?)";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setString(3, press);
        preparedStatement.setString(4, picture);
        preparedStatement.setString(5, date);
        preparedStatement.setString(6, price);
        preparedStatement.setString(7, amount);

        preparedStatement.executeUpdate();

        DB.close(null, preparedStatement, null);

        resp.sendRedirect("book?action=list");//forward?
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String sql = "select * from book";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Book> books = new ArrayList<Book>();
        while (resultSet.next()) {
            Book book = new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"),
                    resultSet.getString("press"), resultSet.getString("picture"), resultSet.getString("date"),
                    resultSet.getString("price"), resultSet.getString("amount"));
            books.add(book);
        }
        DB.close(resultSet, preparedStatement, null);
        req.getSession().setAttribute("books", books);
        resp.sendRedirect("home.jsp");
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "select * from book where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Book book = new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"),
                resultSet.getString("press"), resultSet.getString("picture"), resultSet.getString("date"),
                resultSet.getString("price"), resultSet.getString("amount"));
        req.getSession().setAttribute("book", book);
        DB.close(resultSet, preparedStatement, null);
        resp.sendRedirect("edit.jsp");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String press = req.getParameter("press");
        String picture = req.getParameter("picture");
        String date = req.getParameter("date");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");
        String sql = "update book set title=?, author=?, press=?, picture=?, date=?, price=?, amount=? where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setString(3, press);
        preparedStatement.setString(4, picture);
        preparedStatement.setString(5, date);
        preparedStatement.setString(6, price);
        preparedStatement.setString(7, amount);
        preparedStatement.setInt(8, id);
        preparedStatement.executeUpdate();
        DB.close(null, preparedStatement, null);
        resp.sendRedirect("book?action=list");
    }

    private void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String sql = "delete from book where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        DB.close(null, preparedStatement, null);
        resp.sendRedirect("book?action=list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
