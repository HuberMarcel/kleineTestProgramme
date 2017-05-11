package de.marcelhuber.pruefungsvorbereitung.ocp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class Threads {

    private int waitingCounter;
    private boolean secondThread;

    {
        publicQueue = new LinkedList<>();
    }

    private Queue<Long> publicQueue;

    public static void main(String[] args) {
        new Threads().go();
    }

    void go() {
        FillTheQueWithNumbers fillTheQueWithNumbers = new FillTheQueWithNumbers(publicQueue);
        fillTheQueWithNumbers.setTime(1);
        fillTheQueWithNumbers.setAnzahlNumbers(5_000);     // mal mit 100_000 testen - Problem
        Thread fillMyQueue = new Thread(fillTheQueWithNumbers);
//        fillMyQueue.start();
        secondThread = true;
        if (!secondThread) {
            System.out.println(publicQueue);
            pause(0);
            System.out.println(publicQueue);
//        while (!fillTheQueWithNumbers.isKeyIsFree()) {
//            System.out.println(++waitingCounter + ": Waiting for the key!");
//        }
            System.out.println("Queue-size: " + publicQueue.size());
        }
        GetTheNumbersFromTheQueue getTheNumbersFromTheQueue = new GetTheNumbersFromTheQueue(publicQueue);
        getTheNumbersFromTheQueue.setShowMyQueue(false);
        Thread flushMyQueue = new Thread(getTheNumbersFromTheQueue);
        fillTheQueWithNumbers.setTime(0);   // hier mal 10 und bei dem nächsten 0 eintragen 
        // --> filling-Thread lebt sehr lange (Größe /10 in Sekunden mindestens)
        getTheNumbersFromTheQueue.setTime(0);
        // Priority-Tests: (fillMyQueue,flushMyQueue) 
        //  (1,1)  --> while() mit Waiting unten: 172286: Waiting for the key! vor Freigabe meines boolean key
        //  (1,5)  -->                            319049: Waiting for the key!
        //  (1,10) -->                             69505: Waiting for the key!
        //  (5,10) -->                              1620: Waiting for the key!
        //  (2,1)  -->                              3710: Waiting for the key!
        //  (6,1)  -->                              799: Waiting for the key!
        // (10,1)  -->                              464: Waiting for the key! 
        // witzig: Das ist abhängig von der Priorität des flushMyQueueThreads
        fillMyQueue.setPriority(5);
        flushMyQueue.setPriority(10);
        fillMyQueue.start();
//        pause(2);
        /**
         * Für Priority-Tests die folgenden 3 Zeilen und die übernächste Pause
         * einkommentieren *
         */
//        while (!fillTheQueWithNumbers.isKeyIsFree()) {
//            System.out.println(++waitingCounter + ": Waiting for the key!");
//        }
        flushMyQueue.start();
//        pause(16_000);
        System.err.print("(" + fillMyQueue.getPriority() + ","
                + flushMyQueue.getPriority() + ") -->                           ");
        System.err.println("KeyFreigabe nach " + waitingCounter + " Zählungen!");
        // witzig: Ohne Pause bei System.out kann es sein, dass die publicQueue unten als 
        // leer oder unvollständig gefüllt angezeigt wird, da die Systemausgabe
        // auf die Queue zugegriffen hat, während oder sogar noch bevor sie im 
        // "Filling-Modus" des anderen Threads war 
        pause(10);
        System.out.println(publicQueue.size());
        pause(5);
        System.out.println(publicQueue.size());
        pause(5);
        System.out.println(publicQueue.size());
        pause(1000);
        System.out.println(publicQueue.size());
        
    }

    void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
        }
    }
}

class FillTheQueWithNumbers implements Runnable {

    private final Queue<Long> myQueue;
    private int anzahlNumbers;
    private boolean keyIsFree;
    private long time;

    FillTheQueWithNumbers(Queue<Long> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        keyIsFree = false;
        // try-catch außerhalb der for-Schleife, da die vermutlich Zeit kostet
        try {
            for (int i = 0; i < anzahlNumbers; i++) {
                myQueue.offer((Long) (long) (Math.random() * 10_000));    // Zahlen zwischen 0 und 9999
                Thread.sleep(time);
            }
        } catch (InterruptedException ex) {
        }
        System.out.println("");
        System.err.println("My Job is done: I offered " + anzahlNumbers + " Longs "
                + "to the Queue!!!");
        System.out.println("");
        keyIsFree = true;
    }

    public boolean isKeyIsFree() {
        return keyIsFree;
    }

    public int getAnzahlNumbers() {
        return anzahlNumbers;
    }

    public void setAnzahlNumbers(int anzahlNumbers) {
        this.anzahlNumbers = anzahlNumbers;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String toString() {
        return "TestobjekteFuerThreads - Objekt!";
    }
}

class GetTheNumbersFromTheQueue implements Runnable {

    private final Queue<Long> myQueue;
    private boolean showMyQueue;
    private long time;
    private long countPollWasSuccessfull;
    private long queueSize;

    public GetTheNumbersFromTheQueue(Queue<Long> myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        // try-catch außerhalb der while-Schleife, da die vermutlich Zeit kostet
        try {
            while (!myQueue.isEmpty()) {
                System.out.println("Aktuelle Queue-Größe:            "
                        + myQueue.size());
                System.out.println("Aktuell zu entfernendes Element: "
                        + myQueue.peek());
                Thread.yield();
                queueSize = myQueue.size();
                System.out.println("Entfernt wird:                   "
                        + myQueue.poll() + " aus der Queue der Groesse: "
                        + (queueSize - 1));
//                Thread.sleep(200);
                if (myQueue.size() > queueSize - 1) {
                    System.err.println("\nSieh' mal an: Da hat mittlerweile schon "
                            + "wieder jemand was in die Queue eingefügt!\n");
                    Thread.sleep(1000);
                }
                // hier kann eigentlich nichts schiefgehen, da das vornestehende
                // Element ja nicht beeinflusst wird
                countPollWasSuccessfull++;
                if (showMyQueue) {
                    System.out.println("Aktuelles Aussehen der Queue:");
                    System.out.println(myQueue);
                }
                System.out.println("");
                Thread.sleep(time);
            }
        } catch (InterruptedException ex) {
        }
//        System.err.println("\nAnzahl der Entfernungen: " + countPollWasSuccessfull);   
// ungünstig, da verwirrend, da Nebenthread
// Logischer Ablauf kann fertig sein, so dass die Ausgabe mitten in der AUsgabe der ...: Waiting erscheinen kann
// weil der Thread beim "Buffered" Printen noch Zeit braucht
        System.out.println("\nAnzahl der Entfernungen: " + countPollWasSuccessfull);
    }

    public boolean isShowMyQueue() {
        return showMyQueue;
    }

    public void setShowMyQueue(boolean showMyQueue) {
        this.showMyQueue = showMyQueue;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getCountPollWasSuccessfull() {
        return countPollWasSuccessfull;
    }

    public void setCountPollWasSuccessfull(long countPollWasSuccessfull) {
        this.countPollWasSuccessfull = countPollWasSuccessfull;
    }
}
