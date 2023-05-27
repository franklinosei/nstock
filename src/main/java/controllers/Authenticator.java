/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.Connection;
import models.AuthenticationModel;
import models.TechnicianModel;
import repositories.AuthDAO;

/**
 *
 * @author iamdveloper
 */
public class Authenticator {
    // DB Connection

    private Connection conn = null;
    private DB_Connection connection = new DB_Connection();
    private AuthDAO auth = null;

    public Authenticator() {
        try {
            this.conn = connection.connect();
            this.auth = new AuthDAO(this.conn);
        } catch (Exception e) {
            System.out.println("Database connection error: ");
            System.out.println(e.getMessage());
        }
    }

//    public TechnicianModel login(String email, String password) throws Exception {
//        try {
//
//            AuthenticationModel user = auth.findUserByEmail(email);
//            
//            if(user != null) {
////              
//            }
//            
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
}
