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

@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String balance = request.getParameter("balance");

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE customer SET name=?, mobile=?, balance=? WHERE account=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, mobile);
            ps.setDouble(3, Double.parseDouble(balance));
            ps.setString(4, account);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("AdminDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("<h2>Error:</h2>");
            response.getWriter().println(e);
        }
    }
}