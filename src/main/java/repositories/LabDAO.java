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
public class LabDAO {

    private Connection conn = null;

    public LabDAO(Connection conn) {

        this.conn = conn;
    }
}
