package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FeedbackClientModel {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12222;

    public String sendFeedback(String maDocGia, String tenDocGia, String noiDung) {
        StringBuilder response = new StringBuilder();
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(maDocGia);
            out.println(tenDocGia);
            out.println(noiDung);

            response.append(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}
