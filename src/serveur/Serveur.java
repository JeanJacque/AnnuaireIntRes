package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import client.Client;

/**
 * 
 * Classe serveur, elle permet d'établir avec un client, d'échanger des données
 * avec celui-ci et ainsi de permettre au client connecté d'utiliser les
 * services proposés.
 * 
 * @author Alexandre Cazala, Theo Donzelle
 * 
 */
public class Serveur {
    private ServerSocket socketServer;
    private Socket socketduserveur;
    private BufferedReader in;
    private PrintWriter out;

    /**
     * 
     * Constructeur du serveur qui etablie la connexion avec un serveur
     * 
     * @param port
     *            Int contenant le port sur lequelle le client pourra se
     *            connecter
     * 
     */
    public Serveur(int port) {
        try {
            socketServer = new ServerSocket(port);
            socketduserveur = socketServer.accept();
            System.out.println("Connexion etablie");
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    /**
     * Methode permettant d'echanger des requetes avec le client et de les
     * traiter, tant que la connexion n'est pas fermée
     */
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(
                    socketduserveur.getInputStream()));
            String message_distant = in.readLine();

            System.out.println(message_distant);
            socketduserveur.close();
            socketServer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
