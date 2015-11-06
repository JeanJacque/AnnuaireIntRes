package launcher;

import serveur.Serveur;

public class LauncherServer {

	public static void main(String[] args) {
	
		int port = 4000;
		Serveur serv = new Serveur(port);
		serv.run();

	}

}
