package org.example;

public class ToogleSwitch {
	private int turn = 0;
	
	synchronized public void waitForMyTurn(int myNumber) {
		while (turn != myNumber);
	}
	
	synchronized public void yourTurn() {
		turn = (turn + 1) % 2;
		System.out.println(turn);
	}
}
