package launcher;
import serveur.Serveur;

/**
 * @author Th�o Donzelle, Alexandre CAZALA
 * 
 * Fonction lan�ant le serveur
 */
public class LauncherServer {
	public static void main(String[] args) {
		int port = 4042;
		Serveur serv = new Serveur(port);
		serv.run();
	}
}
