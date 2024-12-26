import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost";  // Server IP or hostname
        int port = 5000;        // Port number for communication

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Connected to server: " + serverAddress + ":" + port);

            String userInput;
            while (true) {
                System.out.print("Enter message: ");
                userInput = scanner.nextLine();
                out.println(userInput);  // Send to server
                String serverResponse = in.readLine();
                System.out.println("Server says: " + serverResponse);
            }

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
