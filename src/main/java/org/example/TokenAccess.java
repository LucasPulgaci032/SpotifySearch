package org.example;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class TokenAccess {
    private static String extractToken(String responseBody) {
        int start = responseBody.indexOf("\"access_token\":\"") + 16;
        int end = responseBody.indexOf("\"", start);
        return responseBody.substring(start, end);
    }
    public static String getAccesToken() throws IOException, InterruptedException {
        Dotenv dotenv = Dotenv.load();
        String clientId = dotenv.get("CLIENT_ID");
        String clientSecret = dotenv.get("CLIENT_SECRET");
        String credentials = clientId + ":" + clientSecret;
        String encoded = Base64.getEncoder().encodeToString(credentials.getBytes());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"))
                .header("Authorization","Basic " + encoded )
                .header("Content-Type","application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return extractToken(response.body());
    }


}
