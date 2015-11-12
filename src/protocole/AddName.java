package protocole;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Requete demandant l'ajout d'un nom avec une liste de surnoms associes
 * @author Alexandre CAZALA, Theo DONZELLE
 *
 */
public class AddName extends Request{
	private String name;
	private Vector<String> nicknames;
	private static final long serialVersionUID = 5244755485259461250L;
	
	public AddName (String name, Vector<String> nicknames) {
		this.name = name;
		this.nicknames = nicknames;
	}
	
	@Override
	public int exec(Hashtable<String, String> datas) {
		for (String nickname : nicknames) {
			if (datas.containsKey(nickname))
				status += "ERREUR : Le nom " + nickname + " existe deja \n";
			else {
				datas.put(nickname, name);
				status += "SUCCESS : Association de " + name + " a " + nickname + "reussie\n";
			}
		}
		return 0;
	}
}
