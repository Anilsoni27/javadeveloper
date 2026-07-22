import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("=================================");
            System.out.println("     CHAT SERVER STARTED");
            System.out.println("=================================");
            System.out.println("Listening on port 5000...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected: "
                        + socket.getInetAddress());

                ClientHandler client = new ClientHandler(socket);

                clients.add(client);

                Thread thread = new Thread(client);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}