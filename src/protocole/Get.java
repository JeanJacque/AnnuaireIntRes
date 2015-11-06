package protocole;

import java.util.HashMap;
/**
 * La classe Get correspond � la requ�te client demandant la totalit� des surnoms et des noms
 * @author Alexandre CAZALA, Th�o Donzelle
 * 
 */
public class Get extends Request{
	
	private static final long serialVersionUID = 1584234089812003947L;
	private HashMap<String,String> datas;
	
	/**
	 * Constructeur par d�faut
	 * @author Alexandre CAZALA, Th�o Donzelle
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
	 * Copiera les donn�es du serveur dans l'attribut datas de la classe.
	 */
	@Override
	public void exec() {
		
	}

}
