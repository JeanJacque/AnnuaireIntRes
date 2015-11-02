/**
 * 
 */
package serveur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import client.Client;

/**
 * @author Théo Donzelle
 * 
 */
public class Serveur {
    private ServerSocket socketServer;
    private Socket socketduserveur;
    private BufferedReader in;
    private PrintWriter out;

    public Serveur(int port) {
        try {
            socketServer = new ServerSocket(port);
            socketduserveur = socketServer.accept();
            System.out.println("Connexion etablie");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
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
