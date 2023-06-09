package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemsModel;
import repositories.ItemDAO;
import controllers.DB_Connection;
import jakarta.servlet.http.Cookie;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import models.ItemTypeModel;
import models.LabsModel;
import models.SpecificationModel;
import models.TechnicianModel;
import repositories.LabDAO;
import repositories.TechnicianDAO;
import utils.SessionManager;

public class newItem extends HttpServlet {
    
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
           
            TechnicianModel userData = SessionManager.getUser(sessionId);
//            request.setAttribute("user", userData);
            
            request.setAttribute("contentName", "newItem.jsp");
            // Handle POST request to add a new item
            if (request.getMethod().equalsIgnoreCase("POST")) {
                // Retrieve form data
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                String photo = request.getParameter("photo");
                String serialNumber = request.getParameter("serialNumber");
                boolean isFaulty = Boolean.parseBoolean(request.getParameter("faulty"));
                String labID = request.getParameter("labID");
                int typeID = Integer.parseInt(request.getParameter("itemType"));
                
//                person who added this item
                int managerID = userData.getManagerID();
//                int specID = Integer.parseInt(request.getParameter("specID"));


                

                // Create a new ItemsModel object with the form data
                ItemsModel newItem = new ItemsModel();
                newItem.setName(name);
                newItem.setDescription(description);
                newItem.setPhoto(photo);
                newItem.setSerialNumber(serialNumber);
                newItem.setFaulty(isFaulty);
                newItem.setTypeID(typeID);
                
                newItem.setLabID(labID != null ? Integer.parseInt(labID) : userData.getLabID());
                
                newItem.setManagerID(managerID);
//                newItem.setSpecID(specID);

                // Insert the new item into the database using the ItemDAO
                try {
                    DB_Connection dbConnection = new DB_Connection();
                    ItemDAO itemDAO = new ItemDAO(dbConnection.connect());
                    
                    int rowsAffected = itemDAO.insertItem(newItem);
                    
                    if (rowsAffected > 0) {
                        // Item added successfully
                        response.sendRedirect("/nstock/items");
                    } else {
                        // Failed to add item
                        response.getWriter().println("Failed to add item");
                    }
                } catch (Exception e) {
                    response.getWriter().println("An error occurred " + e.getMessage());
                }
            } else {
                // Handle GET request for displaying the form

                try {
                    
                    DB_Connection dbConnection = new DB_Connection();
                    Connection connection = dbConnection.connect();
                    
                    ItemDAO itemDAO = new ItemDAO(connection);
                    LabDAO labDAO = new LabDAO(connection);
                    TechnicianDAO technicians = new TechnicianDAO(connection);

                    // Retrieve data for dropdown lists
                    List<LabsModel> labList = labDAO.getAllLabs();
                    List<TechnicianModel> managerList = technicians.getAllTechnicians();
                    List<SpecificationModel> specList = itemDAO.getAllSpecification();
                    List<ItemTypeModel> typesList = itemDAO.getAllItemTypes();

                    // Set the attributes to be used in the JSP
                    
//                    ID for manager is 1 ... Find a better way to do it than hardcode it
                    if(userData.getRoleID() == 1) {
                        request.setAttribute("labList", labList);
                    }
                    
                    request.setAttribute("managerList", managerList);
                    request.setAttribute("specList", specList);
                    request.setAttribute("typesList", typesList);

                    // Forward the request to the JSP for rendering
                    request.getRequestDispatcher("base.jsp").forward(request, response);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                    response.getWriter().println("An error occurred");
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
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
