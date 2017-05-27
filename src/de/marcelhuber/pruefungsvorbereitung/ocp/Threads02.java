package de.marcelhuber.pruefungsvorbereitung.ocp;

import de.marcelhuber.systemtools.PressEnter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class Threads02 {

    private Integer i;
    private Integer j;
    private long time;

    public static void main(String[] args) {
        new Threads02().go();
    }

    void go() {
        long endNumber = 1_000;
        Thread thread01 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int k = 0; k < endNumber; k++) {
                    i = k;
                    System.out.println("---------- k = " + k);
                }
            }
        });
        thread01.start();
        time = System.nanoTime();
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                time = System.nanoTime() - time;
                System.out.printf("Thread02 legt nach %3.2f Sekunden los!%n", time / Math.pow(10, 9));
                for (int m = 0; m < endNumber; m++) {
                    j = m;
                    System.out.println("m = " + m);
                }
            }
        });
//        try {
//            thread01.join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Threads02.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println("Thread01 lebt: " + thread01.isAlive());
        if (thread01.isAlive()) {
            thread02.start();
        }
        new MyThread().start();
        while (thread02.isAlive()) {
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        long counter = 0;
        while (counter < 1_000) {
            System.out.println("counter = " + ++counter);
//            PressEnter.toContinue();
        }
    }
}
