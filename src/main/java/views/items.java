/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package views;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import java.sql.*;
import controllers.DB_Connection;
import jakarta.servlet.RequestDispatcher;
import repositories.ItemDAO;
import models.ItemsModel;

/**
 *
 * @author confi
 */
public class items extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Handle POST request to add a new item
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String faulty = request.getParameter("faulty");
            String typeID = request.getParameter("typeID");
            String photo = request.getParameter("photo");
            String serialNumber = request.getParameter("serialNumber");
            String labID = request.getParameter("labID");
           // String managerID = request.getParameter("managerID");
            String specID = request.getParameter("specID");

            ItemsModel item = new ItemsModel();
            item.setName(name);
            item.setDescription(description);
            item.setFaulty(Boolean.FALSE);
            item.setItemID(0);
            item.setLabID(0);
            item.setPhoto(photo);
            item.setSerialNumber(serialNumber);
            item.setTypeID(0);
            item.setSpecID(0);
           // item.setManagerID(0);
            item.setSpecID(0);

//            RequestDispatcher rd = request.getRequestDispatcher("base.jsp");
//            request.setAttribute("contentName", "items.jsp");
//            rd.forward(request, response);

            try {
                DB_Connection dbConnection = new DB_Connection();
                ItemDAO ItemDAO = new ItemDAO(dbConnection.connect());
                int rowsAffected = ItemDAO.insertItem(item);

                if (rowsAffected > 0) {
                    // Lab added successfully
                    response.sendRedirect("items");
                } else {
                    // Failed to add lab
                    response.getWriter().println("Failed to add item");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred");
            }
        } else {
            // Handle GET request for displaying the form
            // Render the form to add a new item
            request.getRequestDispatcher("newItem.jsp").forward(request, response);
        }
    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
