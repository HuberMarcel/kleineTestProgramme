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
        int priority01 = 10;
        int priority02 = 1;
        int priority03 = 1;
        int queueSize = 5_000_000;
        Queue<Long> queue01 = new LinkedList<>();
        Queue<Long> queue02 = new LinkedList<>();
        FillMyQueueWithLongs fillmQwL01 = new FillMyQueueWithLongs(queue01);
        FillMyQueueWithLongs fillmQwL02 = new FillMyQueueWithLongs(queue02);
        fillmQwL01.setQueueSize(queueSize);
        fillmQwL02.setQueueSize(queueSize);
        Thread fmQwL01Thread = new Thread(fillmQwL01);
        Thread fmQwL02Thread = new Thread(fillmQwL02);
        fmQwL01Thread.setPriority(priority01);
        fmQwL02Thread.setPriority(priority02);
//        fmQwL01Thread.start();
//        fmQwL02Thread.start();
        //
        //
        FlushMyQueueWithLongs flushmQwL01 = new FlushMyQueueWithLongs(queue01);
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
                + "Size Queue01 = " + queue01.size() + ",\n"
                + "Size Queue02 = " + queue02.size());
        System.out.println("");
        if (fillmQwL02.getTimeInMillis() > 0) {
            System.out.println("");
            System.out.println("Zeitliche Verhältnis des ersten zum zweiten Threads:");
            System.out.println(fillmQwL01.getTimeInMillis() * 1.0 / fillmQwL02.getTimeInMillis());
        }
        pause(5_000);

        System.out.println("Priorität01 = " + fmQwL01Thread.getPriority() + ",\n"
                + "Priorität02 = " + fmQwL02Thread.getPriority() + ",\n"
                + "Size Queue01 = " + queue01.size() + ",\n"
                + "Size Qqeue02 = " + queue02.size());
        if (fillmQwL02.getTimeInMillis() > 0) {
            System.out.println("");
            System.out.println("Zeitliche Verhältnis des ersten zum zweiten Threads:");
            System.out.println(fillmQwL01.getTimeInMillis() * 1.0 / fillmQwL02.getTimeInMillis());
        }
        System.out.println("");

        pause(7_000);
        System.out.println("Priorität01 = " + fmQwL01Thread.getPriority() + ",\n"
                + "Priorität02 = " + fmQwL02Thread.getPriority() + ",\n"
                + "Size Queue01 = " + queue01.size() + ",\n"
                + "Size Queue02 = " + queue02.size());
        if (fillmQwL02.getTimeInMillis() > 0) {
            System.out.println("");
            System.out.println("Zeitliche Verhältnis des ersten zum zweiten Threads:");
            System.out.println(fillmQwL01.getTimeInMillis() * 1.0 / fillmQwL02.getTimeInMillis());
        }
        System.out.println("");
    }

    public void pause(long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException ex) {
        }
    }

}

class FillMyQueueWithLongs implements Runnable {

    private Queue<Long> queue;
    private int queueSize;
    private int counterOfferGelungen;

    private long timeInMillis;

    public FillMyQueueWithLongs(Queue<Long> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        timeInMillis = System.currentTimeMillis();
        for (int i = 0; i < queueSize; i++) {
            counterOfferGelungen++;
            queue.offer((long) (Math.random() * 10_000));
        }
        timeInMillis = System.currentTimeMillis() - timeInMillis;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public int getCounterOfferGelungen() {
        return counterOfferGelungen;
    }
}

class FlushMyQueueWithLongs implements Runnable {

    private Queue<Long> queue;
    long timeInMillis;
    int counterPollGelungen;

    @Override
    public void run() {
        timeInMillis = System.currentTimeMillis();
        while (!queue.isEmpty()) {
            queue.poll();
            counterPollGelungen++;
        }
        timeInMillis = System.currentTimeMillis() - timeInMillis;
        Marker.marker();
        System.out.println("Schon fertig mit dem Leeren der Queue!");
        Marker.marker();
    }

    public FlushMyQueueWithLongs(Queue<Long> queue) {
        this.queue = queue;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public int getCounterPollGelungen() {
        return counterPollGelungen;
    }
}
