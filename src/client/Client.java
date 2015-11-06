package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.omg.CORBA.portable.UnknownException;

/**
 * 
 * @author Alexandre Cazala, Théo Donzelle
 * 
 *         Classe client, elle permet d'établir une connexion avec le serveur,
 *         d'échanger des données avec celui-ci et ainsi d'utiliser les services
 *         proposés par le serveur.
 */
public class Client implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedInputStream in;

    /**
     * .
     * 
     * @param host
     *            String contenant l'adresse IP du serveur auquel le client va
     *            essayer de se connecter
     * @param port
     *            Int contenant le port sur lequelle le client se connectera
     * 
     *            Constructeur du client qui etablie la connexion avec le
     *            serveur
     */
    public Client(String host, int port) {
        try {
            clientSocket = new Socket(host, port);
        } catch (UnknownException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode permettant d'echanger des requetes avec le serveur et de traiter
     * les réponses, tant que la connexion n'est pas fermée
     */
    public void run() {
        System.err.println("Lancement du traitement de connection cliente");
        while (!clientSocket.isClosed()) {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedInputStream(clientSocket.getInputStream());
                String commande = "Coucou JeansJacques";
                out.write(commande);
                out.flush();
                System.out.println("Commande " + commande
                        + " envoy�e au serveur");
                clientSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }
}
