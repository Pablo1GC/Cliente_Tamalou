package com.example.cliente_tamalou.socket;

public class Signal {

    // Signal indicating an error has occurred.
    public static final int ERROR = -1;

    // Signal indicating a negative response.
    public static final int NO = 0;

    // Signal indicating an affirmative response.
    public static final int YES = 1;

    // Signal indicating a connection.
    public static final int CONNECT = 299328;

    // Signal for sending a selection.
    public static final int SUCCESSFUL_CONNECTION = 58;




    // GAME SIGNALS
    // Signal indicating a player has joined the game.
    public static final int PLAYER_JOINED_GAME        = 21;
    // Signal indicating the game has started.
    public static final int START_GAME                = 22;
    public static final int END_GAME                  = 25;

    // ROUND SIGNALS
    // Signal indicating it's the player's turn to play.
    public static final int PLAYER_TURN_STARTS = 23;
    // Signal indicating it's the other player's turn to play.
    public static final int OTHER_PLAYER_TURN         = 24;
    // Signal indicating the end of a round.
    public static final int ROUND_END = 25;
    public static final int SHOW_LAST_CARD_DECK       = 132;
    public static final int SHOW_LAST_CARD_DISCARTED  = 133;
    public static final int ASK_PLAYER_TO_STAND       = 134;
    public static final int PLAYER_STANDS             = 135;
    public static final int OTHER_PLAYER_SEES_CARD = 136;
    public static final int PLAYER_DISCARDS_CARD      = 137;
    public static final int PLAYER_SWITCH_CARD_DECK   = 138;
    public static final int ASK_PLAYER_SELECT_OPONENT = 140;
    public static final int ASK_PLAYER_SELECT_PLAY    = 141;
    public static final int ASK_PLAYER_SELECT_PLAY_2  = 142;
    public static final int ASK_PLAYER_SWITCH_CARD    = 143;
    public static final int ASK_PLAYER_SELECT_CARD    = 144;
    public static final int PLAYER_POINTS_PENALTY     = 180;
    public static final int PLAYER_ONE_CARD_LESS      = 146;
    public static final int PLAYER_TURN_ENDED         = 147;
    public static final int PLAYER_CARDS_EMPTY        = 148;
    public static final int OTHER_PLAYER_STANDS       = 149;
    public static final int PLAYER_SEES_OWN_CARD      = 150;
    public static final int PLAYER_SEES_OPONENT_CARD      = 153;
    public static final int ASK_PLAYER_SELECT_OPONENT_CARD      = 151;
    public static final int PLAYER_SWITCH_CARD_PLAYER     = 145;

    public static final int CARD_DECK_TO_PLAYER       = 132;
    public static final int DISCARTED_DECK_IS_EMPTY   = 133;
    public static final int DECK_IS_EMPTY             = 134;
    public static final int HAND_IS_EMPTY             = 135;
    public static final int PLAYER_TAKE_CARD_DECK     = 132;
    public static final int PLAYER_SWITCH_CARD_DISCARTED_DECK   = 132;


    public static final int GANADOR_DE_RONDA          = 200;
    public static final int GANADOR_DE_ENFRENTAMIENTO = 201;
    public static final int GANADOR_DE_TORNEO         = 202;

    public static final int NOMBRE_GANADOR_DEL_ENFRENTAMIENTO = 493;

    public static final int NOMBRE_GANADOR_DEL_TORNEO = 494;

    public static final int PERDEDOR_DE_RONDA           = 203;
    public static final int PERDEDOR_DE_ENFRENTAMIENTO  = 204;
    public static final int PERDEDOR_DE_TORNEO          = 205;

    public static final int EMPATE                      = 207;

    public static final int PAQUETE_PUNTUACION          = 808;

    public static final int COMENZAR_PARTIDA_FINAL = 209;

    public static final int PREGUNTA_REVANCHA         = 666;

    public static final int SELECCION_INCORRECTA      = -2;

    public static final char SEPARADOR                 = '|';

    public static final int LOBBY_LLENO =               810;
    public static final int CONEXION_EXITOSA_TORNEO =   9030;

    public static final int DESCONECTADO               = 329;



    // Señales que puede enviar el cliente

    public static final int CREAR_TORNEO_PUBLICO            = 10001;
    public static final int CREAR_TORNEO_PRIVADO            = 10002;
    public static final int UNIRSE_TORNEO_PUBLICO           = 10003;
    public static final int UNIRSE_TORNEO_PRIVADO           = 10004;
    public static final int SOLICITAR_LISTA_TORNEOS         = 10005;


    // Señales con las que el servidor responde a esas peticiones

    public static final int TORNEO_LLENO                    = 20001;
    public static final int TORNEO_INEXISTENTE              = 20002;
    public static final int UNION_EXITOSA_TORNEO            = 20004;
    public static final int LISTA_TORNEOS                   = 20005;
    public static final int CLAVE_TORNEO                    = 20006;
    public static final int NOMBRE_TORNEO                   = 20007;
}