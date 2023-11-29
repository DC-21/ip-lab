import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("deprecation")
public class UrlInfo {
    public static void main(String[] args) {
        try {
            // Set the URL of the server's homepage
            String urlString = "https://www.google.com"; // Replace with the desired URL
            URL url = new URL(urlString);

            // Connect to the server
            URLConnection connection = url.openConnection();

            // Display information about the homepage
            displayInfo(connection);

            // Download and display the homepage content
            downloadAndDisplayContent(connection);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayInfo(URLConnection connection) {
        // Display information about the homepage
        System.out.println("URL: " + connection.getURL());
        System.out.println("Date: " + new Date(connection.getDate()));
        System.out.println("Content Type: " + connection.getContentType());
        System.out.println("Expiration Date: " + new Date(connection.getExpiration()));
        System.out.println("Last Modified: " + new Date(connection.getLastModified()));
        System.out.println("Content Length: " + connection.getContentLength());
        System.out.println();
    }

    private static void downloadAndDisplayContent(URLConnection connection) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
