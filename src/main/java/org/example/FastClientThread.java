package org.example;

import javax.swing.*;

public class FastClientThread extends ClientThread {
	
	protected static ToogleSwitch toogleSwitch = new ToogleSwitch();
	
	protected int myNumber;
	
	public FastClientThread(int myNumber) {
		this.myNumber = myNumber;
		setName("Fast: " + myNumber);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				toogleSwitch.waitForMyTurn(myNumber);
				sync.acquire();
				System.out.println(Thread.currentThread().getName() + " is acquired");
				System.out.println(Thread.currentThread().getName() + " got beyond the borders");
				sendMessageToServer(("Msg from fast thread " + myNumber).getBytes());
				System.out.println(this.getName() + "send message");
				toogleSwitch.yourTurn();
				sync.release();
				System.out.println(this.getName() +  " released everything");
			} catch (InterruptedException e) {
				toogleSwitch.yourTurn();
				sync.release();
				e.printStackTrace();
			}

		}
	}

}
