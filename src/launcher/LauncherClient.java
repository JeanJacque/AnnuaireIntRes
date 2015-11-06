package launcher;
import client.Client;
import serveur.Serveur;

/**
 * @author Th�o Donzelle, Alexandre CAZALA
 * 
 * Fonction lan�ant le serveur
 */
public class LauncherClient {
    public static void main(String[] args) {
        int port = 4000;
        // Launcher cote serveur
//        Serveur serv = new Serveur(port);
//        serv.run();
        
        // Launcher cote client
        Client cli = new Client("10.212.100.252", port);
        cli.run();
    }
}