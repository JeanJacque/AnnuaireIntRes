package protocole;

import java.util.Hashtable;

/**
 * Requete de l'interruption de la connexion client-serveur
 * 
 * @author Alexandre CAZALA, Theo Donzelle
 */
public class Exit extends Request {
	private static final long serialVersionUID = -6857062390408723051L;
	
	/**
	 * Ferme la connexion avec le client du cote serveur
	 */
	@Override
	public int exec(Hashtable<String, String> datas) {
		System.out.println("Demande d'interruption de la connexion avec le client");
		return -1;
	}

}
