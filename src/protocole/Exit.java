package protocole;

import java.util.HashMap;

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
	public void exec(HashMap<String, String> datas) {
		// TODO Auto-generated method stub
		
	}

}
