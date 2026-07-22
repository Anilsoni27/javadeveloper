import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 5000);

            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            PrintWriter out =
                    new PrintWriter(
                            socket.getOutputStream(),
                            true);

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Username: ");
            String username = sc.nextLine();

            out.println(username);

            Thread receiveThread = new Thread(() -> {

                try {

                    String msg;

                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }

                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });

            receiveThread.start();

            System.out.println("Type messages below:");

            while (true) {

                String message = sc.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    socket.close();
                    break;
                }

                out.println(message);
            }

        } catch (IOException e) {

            System.out.println("Unable to connect to server.");
        }
    }
}