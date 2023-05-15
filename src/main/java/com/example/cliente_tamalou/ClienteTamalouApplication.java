package com.example.cliente_tamalou;

import com.example.cliente_tamalou.controlador.GameFunctionality;
import com.example.cliente_tamalou.socket.Signal;
import com.example.cliente_tamalou.socket.SignalManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

@SpringBootApplication
public class ClienteTamalouApplication {
    public static final int PUERTO = 9191;
    public static final String IP_SERVER = "localhost";


    public static void main(String[] args) {
        SpringApplication.run(ClienteTamalouApplication.class, args);

        System.out.println("        APLICACIÓN CLIENTE         ");
        System.out.println("-----------------------------------");
        System.out.println("BIENVENIDO AL JUEGO DEL TAMALOU");

        InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);


        try {
            Socket socketAlServidor = new Socket();
            socketAlServidor.connect(direccionServidor);

            PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
            Scanner entrada = new Scanner(new InputStreamReader(socketAlServidor.getInputStream()));

            GameFunctionality game = new GameFunctionality();
            SignalManager manager = new SignalManager(entrada, salida, game, socketAlServidor);

            manager.enviarSenal(Signal.CONECTARSE);
            System.out.println("Enviada senal de conectarse");


            manager.start();
        } catch (UnknownHostException e) {
            System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
        } catch (ConnectException e){
            System.out.println("CLIENTE: Connection timed out.");
        } catch (IOException e) {
            System.err.println("CLIENTE: Error de entrada/salida");
        } catch (Exception e) {
            System.err.println("CLIENTE: Error -> " + e);
            e.printStackTrace();
        }
    }

    }


