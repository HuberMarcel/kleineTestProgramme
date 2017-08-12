// Buch Seite 717ff.
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

/**
 *
 * @author Marcel Huber; letzte Änderung: 12.08.2017
 */
public class MyThreadTesterWithExtendingThread {

    public static void main(String[] args) {
        MyThreadTesterWithExtendingThread dummyObject = new MyThreadTesterWithExtendingThread();
        dummyObject.go01();
    }

    private void go01() {
        MyThreadExtended thread01 = new MyThreadExtended();
        MyThreadExtended thread02 = new MyThreadExtended();
        thread01.start();
        thread02.start();
    }
}

class MyThreadExtended extends Thread {

    static private int threadID;
    private int thisThreadID;

    {
        threadID++;
        thisThreadID = threadID;
    }
    private int j;

    @Override
    public void run() {
        for (int k = 0; k < 100; k++) {
            System.out.println("Thread Nummer: " + thisThreadID + ", j = " + (++j));
        }
    }
}
