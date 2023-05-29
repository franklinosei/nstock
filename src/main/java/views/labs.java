package views;

import controllers.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.LabsModel;
import repositories.LabDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class labs extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Get the list of labs from the database
        Connection connection = null;
        try {
            DB_Connection dbConnection = new DB_Connection();
            connection = dbConnection.connect();
            LabDAO labDAO = new LabDAO(connection);
            List<LabsModel> labsList = labDAO.getAllLabs();

            // Set the list of labs as a request attribute
            request.setAttribute("labs", labsList);

//            Set content to display name
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
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if it's an edit request
        String editAction = request.getParameter("editAction");
        if (editAction != null && editAction.equals("editLab")) {
            // Retrieve the edited lab data from request parameters
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

                    // Set the updated lab as a request attribute
                    request.setAttribute("lab", lab);
                    
//                    Content to display name
                    request.setAttribute("contentName", "editLab.jsp");
                    // Forward the request to the editLab.jsp for displaying the updated lab
                    request.getRequestDispatcher("editLab.jsp").forward(request, response);
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
            processRequest(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
