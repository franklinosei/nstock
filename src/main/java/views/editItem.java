package views;

import controllers.DB_Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.ItemsModel;
import repositories.ItemDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.ItemTypeModel;
import models.LabsModel;
import models.SpecificationModel;
import models.TechnicianModel;

public class editItem extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemIdParam = request.getParameter("itemId");
        if (itemIdParam != null) {
            int itemId = Integer.parseInt(itemIdParam);

            Connection connection = null;
            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                ItemDAO itemDAO = new ItemDAO(connection);
                ItemsModel item = itemDAO.getItemById(itemId);
                
                
                
                    // Retrieve data for dropdown lists
//                    List<LabsModel> labList = labDAO.getAllLabs();
//                    List<TechnicianModel> managerList = technicians.getAllTechnicians();
                    List<SpecificationModel> specList = itemDAO.getAllSpecification();
                    List<ItemTypeModel> typesList = itemDAO.getAllItemTypes();
                
                 // Set the content to display name
                request.setAttribute("contentName", "editItems.jsp");

                if (item != null) {
                    // Set the item as a request attribute
                    request.setAttribute("item", item);
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred: " + e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // Forward the request to the editItem.jsp for displaying the item form
        request.getRequestDispatcher("base.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String itemIdParam = request.getParameter("itemId");
        String itemName = request.getParameter("itemName");
        String itemDescription = request.getParameter("itemDescription");
        String faulty = request.getParameter("faulty");
        String typeID = request.getParameter("typeID");
        String photo = request.getParameter("photo");
        String serialNumber = request.getParameter("serialNumber");
        String labID = request.getParameter("labID");
        String managerID = request.getParameter("managerID");
        String specID = request.getParameter("specID");

        if (itemIdParam != null && itemName != null && itemDescription != null && faulty != null && typeID != null
                && photo != null && serialNumber != null && labID != null && managerID != null && specID != null) {
            int itemId = Integer.parseInt(itemIdParam);

            Connection connection = null;
            try {
                DB_Connection dbConnection = new DB_Connection();
                connection = dbConnection.connect();
                ItemDAO itemDAO = new ItemDAO(connection);
                ItemsModel item = itemDAO.getItemById(itemId);

                if (item != null) {
                    // Update the item properties
                    item.setName(itemName);
                    item.setDescription(itemDescription);
                    boolean isFaulty = Boolean.parseBoolean(faulty);
                    int typeId = Integer.parseInt(typeID);
                    item.setFaulty(isFaulty);
                    item.setTypeID(typeId);
                    item.setPhoto(photo);
                    item.setSerialNumber(serialNumber);
                    int labId = Integer.parseInt(labID);
                    int managerId = Integer.parseInt(managerID);
                    int specId = Integer.parseInt(specID);
                    item.setLabID(labId);
                    item.setManagerID(managerId);
                    item.setSpecID(specId);

                    // Save the updated item
                    int updated = itemDAO.updateItem(item);

                    if (updated > 0) {
                        // Item updated successfully
                        response.sendRedirect("/nstock/items");
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("An error occurred: " + e.getMessage());
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        response.sendRedirect("/nstock/items");
    }

    public String getServletInfo() {
        return "Short description";
    }
}
