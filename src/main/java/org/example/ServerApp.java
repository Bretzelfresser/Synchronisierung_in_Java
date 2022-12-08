package org.example;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static final String SOCKET_NAME = "Penis";
	public static final int PORT = 4242;

	static final int MAX_MSG_SIZE = 1000;
	
	static public void printBuffer(byte[] buffer, int len) {
		String message = new String(buffer, 0, len);
		System.out.println(message);
	}
	
	public static void main(String[] args) throws IOException {
		byte[] buffer = new byte[MAX_MSG_SIZE];
		ServerSocket server = new ServerSocket(PORT);
		while (true) {
			int len = 0;
			Socket client = server.accept();
			System.out.println("server found a client");
			DataInputStream in = new DataInputStream(client.getInputStream());
			len = in.readInt();
			if (len >= MAX_MSG_SIZE)
				throw new IllegalStateException("length of String: " + len + " is higher then max String length");
			in.readFully(buffer, 0, len);
			// TODO: String mit maximaler Länge MAX_STR_LEN empfangen und in buffer speichern.

			in.close();
			printBuffer(buffer, len);
		}

		

	}

}
