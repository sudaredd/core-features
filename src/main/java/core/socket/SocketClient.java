package core.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

public class SocketClient {

	private int port;
	static private final Logger log = Logger.getLogger(SocketClient.class);
	 
	public SocketClient(int port) {
		this.port = port;
	}
	
	public void sendRequest(String msg) {
		try {
			InetAddress IP = InetAddress.getLocalHost();
			log.info("IP of my system is := " + IP.getHostAddress());
			String serverName = IP.getHostAddress();
			log.info("Connecting to " + serverName + " on port "+ port);
			Socket client = new Socket(serverName, port);
			log.info("Just connected to "
					+ client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF(msg);
			
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			log.info("Server says " + in.readUTF());

			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
