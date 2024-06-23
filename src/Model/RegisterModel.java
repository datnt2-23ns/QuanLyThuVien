package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterModel {

    public String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(Integer.toHexString(0xff & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void register(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        // Here you can add code to save the user to a database
        // For demonstration, we simply print the encrypted password
        System.out.println("Username: " + username + ", Encrypted Password: " + encryptedPassword);
    }
}
