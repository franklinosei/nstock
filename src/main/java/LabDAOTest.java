import controllers.DB_Connection;
import repositories.LabDAO;
import models.LabsModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class LabDAOTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            DB_Connection dbConnection = new DB_Connection();
            connection = dbConnection.connect();
            LabDAO labDAO = new LabDAO(connection);
            List<LabsModel> labsList = labDAO.getAllLabs();

            // Print the retrieved labs
            for (LabsModel lab : labsList) {
                System.out.println("Lab ID: " + lab.getLabID());
                System.out.println("Lab Name: " + lab.getLabName());
                System.out.println("City: " + lab.getCity());
                System.out.println("Region: " + lab.getRegion());
                System.out.println("Photo: " + lab.getPhoto());
                System.out.println("Created At: " + lab.getCreatedAt());
                System.out.println("Updated At: " + lab.getUpdatedAt());
                System.out.println("----------------------------------");
            }
        } catch (Exception e) {
        } finally {
            // Close the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
