/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package views;

import jakarta.servlet.RequestDispatcher;

import controllers.DB_Connection;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LabsModel;
import repositories.LabDAO;
import utils.SessionManager;

public class newLab extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
            
            RequestDispatcher rd = request.getRequestDispatcher("base.jsp");

//        Content name to display
            request.setAttribute("contentName", "newLab.jsp");
//        rd.forward(request, response);

            // Handle POST request to add a new lab
            if (request.getMethod().equalsIgnoreCase("POST")) {
                String labName = request.getParameter("labName");
                String city = request.getParameter("city");
                String region = request.getParameter("region");
                String photo = request.getParameter("photo");

                // Create a new LabsModel object
                LabsModel lab = new LabsModel();
                lab.setLabName(labName);
                lab.setCity(city);
                lab.setRegion(region);
                lab.setPhoto(photo);

                // Add the lab to the database using LabDAO
                try {
                    DB_Connection dbConnection = new DB_Connection();
                    LabDAO labDAO = new LabDAO(dbConnection.connect());
                    int rowsAffected = labDAO.insertLab(lab);
                    
                    if (rowsAffected > 0) {
                        // Lab added successfully
                        response.sendRedirect("/nstck/labs");
                    } else {
                        // Failed to add lab
                        response.getWriter().println("Failed to add lab");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    response.getWriter().println("An error occurred");
                }
            } else {
                // Handle GET request for displaying the form
                // Render the form to add a new lab
                request.getRequestDispatcher("base.jsp").forward(request, response);
            }
            
        } else {
            response.sendRedirect("/nstock/login");
        }
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
