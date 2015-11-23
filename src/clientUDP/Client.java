package clientUDP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Vector;

import org.omg.CORBA.portable.UnknownException;

import protocole.AddName;

/**
 * 
 * @author Alexandre Cazala, Théo Donzelle
 * 
 *         Classe client, elle permet d'établir une connexion avec le serveur,
 *         d'échanger des données avec celui-ci et ainsi d'utiliser les services
 *         proposés par le serveur.
 */
public class Client implements Runnable {
    private DatagramSocket clientSocket;
    InetAddress IPAddress;
    int port;
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
            clientSocket = new DatagramSocket();
            IPAddress = InetAddress.getByName(host);
            this.port = port;
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
            	Vector<String> ask = new Vector<String>();
            	byte[] sendData = new byte[1024];
                byte[] incomingData = new byte[1024];
                ask.addElement("JeansJacques");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(outputStream);
                os.writeObject(new AddName("Th�o",ask));
                byte[] data = outputStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, port);
                clientSocket.send(sendPacket);
                System.out.println("Message sent from client");
                
                // CODE A RAJOUTER POUR LIRE
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
                clientSocket.receive(incomingPacket);
                System.out.println(new String(incomingPacket.getData()));
                
            	/*clientSocket.send(new AddName("Th�o", ask));
	            AddName a = (AddName) ois.readObject();
	            Thread.sleep(2000);
            	oos.writeObject(new GetAll());
            	
	            GetAll g = (GetAll) ois.readObject();
	            for(Entry<String, String> entry : g.getDatas().entrySet()) {
	                String cle = entry.getKey();
	                String valeur = entry.getValue();
	                System.out.println("Surnom : " + cle + "\t nom : "+valeur);
	            }
	            //            	oos.writeObject(new Exit());
                System.out.println("Commande envoyee au serveur");*/
                clientSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
