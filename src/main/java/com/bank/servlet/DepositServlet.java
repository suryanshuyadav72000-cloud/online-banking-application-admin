package com.bank.servlet;

import com.bank.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");
        double amount = Double.parseDouble(request.getParameter("amount"));

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE customer SET balance = balance + ? WHERE account = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setString(2, account);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            response.setContentType("text/html");

            if (rows > 0) {
                response.getWriter().println("<h2>Amount Deposited Successfully!</h2>");
                response.getWriter().println("<a href='AdminDashboard.jsp'>Back to Dashboard</a>");
            } else {
                response.getWriter().println("<h2>Account Number Not Found!</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error:</h2>");
            response.getWriter().println(e.getMessage());
        }
    }
}
