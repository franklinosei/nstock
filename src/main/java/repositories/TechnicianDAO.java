/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;

/**
 *
 * @author iamdveloper
 */
public class TechnicianDAO {

    private Connection conn = null;

    public TechnicianDAO(Connection conn) {

        this.conn = conn;
    }
}
