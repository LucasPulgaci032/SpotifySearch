package org.example;


import java.io.IOException;
import java.util.Scanner;


public class Main {
    String nome;

    public Main(String body){
        this.nome = body;
    }
    public Main(){

    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o nome do artista que deseja procurar:");
        Main name = new Main(sc.nextLine().trim());

        ArtistRequest artist = new ArtistRequest();
        artist.searchArtist(name.getNome());
        sc.close();
    }
}