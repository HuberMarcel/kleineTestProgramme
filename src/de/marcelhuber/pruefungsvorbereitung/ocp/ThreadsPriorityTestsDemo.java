package de.marcelhuber.pruefungsvorbereitung.ocp;

import de.marcelhuber.systemtools.Marker;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class ThreadsPriorityTestsDemo {

    public static void main(String[] args) {
        new ThreadsPriorityTestsDemo().go();
    }

    void go() {
        int priority01 = 7;
        int priority02 = 6;
        int priority03 = 1;
        int listSize = 300_000;
        Queue<Long> list01 = new LinkedList<>();
        Queue<Long> list02 = new LinkedList<>();
        FillMyQueueWithLongs fillmQwL01 = new FillMyQueueWithLongs(list01);
        FillMyQueueWithLongs fillmQwL02 = new FillMyQueueWithLongs(list02);
        fillmQwL01.setListSize(listSize);
        fillmQwL02.setListSize(listSize);
        Thread fmQwL01Thread = new Thread(fillmQwL01);
        Thread fmQwL02Thread = new Thread(fillmQwL02);
        fmQwL01Thread.setPriority(priority01);
        fmQwL02Thread.setPriority(priority02);
//        fmQwL01Thread.start();
//        fmQwL02Thread.start();
        //
        //
        FlushMyQueueWithLongs flushmQwL01 = new FlushMyQueueWithLongs(list01);
        Thread flushmQwL01Thread = new Thread(flushmQwL01);
        flushmQwL01Thread.setPriority(priority03);
        fmQwL01Thread.start();
        fmQwL02Thread.start();
        pause(0);
        flushmQwL01Thread.start();    // beachte: wenn die Queue beim ersten Anlauf des Threads leer ist, ist er tot
//
        pause(100);

        System.out.println("Priorität01 = " + fmQwL01Thread.getPriority() + ",\n"
                + "Priorität02 = " + fmQwL02Thread.getPriority() + ",\n"
                + "Size List01 = " + list01.size() + ",\n"
                + "Size List02 = " + list02.size());
        System.out.println("");
        pause(1_000);

        System.out.println("Priorität01 = " + fmQwL01Thread.getPriority() + ",\n"
                + "Priorität02 = " + fmQwL02Thread.getPriority() + ",\n"
                + "Size List01 = " + list01.size() + ",\n"
                + "Size List02 = " + list02.size());
        if (fillmQwL02.getTimeInMillis() > 0) {
            System.out.println("");
            System.out.println("Zeitliche Verhältnis des ersten zum zweiten Threads:");
            System.out.println(fillmQwL01.getTimeInMillis() * 1.0 / fillmQwL02.getTimeInMillis());
        }
        System.out.println("");

        pause(20_000);
        System.out.println("Priorität01 = " + fmQwL01Thread.getPriority() + ",\n"
                + "Priorität02 = " + fmQwL02Thread.getPriority() + ",\n"
                + "Size List01 = " + list01.size() + ",\n"
                + "Size List02 = " + list02.size());
    }

    public void pause(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException ex) {
        }
    }

}

class FillMyQueueWithLongs implements Runnable {

    private Queue<Long> liste;
    private int listSize;
    private int counterOfferGelungen;

    private long timeInMillis;

    public FillMyQueueWithLongs(Queue<Long> liste) {
        this.liste = liste;
    }

    @Override
    public void run() {
        timeInMillis = System.currentTimeMillis();
        for (int i = 0; i < listSize; i++) {
            counterOfferGelungen++;
            liste.offer((long) (Math.random() * 10_000));
        }
        timeInMillis = System.currentTimeMillis() - timeInMillis;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public int getCounterOfferGelungen() {
        return counterOfferGelungen;
    }
}

class FlushMyQueueWithLongs implements Runnable {

    private Queue<Long> liste;
    long timeInMillis;
    int counterPollGelungen;

    @Override
    public void run() {
        timeInMillis = System.currentTimeMillis();
        while (!liste.isEmpty()) {
            liste.poll();
            counterPollGelungen++;
        }
        timeInMillis = System.currentTimeMillis() - timeInMillis;
        Marker.marker();
        System.out.println("Schon fertig mit dem Leeren der Liste!");
        Marker.marker();
    }

    public FlushMyQueueWithLongs(Queue<Long> liste) {
        this.liste = liste;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public int getCounterPollGelungen() {
        return counterPollGelungen;
    }
}
