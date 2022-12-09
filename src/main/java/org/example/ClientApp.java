package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientApp {

    public static void main(String[] args) throws InterruptedException {
        List<ClientThread> threads = new ArrayList<>(3);
        threads.add(new FastClientThread(0));
        threads.add(new FastClientThread(1));
        threads.add(new SlowClientThread());
        for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
            System.out.println(i);
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
