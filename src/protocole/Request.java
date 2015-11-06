package protocole;

import java.io.Serializable;

/** 
 * 
 * @author Alexandre CAZALA, Th�o DONZELLE
 * 
 * Classe m�re des requ�tes, elle permet de les regrouper sous une m�me classe.
 * Ainsi le serveur r�cup�rera une Request et executera la m�thode exec (red�finie dans chaque classe).
 *
 */
public abstract class Request implements Serializable{
	private static final long serialVersionUID = -8618391044869076165L;
	
	/**
	 * @author Alexandre CAZALA, Th�o DONZELLE
	 * 
	 * La m�thode exec est d�finie en abstract puisqu'elle sera impl�ment�e dans les classes filles.
	 * Elle correspond � ce qu'il faut faire pour "r�pondre" � la requ�te du client.
	 */
	public abstract void exec();
}