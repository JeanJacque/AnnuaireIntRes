package protocole;

import java.io.Serializable;

public abstract class Request implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8618391044869076165L;

	public abstract void exec();
}