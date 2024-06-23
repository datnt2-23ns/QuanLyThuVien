import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class FeedbackServer {
    private static final int PORT = 12222;
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
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

                // Send feedback back to the client
                out.println("Mã Độc Giả: " + maDocGia + ", Tên Độc Giả: " + tenDocGia + ", Nội dung: " + noiDung);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}