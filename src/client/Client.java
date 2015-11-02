package client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.omg.CORBA.portable.UnknownException;

public class Client implements Runnable{
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedInputStream in;
	public Client(String host, int port) {
		try {
			clientSocket = new Socket(host, port);
		} catch (UnknownException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		System.err.println("Lancement du traitement de connection cliente");
		while (!clientSocket.isClosed()) {
			try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedInputStream(clientSocket.getInputStream());
				String commande = "Coucou JeansJacques";
				out.write(commande);
				out.flush();
				System.out.println("Commande "+commande+" envoy�e au serveur");
				clientSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}
}


