// Buch Seite 736
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Pause;

/**
 *
 * @author Marcel Huber; letzte Änderung: 12.08.2017
 */
public class ThreadsWithYieldTester {

    public static void main(String[] args) {
        MyRunnableCounter r01 = new MyRunnableCounter();
        Thread t01 = new Thread(r01);
        Thread t02 = new Thread(r01);
        t02.start();
        Pause.breakInMillis(100);
        t01.start();
        while (t01.isAlive()) {
            t02.yield();
        }
        Pause.breakInSeconds(2);
        System.out.println("Der Zähler wurde insgesamt erhöht auf "
                + MyRunnableCounter.getCountEveryCall());
    }
}

class MyRunnableCounter implements Runnable {

    static private int countEveryCall;

    @Override
    public void run() {
        for (int k = 0; k < 5_000; k++) {
            System.out.println("Thread-Name: " + Thread.currentThread().getName()
                    + ", ID: " + Thread.currentThread().getId() + ", k = " + k);
            countEveryCall++;
        }
    }

    public static int getCountEveryCall() {
        return countEveryCall;
    }
}
