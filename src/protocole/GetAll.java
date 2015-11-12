package protocole;

import java.util.Hashtable;

/**
 * La classe Get correspond e la requete client demandant la totalite des
 * surnoms et des noms
 * 
 * @author Alexandre CAZALA, Theo Donzelle
 * 
 */
public class GetAll extends Request {

	private static final long serialVersionUID = 1584234089812003947L;
	private Hashtable<String, String> datas;

	/**
	 * Constructeur par defaut
	 * 
	 * @author Alexandre CAZALA, Theo Donzelle
	 */
	public GetAll() {

	}

	private void setDatas(Hashtable<String, String> result) {
		datas = result;
	}

	public Hashtable<String, String> getDatas() {
		return datas;

	}

	/**
	 * Copiera les donnees du serveur dans l'attribut datas de la classe.
	 */
	@Override
	public int exec(Hashtable<String, String> datas) {
		setDatas(datas);
		return 0;
	}

}
