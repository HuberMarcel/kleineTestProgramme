package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.Pause;

/**
 *
 * @author Marcel Huber; letzte Änderung: 12.08.2017
 */
public class ThreadsMitZweiErgebnissen {

    public static void main(String[] args) {
        long summe = 0;
        long summe01;
        long summe02;
        Thread t01;
        Thread t02;
        MyRunnableSummation myR01 = new MyRunnableSummation(0);
        MyRunnableSummation myR02 = new MyRunnableSummation(40_000);
        while (summe == 0) {
            t01 = new Thread(myR01);
            t02 = new Thread(myR02);
            t01.start();
            t02.start();
            if (!t01.isAlive() && !t02.isAlive()) {
                t01 = new Thread(myR01);
                t02 = new Thread(myR02);
                t01.start();
                t02.start();
            }

            synchronized (MyRunnableSummation.class) {
                summe = myR01.getSumme() + myR02.getSumme();
                summe01 = myR01.getSumme();
                summe02 = myR02.getSumme();
                if (!(summe == 0)) {
                    System.out.println("Summe aus myR01:    " + myR01.getSumme());
                    System.out.println("Summe aus myR02:    " + myR02.getSumme());
                    System.out.println("Summe:              " + summe);
                    System.out.println("summe01 + summe02 = "
                            + (summe01 + summe02));
                }
            }
        }
        MyRunnableSummation myR03 = new MyRunnableSummation(0);
        MyRunnableSummation myR04 = new MyRunnableSummation(20_000);
        t01 = new Thread(myR03);
        t02 = new Thread(myR04);
        t01.start();
        t02.start();
        try {
            t01.join();
            t02.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
        summe = myR03.getSumme() + myR04.getSumme();
        Pause.breakInMillis(1);
        System.out.println("Thread t01 lebt noch: " + t01.isAlive());
        System.out.println("Thread t02 lebt noch: " + t02.isAlive());
        System.out.println("Die Summe der Zahlen von 1 bis 39_999: ");
        System.out.println("Summe: " + summe);
        System.out.println("       " + (int) (39_999 / 2.0 * 40_000));
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Zum Vergleich: (39_999 * 40_000/2) = "
                + (int) (39_999 / 2.0 * 40_000));

    }
}

class MyRunnableSummation implements Runnable {

    private final long startWert;
    private long summe;

    public MyRunnableSummation(Integer startWert) {
        this.startWert = startWert;
    }

    @Override
    public void run() {
        for (long k = startWert; k < startWert + 20_000; k++) {
            synchronized (MyRunnableSummation.class) {
                summe += k;
            }
        }
    }

    public long getSumme() {
        return summe;
    }
}
