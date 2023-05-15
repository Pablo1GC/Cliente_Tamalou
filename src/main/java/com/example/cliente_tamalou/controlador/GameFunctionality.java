package com.example.cliente_tamalou.controlador;

import com.example.cliente_tamalou.socket.SignalManager;


import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class GameFunctionality {


    SignalManager signalManager;

    private boolean continuarPartida;
    private boolean continuarTorneo;

    private String claveTorneo = null;

    private String nombreDelJugador = null;

    private String nombreTorneo;


    public void actualizarContinuarPartida(boolean continuar){
        this.continuarPartida = continuar;
    }

    public void actualizarContinuarTorneo(boolean continuar) {
        this.continuarTorneo = continuar;
    }



    public void setClaveTorneo(String clave) {
        this.claveTorneo = clave;
    }

}