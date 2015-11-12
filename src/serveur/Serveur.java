package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import protocole.AddName;
import protocole.Request;

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
        int nb = 0;
        try {
        	socketduserveur = socketServer.accept();
            System.out.println("Connexion etablie");
            Request r;
            // Flux d'entree
            InputStream is = socketduserveur.getInputStream(); 
            ObjectInputStream ois = new ObjectInputStream(is);
            // Flux de sortie
            OutputStream os = socketduserveur.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            // Boucle d'envoie et de reception de requetes
            while(ois != null){
                r = (Request) ois.readObject();
                r.exec(datas);
                oos.writeObject(r);
                nb++;
            }
        } catch (IOException e) {
            System.err.println("Connexion interrompue par le client. (Requetes executees : " + nb + ")");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socketduserveur.close();
                socketServer.close();
                System.out.println("Socket fermee.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
