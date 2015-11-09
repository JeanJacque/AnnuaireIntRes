package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import protocole.Exit;
import protocole.Request;
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
    private HashMap<String, String> datas;

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
        } catch (IOException e) {
            System.err.println(e);
        }
        datas = new HashMap<String, String>();
    }

    /**
     * Methode permettant d'echanger des requetes avec le client et de les
     * traiter, tant que la connexion n'est pas fermée
     */
    public void run() {
        try {
        	socketduserveur = socketServer.accept();
            System.out.println("Connexion etablie");
            Request r;
            int nb = 0;
            do {
	            InputStream is = socketduserveur.getInputStream(); 
	            ObjectInputStream ois = new ObjectInputStream(is);
	            
	            r = (Request) ois.readObject();
	            nb++;
            } while (r.exec(datas) < 0);
            System.out.println("Connexion finie !! ("  + nb + " requetes)");
            socketduserveur.close();
            socketServer.close();
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
