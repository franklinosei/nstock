/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package views;

import controllers.DB_Connection;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import models.LabsModel;
import models.TechnicianModel;
import repositories.LabDAO;
import utils.SessionManager;

/**
 *
 * @author iamdveloper
 */
public class editLab extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     private List<String> allowedRoles = Arrays.asList("Manager");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        if (sessionId != null && SessionManager.isValidSession(sessionId)) {
            int labID = Integer.parseInt(request.getParameter("id"));
            
            TechnicianModel user = SessionManager.getUser(sessionId);
            request.setAttribute("user", user);

            //            check if user has access to this page
            if (!(this.allowedRoles.contains(user.getRole().getRoleName()))) {
                response.sendRedirect("/nstock/unauthorized");
                   return;
            }
            
            Connection connection = null;
            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                LabDAO labDAO = new LabDAO(connection);

                LabsModel lab = labDAO.getLabByID(labID);

                // Lab updated successfully
                request.setAttribute("lab", lab);
                request.setAttribute("contentName", "editLab.jsp");
                // Forward the request to the editLab.jsp for displaying the updated lab
                request.getRequestDispatcher("base.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred: " + e.getMessage());
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
            response.sendRedirect("/nstock/login");
        }
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
        response.setContentType("text/html;charset=UTF-8");

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

        if (sessionId != null && SessionManager.isValidSession(sessionId)) {
            // This is an edit request
            int labID = Integer.parseInt(request.getParameter("labID"));
            String labName = request.getParameter("labName");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String photo = request.getParameter("photo");

            // Update the lab information in the data source
            Connection connection = null;
            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                
                LabDAO labDAO = new LabDAO(connection);
                LabsModel lab = new LabsModel(labID, labName, city, region, photo);
                
                int rowsAffected = labDAO.updateLab(lab);

              
                response.sendRedirect("/nstock/labs");
           
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred: " + e.getMessage());
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
            response.sendRedirect("/nstock/login");
        }
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
