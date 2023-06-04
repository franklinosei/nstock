/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package views;

import controllers.DB_Connection;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.ItemsModel;
import models.LabsModel;
import models.TechnicianModel;
import repositories.ItemDAO;
import repositories.LabDAO;
import repositories.TechnicianDAO;
import utils.SessionManager;

/**
 *
 * @author iamdveloper
 */
public class dashboard extends HttpServlet {

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

        // Retrieve the session ID from the session cookie
        String sessionId = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("session_id")) {
                    sessionId = cookie.getValue();
                    break;
                }
            }
        }

        // Verify the session
        if (sessionId != null && SessionManager.isValidSession(sessionId)) {
            // User is authenticated, proceed with the protected route logic
            // Retrieve the associated username if needed
            TechnicianModel user = SessionManager.getUser(sessionId);
            request.setAttribute("user", user);

//            get all labs, technicians and items
            // Get the list of items from the database
            Connection connection = null;
            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                ItemDAO itemDAO = new ItemDAO(connection);
                LabDAO labsDAO = new LabDAO(connection);
                TechnicianDAO techDAO = new TechnicianDAO(connection);

                List<ItemsModel> itemsList = itemDAO.getAllItems();
                List<LabsModel> labsList = labsDAO.getAllLabs();
                List<TechnicianModel> techList = techDAO.getAllTechnicians();

                // Set the list of items as a request attribute
                request.setAttribute("items", itemsList);
                request.setAttribute("labs", labsList);
                request.setAttribute("technicians", techList);

                RequestDispatcher rd = request.getRequestDispatcher("base.jsp");

                request.setAttribute("contentName", "dashboard.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace(); // Print the full stack trace
                response.getWriter().println("An error occurred: " + e.getMessage()); // Print the error message
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

        } else {
            // User is not authenticated, redirect to the login page or return an error response
            response.sendRedirect("/nstock/login");
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
