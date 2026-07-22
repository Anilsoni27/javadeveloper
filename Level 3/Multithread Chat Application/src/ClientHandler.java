import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String username;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {

            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            out = new PrintWriter(
                    socket.getOutputStream(),
                    true);

            username = in.readLine();

            broadcast("🔵 " + username + " joined the chat.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {

        try {

            String message;

            while ((message = in.readLine()) != null) {

                broadcast(username + ": " + message);
            }

        } catch (IOException e) {

            System.out.println(username + " disconnected.");

        } finally {

            ChatServer.clients.remove(this);

            broadcast("🔴 " + username + " left the chat.");

            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }

    private void broadcast(String message) {

        System.out.println(message);

        for (ClientHandler client : ChatServer.clients) {
            client.out.println(message);
        }
    }
}