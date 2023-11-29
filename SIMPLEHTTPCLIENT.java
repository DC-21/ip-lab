import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class SIMPLEHTTPCLIENT {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("www.google.com", 80);
            OutputStream outputStream = socket.getOutputStream();

            // Send a simple HTTP GET request
            String httpRequest = "GET / HTTP/1.1\r\nHost: www.google.com\r\n\r\n";
            outputStream.write(httpRequest.getBytes());

            // Read and print the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
