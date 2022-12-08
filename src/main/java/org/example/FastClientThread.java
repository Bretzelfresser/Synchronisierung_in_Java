package org.example;

public class FastClientThread extends ClientThread {
	

	
	protected int myNumber;
	
	public FastClientThread(int myNumber) {
		this.myNumber = myNumber;
	}
	
	@Override
	public void run() {
		while (true) {

			sendMessageToServer(("Msg from fast thread " + myNumber).getBytes());

		}
	}

}
