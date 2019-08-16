package quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QuotesApi {

            try {
        // https://www.baeldung.com/java-http-request
        URL url = new URL("http://swquotesapi.digitaljedi.dk/index.html");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        System.out.println(connection.getResponseCode());

        // synchronous: java is going to be working on running line 15 for a while
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);
    } catch (
    IOException e) {
        e.printStackTrace();
    }
}
}
