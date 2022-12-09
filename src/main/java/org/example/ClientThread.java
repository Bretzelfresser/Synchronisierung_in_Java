package org.example;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class ClientThread extends Thread{
	
protected static Semaphore sync = new Semaphore(10, true);
	
	protected void sendMessageToServer(byte[] msg) {
		if (msg.length >= ServerApp.MAX_MSG_SIZE)
			throw new IllegalArgumentException("message must not exceed length: " + ServerApp.MAX_MSG_SIZE);
		try {
			Socket s = new Socket("127.0.0.1", ServerApp.PORT);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeInt(msg.length);
			out.write(msg);
			out.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
