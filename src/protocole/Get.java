package protocole;

import java.util.HashMap;
/**
 * La classe Get correspond à la requête client demandant la totalité des surnoms et des noms
 * @author Alexandre CAZALA, Théo Donzelle
 * 
 */
public class Get extends Request{
	
	private static final long serialVersionUID = 1584234089812003947L;
	private HashMap<String,String> datas;
	
	/**
	 * Constructeur par défaut
	 * @author Alexandre CAZALA, Théo Donzelle
	 */
	public Get() {
		
	}
	
	public void setDatas(HashMap<String, String> result) {
		datas = result;
	}
	
	public HashMap<String, String> getDatas() {
		return datas;
	}

	/**
	 * Copiera les données du serveur dans l'attribut datas de la classe.
	 */
	@Override
	public void exec() {
		
	}

}
