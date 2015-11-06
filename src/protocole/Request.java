package protocole;

import java.io.Serializable;

/** 
 * 
 * @author Alexandre CAZALA, Théo DONZELLE
 * 
 * Classe mère des requêtes, elle permet de les regrouper sous une même classe.
 * Ainsi le serveur récupèrera une Request et executera la méthode exec (redéfinie dans chaque classe).
 *
 */
public abstract class Request implements Serializable{
	private static final long serialVersionUID = -8618391044869076165L;
	
	/**
	 * @author Alexandre CAZALA, Théo DONZELLE
	 * 
	 * La méthode exec est définie en abstract puisqu'elle sera implémentée dans les classes filles.
	 * Elle correspond à ce qu'il faut faire pour "répondre" à la requête du client.
	 */
	public abstract void exec();
}