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
import java.util.Hashtable;
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
    private Hashtable<String, String> datas;

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
        datas = new Hashtable<String, String>();
    }

    /**
     * Methode permettant d'echanger des requetes avec le client et de les
     * traiter, tant que la connexion n'est pas fermée
     */
    public void run() {
        while(true){
            try {
                Socket socketClient = socketServer.accept();
                System.out.println("Connexion etablie");
                Thread process = new Thread(new RequestServeur(socketClient, datas));
                process.start();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        
        
            // Fermeture de la socket
       
//        try {
//            socketServer.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println("Socket serveur fermee.");
        
    }
}
