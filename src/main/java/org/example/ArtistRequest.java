package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ArtistRequest {
    public static String API_KEY = Dotenv.load().get("LAST_FM_API_KEY");
    public String findArtist(String artist){

       return URLEncoder.encode(artist, StandardCharsets.UTF_8);

    }

    public static Object searchArtist(String artistName) throws IOException, InterruptedException {
       ArtistRequest name = new ArtistRequest();
       String query = name.findArtist(artistName);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest artistRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + query + "&type=artist&limit=1" ))
                .header("Authorization","Bearer " + TokenAccess.getAccesToken())
                .GET()
                .build();
        HttpResponse<String> artistResponse = client.send(artistRequest,HttpResponse.BodyHandlers.ofString());
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
       var jsonData = gson.fromJson(artistResponse.body(), Object.class);
        System.out.println(jsonData);
        return jsonData;

    }

    public static String lastFmRequest(String artistName) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://ws.audioscrobbler.com/2.0/" +
                        "?method=artist.getInfo" +
                        "&artist=" + URLEncoder.encode(artistName, StandardCharsets.UTF_8) +
                        "&api_key=" + API_KEY +
                        "&format=json"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
