package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bank.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = request.getParameter("name");
            String account = request.getParameter("account");
            String mobile = request.getParameter("mobile");
            String balance = request.getParameter("balance");

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO customer(name, account, mobile, balance) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, account);
            ps.setString(3, mobile);
            ps.setDouble(4, Double.parseDouble(balance));

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("AdminDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h2>Error:</h2>");
            response.getWriter().println(e.toString());

        }
    }
}