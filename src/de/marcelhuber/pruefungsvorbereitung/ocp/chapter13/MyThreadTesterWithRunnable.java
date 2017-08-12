// Buch Seite 719 ff.
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; letzte Änderung: 12.08.2017
 */
public class MyThreadTesterWithRunnable {

    public static void main(String[] args) {
        MyThreadTesterWithRunnable dummyObject = new MyThreadTesterWithRunnable();
        dummyObject.go01();
        dummyObject.go02();
    }

    private void go01() {
        CounterWithRunnable runnable01 = new CounterWithRunnable();
        CounterWithRunnable runnable02 = new CounterWithRunnable();
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(runnable01);
        threads[1] = new Thread(runnable02);
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private void go02() {
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("go02()-Methode: Problem: Threads haben das selbe "
                + "Runnable-Object, sind hier also\nnicht durch das Runnable-"
                + "Objekt unterscheidbar!");
        Marker.marker('_');
        Marker.marker('_');
        CounterWithRunnable runnable = new CounterWithRunnable();
        Thread[] threads = new Thread[2];
        threads[0] = new Thread(runnable);
        threads[1] = new Thread(runnable);
        for (Thread thread : threads) {
            thread.start();
        }
    }
}

class CounterWithRunnable implements Runnable {

    static private int threadID;
    private final int thisThreadID;

    {
        threadID++;
        thisThreadID = threadID;
    }

    private int j;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("");
            Marker.marker('-');
            System.out.println("Erster Aufruf eines neuen Threads!");
            Marker.marker('-');
        }
        for (int k = 0; k < 1000; k++) {
            ++j;
            System.out.println("Runnable-Nummer: " + thisThreadID + ", j = " + j);
//            System.out.println("k = " + k);
            System.out.println(Thread.currentThread());
        }
    }
}
