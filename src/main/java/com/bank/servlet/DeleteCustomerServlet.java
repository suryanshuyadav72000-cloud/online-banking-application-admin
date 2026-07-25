package com.bank.servlet;

import com.bank.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM customer WHERE account=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("AdminDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println(e);
        }
    }
}
