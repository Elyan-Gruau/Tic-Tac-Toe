package gameEngine;


import player.Player;

public class WaitThread extends Thread {
    Player p ;
    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 0;
        while (true) {
            System.out.println(this.getName() + ": New Thread is running..." + i++);
            try {
                //Wait for one sec so it doesn't print too fast
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitUntilDone();
        }
    }
    public WaitThread(Player p){
        this.p = p;
    }

    public synchronized void waitUntilDone() {
        while (p.getChoice() == -2) {
            System.out.println("ok");
            try {
                this.wait();

            } catch (InterruptedException ignore) {
                // log.debug("interrupted: " + ignore.getMessage());
            }
        }
    }
}
