package serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Hashtable;

import protocole.Request;

/**
 * @author Théo Donzelle
 * 
 */
public class RequestServeur implements Runnable {

    private Socket socket;
    private Hashtable<String, String> datas;
    private InputStream is;
    private ObjectInputStream ois;
    private OutputStream os;
    private ObjectOutputStream oos;

    public RequestServeur(Socket s, Hashtable<String, String> d) {
        this.socket = s;
        this.datas = d;
        try {
            // Flux d'entree
            is = socket.getInputStream();
            ois = new ObjectInputStream(is);
            // Flux de sortie
            os = socket.getOutputStream();
            oos = new ObjectOutputStream(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        int nb = 0;

        // Boucle d'envoie et de reception de requetes
        try {
            Request r;
            while ((r = (Request) ois.readObject()) != null) {
                r.exec(datas);
                oos.writeObject(r);
                nb++;
            }
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Fermeture de la socket
        try {
            socket.close();
            System.out.println("Socket fermee.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
