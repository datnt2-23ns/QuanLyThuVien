package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginModel {

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

    public boolean authenticate(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return username.equals("admin") && encryptedPassword.equals(encryptPassword("admin"));
    }
}
