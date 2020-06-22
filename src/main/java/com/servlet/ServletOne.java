package com.servlet;

import com.alibaba.fastjson.JSON;
import com.spring.util.DbManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:Servlet
 * @author: Cherry
 * @time: 2020/6/5 8:24
 */
@WebServlet("/one")
public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("config/spring-config.xml");

        DbManager manager = (DbManager) app.getBean("dbManager");
        Connection conn = manager.getConnection();
        String sql = "select * from teacher where uuid = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);

            ResultSet rs = ps.executeQuery();
            rs.next();

           resp.getWriter().write(rs.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
