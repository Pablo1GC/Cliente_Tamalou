package com.example.cliente_tamalou.socket;

import com.example.cliente_tamalou.controlador.GameFunctionality;
import com.example.cliente_tamalou.modelo.entidad.entidadesExtra.Utilidades;
import com.example.cliente_tamalou.socketEntities.Package;
import com.example.cliente_tamalou.socketEntities.PackageReader;
import com.example.cliente_tamalou.socketEntities.PackageWriter;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SignalManager extends Thread {


    private PrintStream writer;

    private GameFunctionality game;


    public PackageReader reader;
    public PackageWriter writter;


    public SignalManager(Scanner reader, PrintStream writer, GameFunctionality game, Socket socket) throws IOException {
        this.writer = writer;
        this.game = game;
        this.reader = new PackageReader(new Scanner(socket.getInputStream()));
        this.writter = new PackageWriter(socket.getOutputStream());
    }

    @Override
    public void run() {

        do {
            try {
                Package pack = reader.readPackage();
                System.out.println(pack);
                int signal = pack.signal;


                switch (signal) {
                    // GAME CASES
                    case Signal.PLAYER_JOINED_GAME -> playerJoinedGame(pack.data.getAsInt());
                    case Signal.START_GAME -> startGame(pack.data.getAsJsonObject());
                    case Signal.END_GAME -> endGame(pack.data.getAsString());

                    // ROUND CASES
                    case Signal.START_TURN -> startYourTurn();
                    case Signal.OTHER_PLAYER_TURN -> startOtherPlayerTurn(pack.data.getAsString());
                    case Signal.SHOW_LAST_CARD_DISCARTED -> seeLastCardDiscarted(pack.data.getAsString());
                    case Signal.ASK_PLAYER_TO_STAND -> askToStand();
                    case Signal.OTHER_PLAYER_STANDS -> otherPlayerStanded(pack.data.getAsString());
                    case Signal.ASK_PLAYER_SELECT_PLAY -> selectPlay();
                    case Signal.SHOW_LAST_CARD_DECK -> seeLastCardDeck(pack.data.getAsString());
                    case Signal.ASK_PLAYER_SELECT_PLAY_2 -> selectPlay2(pack.data.getAsInt());
                    case Signal.PLAYER_DISCARDS_CARD -> cardIsDiscarted(pack.data.getAsString());
                    case Signal.ASK_PLAYER_SELECT_CARD -> chooseOneOfYourCards();
                    case Signal.OTHER_PLAYER_SEES_CARD ->  otherPlayerSeesCard(pack.data.getAsString(), pack.data.getAsInt());
                    case Signal.PLAYER_SWITCH_CARD_DECK -> playerSwitchedCardDeck(pack.data.getAsString(), pack.data.getAsInt());
                    case Signal.PLAYER_SEES_OWN_CARD -> playerSeesOwnCard(pack.data.getAsJsonObject());
                    case Signal.ASK_PLAYER_SELECT_OPONENT -> selectOponent();
                    case Signal.ASK_PLAYER_SELECT_OPONENT_CARD -> selectOpopnentCard(pack.data.getAsString());
                    case Signal.PLAYER_SWITCH_CARD_PLAYER -> playerSwitchCardPlayer(pack.data.getAsJsonObject());

                    /*
                    case Signal.ENVIAR_NOMBRE:                       manejarEnviarNombre();              break;
                    case Signal.CONEXION_EXITOSA:                    manejarConexionExitosa();           break;
                    case Signal.ENVIAR_SELECCION:                    manejarEnviarSeleccion();           break;
                    case Signal.GANADOR_DE_RONDA:                    manejarRondaGanada();               break;
                    case Signal.PERDEDOR_DE_RONDA:                   manejarRondaPerdida();              break;
                    case Signal.PERDEDOR_DE_TORNEO:                  manejarPerderTorneo();              break;
                    case Signal.EMPATE:                              manejarEmpate();                    break;
                    case Signal.GANADOR_DE_ENFRENTAMIENTO:           manejarEnfrentamientoGanado();      break;
                    case Signal.PERDEDOR_DE_ENFRENTAMIENTO:          manejarEnfrentamientoPerdido();     break;
                    case Signal.GANADOR_DE_TORNEO:                   manejarTorneoGanado();              break;
                    case Signal.PAQUETE_PUNTUACION:                  manejarObtenerPuntaje();            break;
                    case Signal.COMENZAR_PARTIDA_FINAL:              manejarComenzarPartidaFinal();      break;
                    case Signal.FINAL_DE_TORNEO:                     manejarFinalDeTorneo();             break;
                    case Signal.NOMBRE_GANADOR_DEL_ENFRENTAMIENTO:   manejarNombreGanadorEnf();          break;
                    case Signal.NOMBRE_GANADOR_DEL_TORNEO:           manejarNombreGanadorTor();          break;
                    case Signal.PREGUNTA_REVANCHA:                   manejarPreguntaRevancha();          break;
                    case Signal.JUGADORES_EN_LOBBY:                  manejarJugadoresEnLobby();          break;
                    case Signal.COMENZAR_TORNEO:                     manejarComenzarTorneo();            break;
                    case Signal.COMENZAR_ENFRENTAMIENTO:             manejarComenzarEnfrentamiento();    break;
                    case Signal.CONEXION_EXITOSA_TORNEO:             manejarConexionExitosaTorneo();     break;
                    case Signal.NOMBRE_DEL_RIVAL:                    manejarNombreDelRival();            break;
                    case Signal.CLAVE_TORNEO:                        manejarClaveTorneo();               break;
                    case Signal.LISTA_TORNEOS:                       manejarListaTorneos();              break;
                    //case Signal.NOMBRE_TORNEO:                       manejarNombreTorneo();              break;
                    case Signal.LOBBY_LLENO:                         manejarLobbyLleno();                break;
                    case Signal.ERROR:                               manejarError();                     break;

                     */
                }

            } catch (NoSuchElementException e) {
                System.out.println("Desconectado del servidor.");
                e.printStackTrace();
                break;
            }

        } while (true);
    }


    public void enviarSenal(int senal) {
        writter.packAndWrite(senal, "0gNvZ6L6DnP1LNoiPCQ6mlpom0j1");
    }

    private void startGame(JsonObject asJsonObject) {
    }

    private void endGame(String winner) {
        System.out.println("The winner is: " + winner);
    }


    public void playerJoinedGame(int data) {
        System.out.println("Player has join game, number of players: " + data + "/4");
    }

    private void startYourTurn() {
        System.out.println("Is your turn!");
    }

    private void startOtherPlayerTurn(String player) {
        System.out.println("Is " + player + "´s turn");
    }

    private void seeLastCardDiscarted(String card) {
        System.out.println("The last card discarted is: " + card);
    }

    private void askToStand() {
        System.out.println("Do you want to stand?");
        String answer = Utilidades.leerCadena();
        if (answer.equals("Yes"))
            writter.packAndWrite(Signal.PLAYER_STANDS);
    }

    private void otherPlayerStanded(String player) {
        System.out.println("Player " + player + " has standed.");
    }

    private void selectPlay() {
        int option;
        do {
            System.out.println("What do you want to do?");
            System.out.println("[1] Take a card of the deck.");
            System.out.println("[2] Discard one of your cards.");
            System.out.println("[3] Switch the card of the maze with one of your cards.");
            option = Utilidades.leerEntero("");
        } while (option < 1 || option > 3);
        writter.packAndWrite(0, option);
    }

    private void seeLastCardDeck(String card) {
        System.out.println("The card from the deck is: " + card);
    }

    private void selectPlay2(int value) {
        int option;
        int aux = 2;
        do {
            System.out.println("What do you want to do with the card?");
            System.out.println("[1] Discard the card.");
            System.out.println("[2] Change it for one of your cards.");
            if (value > 10) {
                System.out.println("[3] Use the power of the card.");
                aux = 3;
            }
            option = Utilidades.leerEntero("");
        } while (option < 1 || option > aux);

        writter.packAndWrite(0, option);
    }

    private void cardIsDiscarted(String card) {
        // HERE WE WILL SEND THE CARD THAT THE PLAYER TOOK FROM THE DECK TO THE DISCARTED CARDS
        System.out.println("Player has discarted the card: " + card);
    }

    private void chooseOneOfYourCards() {
        System.out.println("Select one of your cards");
        int index = Utilidades.leerEntero("");
        writter.packAndWrite(0, index);
    }

    private void otherPlayerSeesCard(String player, int index) {
        System.out.println("Player " + player + " has seen his card number: " + index);
    }

    private void playerSwitchedCardDeck(String player, int index) {
        System.out.println("Player " + player + " has switched his card number: " + index + " with the card of the deck.");
    }

    private void playerSeesOwnCard(JsonObject jsonObject) {
        int index = jsonObject.get("index").getAsInt();
        String card = jsonObject.get("card").getAsString();
        System.out.println("Your card number " + index + " is " + card);
    }

    private void selectOponent() {
        System.out.println("Select an oponent");
        // Implement how to show players Uid
        String oponentUid = Utilidades.leerCadena();
        writter.packAndWrite(0, oponentUid);
    }

    private void selectOpopnentCard(String player) {
        System.out.println("Select one card from " + player);
        int index  = Utilidades.leerEntero("");
        writter.packAndWrite(0, index);
    }

    private void playerSwitchCardPlayer(JsonObject jsonObject) {
        String player = jsonObject.get("player_uid").getAsString();
        int pCardIndex = jsonObject.get("p_card_index").getAsInt();
        String oponent = jsonObject.get("oponent_uid").getAsString();
        int oCardIndex = jsonObject.get("o_card_index").getAsInt();

        System.out.println("Player" + player + " has changed his card number: " + pCardIndex + " with player´s " + oponent + " card number: " + oCardIndex);
    }











    /*
 private void manejarPerderTorneo() {
     game.getGraphics().cambiarPantalla(game.getGraphics().getPantallaPerdedorTorneo());
 }

 private void manejarNombreTorneo() {
     String nombreDelTorneo = reader.nextLine();
     game.getGraphics().setNombreTorneo(nombreDelTorneo);
 }


 private void manejarClaveTorneo() {
     String clave = reader.nextLine();
     game.getGraphics().onClaveTorneo(clave);

 }

    public void enviarPaquete(String paquete) {
        writer.println(paquete);
    }

    public void enviarSenalDeConexion() {
        game.getGraphics().onConectando();
        writer.println(Senal.CONECTARSE);
    }

    public void manejarConexionExitosa() {
        System.out.println("Te has conectado!");
        game.getGraphics().onConexionExitosa();
    }

    public void manejarRondaGanada() {
        System.out.println("¡Has ganado la ronda!");
        game.getGraphics().getPantallaEnfrentamiento().onRondaGanada();
    }

    public void manejarRondaPerdida() {
        game.getGraphics().getPantallaEnfrentamiento().onRondaPerdida();
    }

    public void manejarEnfrentamientoGanado() {
        game.getGraphics().getPantallaEnfrentamiento().onEnfrentamientoGanado();
        game.actualizarContinuarPartida(false);
    }

    public void manejarEnfrentamientoPerdido() {
        game.getGraphics().getPantallaEnfrentamiento().onEnfrentamientoPerdido();
        game.actualizarContinuarPartida(false);
        game.actualizarContinuarTorneo(false);
    }

    public void manejarTorneoGanado() {
        System.out.println("¡Has ganado el torneo!");
        game.getGraphics().cambiarPantalla(game.graphics.getPantallaGanadorTorneo());
        game.actualizarContinuarPartida(false);
        game.actualizarContinuarTorneo(false);
    }

    public void manejarObtenerPuntaje() {
        // Obtener paquete puntaje

        String paquete = reader.nextLine();
        String[] puntajes_str = paquete.split("\\|");
        int[] puntajes = new int[puntajes_str.length];

        for (int i = 0; i < puntajes.length; i++)
            puntajes[i] = Integer.parseInt(puntajes_str[i]);

        game.getGraphics().getPantallaEnfrentamiento().onObtenerPuntaje(puntajes);
    }

    public void manejarEnviarNombre() {
        game.getGraphics().onEnviarNombre();
    }

    public void manejarFinalDeTorneo() {
        System.out.println("Terminó el torneo señores.");
        game.actualizarContinuarTorneo(false);
    }

    public void manejarComenzarPartidaFinal() {
        System.out.println("Has llegado a la final!");
        game.getGraphics().getPantallaEnfrentamiento().onEmpezarFinal();
    }

    public void manejarNombreGanadorEnf() {
        String ganador = reader.nextLine();
        System.out.println("El ganador del enfrentamiento es: " + ganador);
    }

    public void manejarNombreGanadorTor() {
        String ganador = reader.nextLine();
        System.out.println("El ganador del torneo es: " + ganador);
    }

    // Envía paquete
    public void manejarPreguntaRevancha() {

        Scanner sc = new Scanner(System.in);
        int senal = Senal.ERROR;
        do {
            System.out.println("El torneo ha terminado. Deseas volver a jugar?");
            System.out.print("Selección (S/n): ");

            try {
                String str = sc.nextLine();

                if (str.equalsIgnoreCase("S"))
                    senal = Senal.SI;
                else if (str.equalsIgnoreCase("N"))
                    senal = Senal.NO;

            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca una opción válida.");
            }
        } while (senal == Senal.ERROR);

        writer.println(senal);
    }

    public void manejarError() {
        System.out.println("Hubo un error.");
    }

    public void manejarJugadoresEnLobby() {
        String jugadores = reader.nextLine();
        game.getGraphics().onJugadoresEnLobby(jugadores);
        System.out.println("Jugadores en lobby: " + jugadores);
    }

    public void manejarComenzarEnfrentamiento() {
        System.out.println("Comienza el enfrentamiento!");
    }

    public void manejarComenzarTorneo() {
        System.out.println("Comienza el torneo!");
    }

    // Envía paquete
    public void manejarEnviarSeleccion() {
        game.getGraphics().onEnviarSeleccion();
    }

    private void manejarConexionExitosaTorneo() {
        game.getGraphics().onConexionExitosaTorneo();
    }

    private void manejarLobbyLleno() {
        System.out.println("El lobby se encuentra lleno en este momento, espere unos minutos para volver a ingresar");
    }

    private void manejarNombreDelRival() {
        String nombre = reader.nextLine();
        game.getGraphics().getPantallaEnfrentamiento().onNombreDelRival(nombre);
    }


    private void manejarListaTorneos() {
        int torneos = Integer.parseInt(reader.nextLine());
        System.out.println("Numero de torneos: " + torneos);

        String[] header = {"Nombre", "Cantidad de jugadores", "Clave"};
        DefaultTableModel modelo = new DefaultTableModel(header, 0);

        for (int i = 0; i < torneos; i++) {
            String datos = reader.nextLine();
            String[] datosSplit = datos.split("\\|");
            modelo.addRow(datosSplit);
            System.out.println("Datos recibidos: " + datos);
        }

        JTable table = new JTable(modelo);
        table.getColumnModel().getColumn(2).setMaxWidth(0); // Ocultar columna de clave
        game.getGraphics().getPantallaUnirseTorneo().onListaTorneoRecibida(table);

    }


    private void manejarEmpate() {
        game.getGraphics().getPantallaEnfrentamiento().onEmpate();
    }
*/
}

