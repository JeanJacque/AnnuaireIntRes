package protocole;

import java.util.HashMap;
/**
 * La classe Get correspond e la requete client demandant la totalite des surnoms et des noms
 * @author Alexandre CAZALA, Theo Donzelle
 * 
 */
public class Get extends Request{
	
	private static final long serialVersionUID = 1584234089812003947L;
	private HashMap<String,String> datas;
	
	/**
	 * Constructeur par defaut
	 * @author Alexandre CAZALA, Theo Donzelle
	 */
	public Get() {
		
	}
	
	private void setDatas(HashMap<String, String> result) {
		datas = result;
	}
	
	public HashMap<String, String> getDatas() {
		return datas;
	}

	/**
	 * Copiera les donnees du serveur dans l'attribut datas de la classe.
	 */
	@Override
	public void exec() {
		
	}

}
