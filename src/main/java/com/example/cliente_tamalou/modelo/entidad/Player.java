package com.example.cliente_tamalou.modelo.entidad;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a user entity in the application.
 *
 * This class is an entity mapped to the "user" table in the database.
 * It contains information about a user, such as their unique identifier,
 * email, username, and profile image.
 * Also is used to manage the player in the game.
 */

public class Player {

    private String uid;

    private String email;

    private String username;

    private byte[] image;


    public String name;



    public Socket socket;

    public Scanner reader;

    public PrintStream writter;


    public Player() {
    }

    /**
     * Initializes the player with their name, 0 points, and initializes the array of cards they would have in their hand
     *
     * @param
     */
    public Player(Socket socket) throws IOException {
        this.socket = socket;
        this.reader = new Scanner(socket.getInputStream());
        this.writter = new PrintStream(socket.getOutputStream());
        this.name = name;

    }



    // Getters and Setters

    public String getUid() {
        return uid;
    }

    public void setUid(String id) {
        this.uid = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }


}