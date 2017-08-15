package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Marker;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Marcel Huber; letzte Änderung: 14.08.2017
 */
public class MyThreadWaitAndNotifyTester {

    private double zeitMessung;
    private final Locale loc = Locale.GERMANY;
    private final NumberFormat nf = NumberFormat.getInstance(loc);

    public static void main(String[] args) {
        MyThreadWaitAndNotifyTester dummyObject = new MyThreadWaitAndNotifyTester();
        dummyObject.go01();
        dummyObject.go02();
        dummyObject.go03();
    }

    private void go01() {
        System.out.println("");
        System.out.println("---  go01()-Methode (with join()) ---");
        System.out.println("");
        System.out.println("");
        MyRunnableWithNotify myRunnable = new MyRunnableWithNotify();
        myRunnable.setLastNumber(10_000);
        Thread threadGo01 = new Thread(myRunnable);
        zeitMessung = System.nanoTime();
        threadGo01.start();
        try {
            threadGo01.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
        zeitMessung -= System.nanoTime();
        zeitMessung *= -1.0 / Math.pow(10, 9);
        System.out.println("Thread-Dauer [s]: " + nf.format(zeitMessung) + " !");
        System.out.println("Die Summe der ersten " + nf.format(myRunnable.getLastNumber())
                + " Zahlen ist: " + nf.format(myRunnable.getSumme()) + " !!!");
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
    }

    private void go02() {
        System.out.println("");
        System.out.println("---  go02()-Methode (with wait() and notify()) ---");
        System.out.println("");
        System.out.println("");
        MyRunnableWithNotify myRunnable = new MyRunnableWithNotify();
        myRunnable.setLastNumber(10_000);
        // die auskommentierte Zeile funktioniert nicht, weil wir darauf warten,
        // dass uns das myRunnable-Objekt Bescheid gibt, weitermachen zu können
//        myRunnable.setSynchronizationOnThread(true);
        Thread threadGo02 = new Thread(myRunnable);
        threadGo02.start();
        zeitMessung = System.nanoTime();
        synchronized (myRunnable) {
            try {
                // hier nicht den Thread, sondern das Runnable-Objekt
                // synchronizieren, denn dieses hat ja die run-Methode() !!!
//                threadGo01.wait();
                myRunnable.wait();
            } catch (InterruptedException ex) {
                System.err.println(ex);
                ex.printStackTrace();
            }
        }
        zeitMessung -= System.nanoTime();
        zeitMessung *= -1.0 / Math.pow(10, 9);
        System.out.println("Thread-Dauer [s]: " + nf.format(zeitMessung) + " !");
        System.out.println("Die Summe der ersten " + nf.format(myRunnable.getLastNumber())
                + " Zahlen ist: " + nf.format(myRunnable.getSumme()) + " !!!");
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
    }

    private void go03() {
        System.out.println("");
        System.out.println("---  go03()-Methode (with wait() and notify()) ---");
        System.out.println("");
        System.out.println("");
        MyRunnableWithNotify myRunnable = new MyRunnableWithNotify();
        myRunnable.setSynchronizationOnThread(true);
        // die folgende auskommentierte Zeile funktioniert hier genauso
//        myRunnable.setSynchronizationOnThread(false);
        myRunnable.setLastNumber(10_000);
        Thread threadGo03 = new Thread(myRunnable);
        threadGo03.start();
        zeitMessung = System.nanoTime();
        synchronized (threadGo03) {
            try {
                // hier nicht den Thread, sondern das Runnable-Objekt
                // synchronizieren, denn dieses hat ja die run-Methode() !!!
//                threadGo01.wait();
                // wenn oben myRunnable.setSynchronizationOnThread(false);
                // benutzt wurde, folgende Vermutung: 
                // nach Beendigung der run()-Methode ist auch Thread() zu
                // Ende und ruft dann automatisch "currentThread.notifyAll()"
                // auf?!
                threadGo03.wait();
            } catch (InterruptedException ex) {
                System.err.println(ex);
                ex.printStackTrace();
            }
        }
        zeitMessung -= System.nanoTime();
        zeitMessung *= -1.0 / Math.pow(10, 9);
        System.out.println("Thread-Dauer [s]: " + nf.format(zeitMessung) + " !");
        System.out.println("Die Summe der ersten " + nf.format(myRunnable.getLastNumber())
                + " Zahlen ist: " + nf.format(myRunnable.getSumme()) + " !!!");
        System.out.println("");
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("");
    }
}

class MyRunnableWithNotify implements Runnable {

    private long summe;
    private long lastNumber;
    private Thread thisThread;
    private boolean synchronizationOnThread;

    @Override
    public void run() {
        if (synchronizationOnThread) {
            synchronized (thisThread = Thread.currentThread()) {
                System.out.println("synchronized(thisThread)");
                for (long k = 0; k < lastNumber + 1; k++) {
                    summe += k;
                }
                thisThread.notify();
            }
        } else {
            // Synchronization auf dem aktuellen runnable-Objekt this
            synchronized (this) {
                System.out.println("synchronized(this)");
                for (long k = 0; k < lastNumber + 1; k++) {
                    summe += k;
                }
//                this.notify();
                notify();
            }
        }
    }

    public long getSumme() {
        return summe;
    }

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public boolean isSynchronizationOnThread() {
        return synchronizationOnThread;
    }

    public void setSynchronizationOnThread(boolean synchronizationOnThread) {
        this.synchronizationOnThread = synchronizationOnThread;
    }
}
