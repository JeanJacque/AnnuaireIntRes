package protocole;

import java.util.HashMap;

public class Get extends Request{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1584234089812003947L;
	private HashMap<String,String> datas;
	
	public Get() {
		
	}
	
	public void setDatas(HashMap<String, String> result) {
		datas = result;
	}
	
	public HashMap<String, String> getDatas() {
		return datas;
	}

	@Override
	public void exec() {
		
	}

}
