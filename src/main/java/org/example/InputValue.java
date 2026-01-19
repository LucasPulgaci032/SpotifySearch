package org.example;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/InputValue")
public class InputValue extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setHeader("Access-Control-Allow-Origin", "*"); // para testes
       response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
       response.setHeader("Access-Control-Allow-Headers", "Content-Type");
       String artist = request.getParameter("artist");

       try {
            Map<String,Object> mergedJson = new HashMap<>();
           Object result = ArtistRequest.searchArtist(artist);
           String lastFmResult = ArtistRequest.lastFmRequest(artist);

            Gson gson = new Gson();
           mergedJson.put("Spotify",result);
           mergedJson.put("lastFm",gson.fromJson(lastFmResult, Object.class));

           String jsonResult = gson.toJson(mergedJson);
           response.getWriter().write(jsonResult);
           response.setContentType("application/json;charset=UTF-8");
       } catch (Exception e) {
           response.getWriter().write("{\"error\":\"" + e.getMessage() + "\"}");
       }



   }


}
