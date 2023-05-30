/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package views;

import controllers.DB_Connection;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import models.TechnicianModel;
import repositories.TechnicianDAO;

/**
 *
 * @author confi
 */
public class technician extends HttpServlet {

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

        RequestDispatcher rd = request.getRequestDispatcher("base.jsp");
        request.setAttribute("contentName", "technician.jsp");
        rd.forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");

        Connection connection = null;
        request.setAttribute("contentName", "technician.jsp");
        try {
            DB_Connection dbConnection = new DB_Connection();
            connection = dbConnection.connect();
            TechnicianDAO techDAO = new TechnicianDAO(connection);
            ArrayList<TechnicianModel> techniciansList = techDAO.getAllTechnicians();

            // Set the list of technicians as a request attribute
            request.setAttribute("technicians", techniciansList);

            // Forward the request to the labs.jsp for displaying the list
            request.getRequestDispatcher("base.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Print the full stack trace
            response.getWriter().println("An error occurred: " + e.getMessage()); // Print the error message

            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("base.jsp").forward(request, response);
        } finally {
            // Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

//        RequestDispatcher rd = request.getRequestDispatcher("base.jsp");
//        request.setAttribute("contentName", "technician.jsp");
//        rd.forward(request, response);
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
