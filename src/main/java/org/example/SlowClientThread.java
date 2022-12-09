package org.example;

public class SlowClientThread extends ClientThread {

    public SlowClientThread(){
        setName("SlowClientThread");
    }

    @Override
    public void run() {
		while (true) {
            try {
                sync.acquire(10);
                System.out.println(this.getName() + " has gotton into the semaphore");
                sendMessageToServer("Msg from slow thread.".getBytes());
                sync.release(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

		}
    }

}
