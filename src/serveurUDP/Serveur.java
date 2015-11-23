package serveurUDP;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
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
    private DatagramSocket socketServer;
    private byte[] receiveData;
    private byte[] sendData;
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
    public Serveur() {
        datas = new Hashtable<String, String>();
        try {
            socketServer = new DatagramSocket(4042);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        receiveData = new byte[1024];
        sendData = new byte[1024];
    }

    /**
     * Methode permettant d'echanger des requetes avec le client et de les
     * traiter, tant que la connexion n'est pas fermée
     */
    public void run() {
        ByteArrayInputStream b;
        ObjectInputStream o;
        Request r;
        
        while (true) {
            // Création du paquet pour effectuer la récéption
            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);
            
            // Récéption du paquet
            try {
                socketServer.receive(receivePacket);
                b = new ByteArrayInputStream(receivePacket.getData());
                o = new ObjectInputStream(b);
                r = (Request) o.readObject();
                r.exec(datas);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            String res = "";
            Set cles = datas.keySet();
            Iterator it = cles.iterator();
            while (it.hasNext()){
               String cle = (String) it.next();
               String valeur = datas.get(cle);
               res += "Name : " + cle + " Nickname : " + valeur + "\n";
            }
            
            System.out.println(res);
            
            // Récupération de l'IP et du Port pour l'envoi
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            // String -> bytes
            String capitalizedSentence = "Zboob";
            sendData = capitalizedSentence.getBytes();

            // Création du paquet à envoyer
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, port);
            
            // Envoi du paquet
            try {
                socketServer.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
