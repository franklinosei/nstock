/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author iamdveloper
 */
public class Utils {

    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();

        // Define the desired format for MySQL DATETIME
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the LocalDateTime object to the desired format
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
