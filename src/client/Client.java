package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map.Entry;
import java.util.Vector;

import org.omg.CORBA.portable.UnknownException;

import protocole.AddName;
import protocole.GetAll;

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
    private OutputStream os;
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
        System.out.println("Lancement du traitement de connection cliente");
        System.out.println("=============================================\n");
        while (!clientSocket.isClosed()) {
            try {
            	os = clientSocket.getOutputStream();
            	ObjectOutputStream oos = new ObjectOutputStream(os);
            	InputStream is = clientSocket.getInputStream(); 
	            ObjectInputStream ois = new ObjectInputStream(is);
	            
            	Vector<String> ask = new Vector<String>();
            	ask.add("BunnyDunker");
            	ask.add("Trigunale");
            	oos.writeObject(new AddName("Alex", ask));
	            AddName a = (AddName) ois.readObject();
            	oos.writeObject(new GetAll());
            	
	            GetAll g = (GetAll) ois.readObject();
	            for(Entry<String, String> entry : g.getDatas().entrySet()) {
	                String cle = entry.getKey();
	                String valeur = entry.getValue();
	                System.out.println("Surnom : " + cle + "\t nom : "+valeur);
	            }
	            //            	oos.writeObject(new Exit());
                System.out.println("Commande envoyee au serveur");
                clientSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
