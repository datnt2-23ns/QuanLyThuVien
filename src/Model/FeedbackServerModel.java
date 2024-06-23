package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeedbackServerModel {
    private static final int PORT = 12222;
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Feedback server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                pool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String maDocGia = in.readLine();
                String tenDocGia = in.readLine();
                String noiDung = in.readLine();

                // In a real scenario, this could be processed further
                // For this example, just echo back to client
                String response = "Mã Độc Giả: " + maDocGia + ", Tên Độc Giả: " + tenDocGia + ", Nội dung: " + noiDung;
                out.println(response);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
