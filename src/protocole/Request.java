package protocole;

import java.io.Serializable;

public abstract class Request implements Serializable{
	public abstract void exec();
}