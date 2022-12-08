package org.example;

public class SlowClientThread extends ClientThread {

    @Override
    public void run() {
		while (true) {

			sendMessageToServer("Msg from slow thread.".getBytes());

		}
    }

}
