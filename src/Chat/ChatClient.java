package Chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws Exception {
        String serverAddress = "127.0.0.1"; // Địa chỉ IP của server
        Socket socket = new Socket(serverAddress, 59001);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(new IncomingReader()).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            out.println(scanner.nextLine());
        }
    }

    private static class IncomingReader implements Runnable {
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
