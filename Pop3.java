import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Pop3 {
    public static void main(String[] args) {
        try {
            String pop3Server = "pop.mailtrap.io";
            int port = 11000; // Mailtrap POP3 port

            Socket socket = new Socket(pop3Server, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read the server greeting
            String greeting = in.readLine();
            System.out.println("Server greeting: " + greeting);

            // Sending a simple POP3 USER command
            out.println("USER your_username"); // Replace with your username
            String userResponse = in.readLine();
            System.out.println("USER response: " + userResponse);

            // Sending a QUIT command
            out.println("QUIT");
            String quitResponse = in.readLine();
            System.out.println("QUIT response: " + quitResponse);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
