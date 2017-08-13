package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber; letzte Änderung: 13.08.2017
 */
public class TwoThreadsWithListTester {

    public static void main(String[] args) {
        TwoThreadsWithListTester dummyObject = new TwoThreadsWithListTester();
        dummyObject.go01();
    }

    private void go01() {
        ListAdderRunnable myRunnable = new ListAdderRunnable();
        Thread thr01 = new Thread(myRunnable, "Hans");
        Thread thr02 = new Thread(myRunnable, "Theo");
        thr01.start();
        thr02.start();
        try {
            thr01.join();
            thr02.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
        System.out.println("Counter:        " + myRunnable.getCounter());
        System.out.println("Size von namen: " + myRunnable.getNamen().size());
//        try {
//        Thread.sleep(1_000);
//        } catch (InterruptedException ex) {
//            System.err.println(ex);
//            ex.printStackTrace();
//        }
        System.out.println("Size von namen: " + myRunnable.getNamen().size());
    }
}

class ListAdderRunnable implements Runnable {

    private List<String> namen;
    private int counter;

    @Override
    public void run() {
        synchronized (this) {
            if (namen == null) {
                namen = new ArrayList<>();
            }
        }
        for (int k = 0; k < 1_000; k++) {
            synchronized (this) {
                namen.add(Thread.currentThread().getName());
                counter++;
            }
        }
    }

    public List<String> getNamen() {
        return namen;
    }

    public int getCounter() {
        return counter;
    }
}
