package launcher;
import client.Client;
import serveur.Serveur;

/**
 * @author Th�o Donzelle, Alexandre CAZALA
 * 
 * Fonction lan�ant le client
 */
public class LauncherClient {
    public static void main(String[] args) {
        int port = 4042;
        Client cli = new Client("localhost", port);
        cli.run();
    }
}
