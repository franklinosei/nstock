/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package views;

import controllers.Authenticator;
import controllers.DB_Connection;
import controllers.Manager;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import models.LabsModel;
import models.TechnicianModel;
import repositories.LabDAO;

/**
 *
 * @author confi
 */
public class newTechnician extends HttpServlet {

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
        Connection connection = null;
        request.setAttribute("contentName", "newTechnician.jsp");

        try {
            DB_Connection dbConnection = new DB_Connection();
            connection = dbConnection.connect();

//         Get all Labs
            LabDAO labDAO = new LabDAO(connection);

            ArrayList<LabsModel> labsList = (ArrayList<LabsModel>) labDAO.getAllLabs();

            // Set the list of technicians as a request attribute
            request.setAttribute("labs", labsList);

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
//        request.setAttribute("contentName", "newTechnician.jsp");
//        rd.forward(request, response);
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

        response.setContentType("text/html;charset=UTF-8");
        Connection connection = null;
        request.setAttribute("contentName", "technician.jsp");

        try {
            DB_Connection dbConnection = new DB_Connection();
            connection = dbConnection.connect();

            TechnicianModel techieData = (TechnicianModel) request.getAttribute("technicianData");

//            int managerID = techieData.getManagerID();
                        int managerID = 1;
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            Date dob = Date.valueOf(request.getParameter("dob"));

            int roleID = Integer.parseInt(request.getParameter("roleID"));
            int labID = Integer.parseInt(request.getParameter("labID"));
            String password = request.getParameter("password");

//          System.out.println(managerID);
            //Save technician creds
            
//            working
            Authenticator authenticator = new Authenticator();
            int result = authenticator.createNewCredentials(email, password);

            TechnicianModel newTechnicianData = new TechnicianModel(managerID, firstName, lastName, gender, phone, email, address, dob, phone, roleID, labID);

            // save new technician information
            Manager manager = new Manager();

            int addResult = manager.addTechnician(newTechnicianData);

            
            // Forward the request to the labs.jsp for displaying the list
            response.sendRedirect("/nstock/technician");
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
