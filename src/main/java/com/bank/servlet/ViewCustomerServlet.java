package com.bank.servlet;

import com.bank.DBConnection;
import com.bank.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/ViewCustomerServlet")
public class ViewCustomerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Customer> customerList = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM customer";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Customer c = new Customer();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setAccount(rs.getString("account"));
                c.setMobile(rs.getString("mobile"));
                c.setBalance(rs.getDouble("balance"));

                customerList.add(c);
            }

            rs.close();
            ps.close();
            con.close();

            request.setAttribute("customerList", customerList);
            request.getRequestDispatcher("viewCustomers.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}