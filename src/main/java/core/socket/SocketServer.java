package core.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import core.util.StringUtil;
import org.apache.log4j.Logger;

public class SocketServer implements Runnable {
	
	static private final Logger log = Logger.getLogger(SocketServer.class);

	private int port;
	private ServerSocket serverSocket;
	private boolean flag = true;
	private static boolean isShutdownReq = false;
	
	public static void main(String[] args) throws IOException {
		SocketServer socketServer = new SocketServer(1021);
		SocketClient client = new SocketClient(1021);
		client.sendRequest("shutdown");
		if(socketServer.isShutdownReq()) socketServer.stop();
	}
	public SocketServer(int port) throws IOException {
		init(port);
	}
	
	public void init(int port) throws IOException {
		try {
			this.port=port;
			serverSocket = new ServerSocket(port);
			Thread t = new Thread(this);
			t.start();
		} catch (IOException e) {
			log.error("error occured while starting socket server");
			e.printStackTrace();
			throw e;
		}
	}
	
	private void startService() {
		while (flag) {
			try {
				log.info("Waiting for client on port "
						+ serverSocket.getLocalPort() + "...");
				Socket server = serverSocket.accept();
				log.info("Just connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				String inMsg = in.readUTF();
				if (StringUtil.equalsIgnoreCase("shutdown", inMsg)) {
					isShutdownReq = true;
				}
				log.info(inMsg);
				DataOutputStream out = new DataOutputStream(
						server.getOutputStream());
				out.writeUTF("Thank you for connecting to "
						+ server.getLocalSocketAddress() + "\nGoodbye!");
				server.close();
				TimeUnit.SECONDS.sleep(1);
			} catch (SocketTimeoutException s) {
				log.error("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
			try {
				serverSocket.close();
				log.info("server socket will be closed to listen request.....");
	          	flag = false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static boolean isShutdownReq() {
		return isShutdownReq;
	}

	public void run() {
		startService();
	}
}
