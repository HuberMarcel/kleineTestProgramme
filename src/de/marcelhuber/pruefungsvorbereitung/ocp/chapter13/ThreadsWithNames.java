// Buch Seite 719 ff., 722 ff.
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; letzte Änderung: 12.08.2017
 */
public class ThreadsWithNames {

    public static void main(String[] args) {
        ThreadsWithNames dummyObject = new ThreadsWithNames();
        dummyObject.go01();
        dummyObject.go02();
        dummyObject.go03();
    }

    private void go01() {
        MyRunnableTester myRunnable = new MyRunnableTester();
        Thread[] threads = new Thread[3];
        threads[0] = new Thread(myRunnable, "Pascal");
//        threads[0] = new Thread(myRunnable);
//        threads[0].setName("Pascal");
        threads[1] = new Thread(myRunnable, "Marcel");
        threads[2] = new Thread(myRunnable, "Sascha");
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private void go02() {
        System.out.println("");
        System.out.println("");
        System.out.println("go02()-Methode läuft an....");
        Marker.marker('_');
        Marker.marker('_');
        MyRunnableTester myRunnable = new MyRunnableTester();
        Thread[] threads = new Thread[3];
        // die folgende auskommentierte Deklaration scheint nicht zu funktionieren!
//        for (Thread thread : threads) {
//            thread = new Thread(myRunnable);
//        }
        for (int k = 0; k < threads.length; k++) {
            threads[k] = new Thread(myRunnable);
        }
        System.out.println(threads[0]);
//        PressEnter.toContinue();
        threads[0].setName("Pascal-go02()");
        threads[1].setName("Marcel-go02()");
        threads[2].setName("Sascha-go02()");
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private void go03() {
        System.out.println("");
        System.out.println("");
        System.out.println("Teste Feldinitialisierung in foreach-Schleife:");
        Marker.marker('_');
        Marker.marker('_');
        Integer[] integerFeld = new Integer[50];
        int counter = 0;
        for (Integer integer : integerFeld) {
            integer = ++counter;
        }
        for (Integer integer : integerFeld) {
            System.out.println("Integer-Zahl: " + integer);
        }
        // der Integer-Wert bleibt unverändert
        int oldValue = 0;
        for (int k = 0; k < integerFeld.length; k++) {
            integerFeld[k] = k;
        }
        for (Integer integer : integerFeld) {
            System.out.println("Integer-Zahl: " + integer);
        }
        // jetzt haben wir überall einen Wert gesetzt
        for (Integer integer : integerFeld) {
            System.out.println("Integer-Zahl: " + integer);
        }
        for (Integer integer : integerFeld) {
//            integer+=oldValue;
//            oldValue = integer;
            integer = 10_000;
        }
        for (Integer integer : integerFeld) {
            System.out.println("Integer-Zahl: " + integer);
        }
    }
}

class MyRunnableTester implements Runnable {

    @Override
    public void run() {
        for (int k = 0; k < 1_000; k++) {
            System.out.println(Thread.currentThread().getName() + ": "
                    + "Wert von k: " + k);
        }
    }
}
