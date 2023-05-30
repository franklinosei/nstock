package views;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemsModel;
import repositories.ItemDAO;
import controllers.DB_Connection;

import java.io.IOException;
import java.util.List;
import models.LabsModel;
import models.SpecificationModel;
import models.TechnicianModel;

public class newItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Handle POST request to add a new item
        if (request.getMethod().equalsIgnoreCase("POST")) {
            // Retrieve form data
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String photo = request.getParameter("photo");
            String serialNumber = request.getParameter("serialNumber");
            int labID = Integer.parseInt(request.getParameter("labID"));
            int managerID = Integer.parseInt(request.getParameter("managerID"));
            int specID = Integer.parseInt(request.getParameter("specID"));

            // Create a new ItemsModel object with the form data
            ItemsModel newItem = new ItemsModel();
            newItem.setName(name);
            newItem.setDescription(description);
            newItem.setPhoto(photo);
            newItem.setSerialNumber(serialNumber);
            newItem.setLabID(labID);
            newItem.setManagerID(managerID);
            newItem.setSpecID(specID);

            // Insert the new item into the database using the ItemDAO
            try {
                DB_Connection dbConnection = new DB_Connection();
                ItemDAO itemDAO = new ItemDAO(dbConnection.connect());
                int rowsAffected = itemDAO.insertItem(newItem);

                if (rowsAffected > 0) {
                    // Item added successfully
                    response.sendRedirect("items");
                } else {
                    // Failed to add item
                    response.getWriter().println("Failed to add item");
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred");
            }
        } else {
            // Handle GET request for displaying the form

            try {
                DB_Connection dbConnection = new DB_Connection();
                ItemDAO itemDAO = new ItemDAO(dbConnection.connect());

                // Retrieve data for dropdown lists
                List<LabsModel> labList = itemDAO.getAllLabs();
                List<TechnicianModel> managerList = itemDAO.getAllTechnician();
                List<SpecificationModel> specList = itemDAO.getAllSpecification();

                // Set the attributes to be used in the JSP
                request.setAttribute("labList", labList);
                request.setAttribute("managerList", managerList);
                request.setAttribute("specList", specList);

                // Forward the request to the JSP for rendering
                request.getRequestDispatcher("newItem.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred");
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
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
