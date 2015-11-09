package protocole;

import java.io.Serializable;
import java.util.HashMap;

/** 
 * 
 * @author Alexandre CAZALA, Theo DONZELLE
 * 
 * Classe mere des requetes, elle permet de les regrouper sous une meme classe.
 * Ainsi le serveur recuperera une Request et executera la methode exec (redefinie dans chaque classe).
 *
 */
public abstract class Request implements Serializable{
	private static final long serialVersionUID = -8618391044869076165L;
	/**
	 * @author Alexandre CAZALA, Theo DONZELLE
	 * 
	 * La methode exec est definie en abstract puisqu'elle sera implementee dans les classes filles.
	 * Elle correspond e ce qu'il faut faire pour "repondre" e la requete du client.
	 */
	public abstract void exec(HashMap<String, String> datas);
}