/**
 * 
 */
package serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * @author Théo Donzelle
 *
 */
public class Serveur {
    
    public void run(){
        try {
            ServerSocket socketServer = new ServerSocket(4000);
            Socket socketduserveur = socketServer.accept();
            System.out.println("Connexion etablie");
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }
    
}
