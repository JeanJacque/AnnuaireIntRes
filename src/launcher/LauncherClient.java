package launcher;
import clientUDP.Client;
/**
 * @author Th�o Donzelle, Alexandre CAZALA
 * 
 * Fonction lan�ant le client
 */
public class LauncherClient {
    public static void main(String[] args) {
        int port = 4042;
        Client cli = new Client("10.212.100.252", port);
        cli.run();
    }
}
