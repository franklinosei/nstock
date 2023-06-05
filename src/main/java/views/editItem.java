package views;

import controllers.DB_Connection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.SessionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import models.ItemsModel;
import models.TechnicianModel;
import repositories.ItemDAO;

public class editItem extends HttpServlet {

    private List<String> allowedRoles = Arrays.asList("Manager", "Technician");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Code to retrieve item by ID and forward to the JSP
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

            //        Content name to display
            request.setAttribute("contentName", "editItem.jsp");

            TechnicianModel user = SessionManager.getUser(sessionId);
            request.setAttribute("user", user);

            int itemId = Integer.parseInt(request.getParameter("id"));

          

            Connection connection = null;

            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();

                ItemDAO itemDAO = new ItemDAO(connection);

                ItemsModel item = itemDAO.getItemById(itemId);

                request.setAttribute("item", item);

            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred");
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

            RequestDispatcher rd = request.getRequestDispatcher("base.jsp");

            rd.forward(request, response);

        } else {
            response.sendRedirect("/nstock/login");
        }
    }

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
            String itemId = request.getParameter("itemId");
            String itemName = request.getParameter("itemName");
            String itemDescription = request.getParameter("itemDescription");
            String faulty = request.getParameter("faulty");
            String labId = request.getParameter("labID");
            String photo = request.getParameter("photo");
            
            Connection connection = null;

            try {
                int itemID = Integer.parseInt(itemId);
                boolean isFaulty = Boolean.parseBoolean(faulty);
                int labID = Integer.parseInt(labId);
                
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();

                ItemDAO itemDAO = new ItemDAO(connection);
                
                ItemsModel item = new ItemsModel();
                item.setItemID(itemID); 
                item.setName(itemName);
                item.setDescription(itemDescription);
                item.setFaulty(isFaulty);
                item.setLabID(labID);
                item.setPhoto(photo);

                int result = itemDAO.updateItem(item);


                // Code to update the item in the database
                response.sendRedirect("/nstock/items");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println(e.getMessage());
            }

        } else {
            response.sendRedirect("/nstock/login");
        }
    }
}
