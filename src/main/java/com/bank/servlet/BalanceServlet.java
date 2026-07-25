package com.bank.servlet;

import com.bank.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT balance FROM customer WHERE account=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h2>Current Balance: ₹ " + rs.getDouble("balance") + "</h2>");
            } else {
                out.println("<h2>Account Number Not Found!</h2>");
            }

            rs.close();
            ps.close();
            con.close();

            out.println("<br><a href='AdminDashboard.jsp'>Back to Dashboard</a>");

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error:</h2>");
            out.println(e.getMessage());
        }
    }
}