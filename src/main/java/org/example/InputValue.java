package org.example;

import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/InputValue")
public class InputValue extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.setHeader("Access-Control-Allow-Origin", "*"); // para testes
       response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
       response.setHeader("Access-Control-Allow-Headers", "Content-Type");
       String artist = request.getParameter("artist");

       try {

           Object result = ArtistRequest.searchArtist(artist);
            Gson gson = new Gson();
           // Mostra o resultado no navegador
           String jsonResult = gson.toJson(result);
           response.getWriter().write(jsonResult);
       } catch (Exception e) {
           response.getWriter().write("{\"error\":\"" + e.getMessage() + "\"}");
       }



   }


}
