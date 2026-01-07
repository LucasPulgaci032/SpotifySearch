package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ArtistRequest {
    public String findArtist(String artist){
       return URLEncoder.encode(artist, StandardCharsets.UTF_8);

    }

    public static void searchArtist(String artistName) throws IOException, InterruptedException {
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
        System.out.println(gson.toJson(jsonData));

    }

}
