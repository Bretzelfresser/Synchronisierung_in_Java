package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientApp {

	public static void main(String[] args) throws InterruptedException {
		ClientThread t = new FastClientThread(2);
		t.start();
		Thread.sleep(3000);
		t.stop();
		Thread.sleep(20);
		/*
		List<ClientThread> threads = new ArrayList<>(3);
		threads.add(new FastClientThread(0));
		threads.add(new FastClientThread(1));
		threads.add(new SlowClientThread());
		threads.forEach(Thread::start);
		for (Thread t : threads){
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		 */

	}

}
