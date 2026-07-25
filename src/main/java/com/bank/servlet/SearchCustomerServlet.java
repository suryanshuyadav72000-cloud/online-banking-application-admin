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

@WebServlet("/SearchCustomerServlet")
public class SearchCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String account = request.getParameter("account");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM customer WHERE account=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, account);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                out.println("<h2>Customer Details</h2>");
                out.println("ID: " + rs.getInt("id") + "<br><br>");
                out.println("Name: " + rs.getString("name") + "<br><br>");
                out.println("Account: " + rs.getString("account") + "<br><br>");
                out.println("Mobile: " + rs.getString("mobile") + "<br><br>");
                out.println("Balance: " + rs.getDouble("balance") + "<br><br>");

            } else {
                out.println("<h2>Customer Not Found!</h2>");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error:</h2>");
            out.println(e.getMessage());
        }
    }
}