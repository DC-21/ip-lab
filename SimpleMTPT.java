import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleMTPT {
    public static void main(String[] args) {
        try {
            // Connect to Gmail's SMTP server on port 587
            Socket socket = new Socket("smtp.gmail.com", 587);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            // Read the initial server response
            System.out.println("Server: " + in.readLine());

            // Send EHLO command
            out.println("EHLO example.com");
            System.out.println("Server: " + in.readLine());

            // Start TLS
            out.println("STARTTLS");
            System.out.println("Server: " + in.readLine());

            // Upgrade to secure connection
            socket = startTLS(socket);

            // Send HELO again after upgrading to secure connection
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out.println("EHLO example.com");
            System.out.println("Server: " + in.readLine());

            // Sending a QUIT command
            out.println("QUIT");
            System.out.println("Server: " + in.readLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Socket startTLS(Socket socket) throws IOException {
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        out.println("STARTTLS");

        // Upgrade to TLS
        return new Socket("smtp.gmail.com", 587);
    }
}
