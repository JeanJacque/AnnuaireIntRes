package launcher;
import serveurUDP.Serveur;

/**
 * @author Th�o Donzelle, Alexandre CAZALA
 * 
 * Fonction lan�ant le serveur
 */
public class LauncherServer {
	public static void main(String[] args) {
		Serveur serv = new Serveur();
		serv.run();
	}
}
