/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
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

    public static String hashPassword(String password) {
        BCrypt.Hasher hasher = BCrypt.withDefaults();
        String hashedPassword = hasher.hashToString(12, password.toCharArray());
        return hashedPassword;
    }

    // Method to compare a password with a hashed password
    public static boolean comparePasswords(String password, String hashedPassword) {
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result result = verifyer.verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }
}
