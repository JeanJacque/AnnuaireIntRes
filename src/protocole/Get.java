package protocole;

import java.util.HashMap;

public class Get extends Request{
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
