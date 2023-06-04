package views;

import controllers.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemsModel;
import repositories.ItemDAO;
import utils.SessionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class editItem extends HttpServlet {




    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Code to retrieve item by ID and forward to the JSP
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

            if (itemId != null && !itemId.isEmpty() && itemName != null && itemDescription != null && faulty != null && labId != null) {
                try {
                    int itemID = Integer.parseInt(itemId);
                    boolean isFaulty = Boolean.parseBoolean(faulty);
                    int labID = Integer.parseInt(labId);

                    // Code to update the item in the database

                    response.sendRedirect("/nstock/items");
                    return;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    response.getWriter().println("Invalid item ID format");
                }
            } else {
                response.getWriter().println("Missing or invalid parameters");
            }
        } else {
            response.sendRedirect("/nstock/login");
        }
    }
}
