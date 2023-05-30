/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import models.AuthenticationModel;
import models.TechnicianModel;
import repositories.AuthDAO;
import repositories.TechnicianDAO;
import utils.Utils;

/**
 *
 * @author iamdveloper
 */
public class Authenticator {
    // DB Connection

    private Connection conn = null;
    private AuthDAO auth = null;

    public Authenticator() {
        try {
            DB_Connection connection = new DB_Connection();
            this.conn = connection.connect();
            this.auth = new AuthDAO(this.conn);
        } catch (Exception e) {
            System.out.println("Database connection error: ");
            System.out.println(e.getMessage());
        }
    }

    public TechnicianModel login(String email, String password) throws Exception {
        try {

            AuthenticationModel user = auth.findUserByEmail(email);
            
            if (user != null) {
               
                if (Utils.comparePasswords(password, user.getPassword())) {
//                    Database connection here
                    DB_Connection dbConnection = new DB_Connection();
                    Connection connection = dbConnection.connect();

//                    get technician with that email
                    TechnicianDAO techDAO = new TechnicianDAO(connection);

                    return techDAO.getTechnicianByEmail(user.getEmail());
                }
//              
            }

            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int createNewCredentials(String email, String password) throws Exception {

        try {

            String hashedPassword = Utils.hashPassword(password);

            AuthenticationModel authModel = new AuthenticationModel(email, hashedPassword);

            int result = auth.insertNewTechnician(authModel);

            return result;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
