package views;

import controllers.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LabsModel;
import repositories.LabDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import models.TechnicianModel;
import utils.SessionManager;

public class labs extends HttpServlet {

    private List<String> allowedRoles = Arrays.asList("Manager");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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

            TechnicianModel user = SessionManager.getUser(sessionId);
            request.setAttribute("user", user);

            //            check if user has access to this page
            if (!(this.allowedRoles.contains(user.getRole().getRoleName()))) {
                response.sendRedirect("/nstock/unauthorized");
                   return;
            }

            // Get the list of labs from the database
            Connection connection = null;
            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                LabDAO labDAO = new LabDAO(connection);
                List<LabsModel> labsList = labDAO.getAllLabs();

                // Set the list of labs as a request attribute
                request.setAttribute("labs", labsList);

// Set content to display name
                request.setAttribute("contentName", "labList.jsp");

                // Forward the request to the labs.jsp for displaying the list
                request.getRequestDispatcher("base.jsp").forward(request, response);
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
        String editAction = request.getParameter("editAction");

        if (editAction != null && editAction.equals("editLab")) {
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
                if (rowsAffected > 0) {
                    // Lab updated successfully
                    request.setAttribute("lab", lab);
                    request.setAttribute("contentName", "editLab.jsp");
                    // Forward the request to the editLab.jsp for displaying the updated lab
                    request.getRequestDispatcher("base.jsp").forward(request, response);
                } else {
                    // Failed to update lab
                    response.getWriter().println("Failed to update lab. Please try again.");
                }
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
            // This is a delete request
            String deleteAction = request.getParameter("deleteAction");
            if (deleteAction != null && deleteAction.equals("deleteLab")) {
                int labID = Integer.parseInt(request.getParameter("labID"));

                // Delete the lab from the data source
                Connection connection = null;
                try {
                    DB_Connection dbConnection = new DB_Connection();
                    connection = dbConnection.connect();
                    LabDAO labDAO = new LabDAO(connection);
                    int rowsAffected = labDAO.deleteLab(labID);
                    if (rowsAffected > 0) {
                        // Lab deleted successfully
                        response.getWriter().println("Lab deleted successfully.");
                    } else {
                        // Failed to delete lab
                        response.getWriter().println("Failed to delete lab. Please try again.");
                    }
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
                processRequest(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
