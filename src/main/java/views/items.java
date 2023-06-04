package views;

import controllers.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemsModel;
import repositories.ItemDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.TechnicianModel;
import utils.SessionManager;

public class items extends HttpServlet {

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

            // Get the list of items from the database
            Connection connection = null;

            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                ItemDAO itemDAO = new ItemDAO(connection);

                List<ItemsModel> itemsList = null;
                if (user.getRole().getRoleName() == "Manager") {
                    itemsList = itemDAO.getAllItems();
                } else {
                    itemsList = itemDAO.getAllItemsPerLabID(user.getLabID());
                }

                // Set the list of items as a request attribute
                request.setAttribute("items", itemsList);

                // Set the content to display name
                request.setAttribute("contentName", "items.jsp");

                // Forward the request to the base.jsp for displaying the list
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
            // User is not authenticated, redirect to the login page or return an error response
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
