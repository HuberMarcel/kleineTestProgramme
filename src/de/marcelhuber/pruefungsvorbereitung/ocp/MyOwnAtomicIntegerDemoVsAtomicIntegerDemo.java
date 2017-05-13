package de.marcelhuber.pruefungsvorbereitung.ocp;

// Hinweis: Die Zeilen mit 
//    System.out.println("Thread-ID: " + Thread.currentThread().getId());
// in den Runnables-Klassen in der run()-Methode mal ein- und ausschalten
import java.util.concurrent.atomic.*;
import static de.marcelhuber.systemtools.Pause.*;

/**
 *
 * @author Marcel Huber
 */
public class MyOwnAtomicIntegerDemoVsAtomicIntegerDemo {

    private int initalIntValue = 0;
    private int schleifenDurchlaeufe = 5_000_000;// = 2_000_000;

    public static void main(String[] args) {
        new MyOwnAtomicIntegerDemoVsAtomicIntegerDemo().go();
    }

    private void go() {
        long timeMyOwnAtomicInteger;
        long timeAtomicInteger;
        int testInteger = 12;
        MyOwnAtomicInteger moAI = new MyOwnAtomicInteger(testInteger);
        moAI.setMyTemp(initalIntValue);
        System.out.println("Initialwert moAI:                    " + moAI.getMyInteger());
        for (int i = 0; i < 10; ++i) {
            moAI.getAndIncrement();
        }
        System.out.println("Aktueller Wert moAI (nach Schleife): " + moAI.getMyInteger());
        MyOwnAtomicIntegerRunnable moAIRunnable = new MyOwnAtomicIntegerRunnable();
        moAIRunnable.setIntegerValueOfMyOwnAtomicInteger(2000);
        moAIRunnable.setSchleifenDurchlaeufe(schleifenDurchlaeufe);
        System.out.println(moAIRunnable.getIntegerValueOfMyOwnAtomicInteger());
        Thread thread01 = new Thread(moAIRunnable);
        Thread thread02 = new Thread(moAIRunnable);
        breakInSeconds(5);
        // Zeitmessung
        timeMyOwnAtomicInteger = System.currentTimeMillis();
        thread01.start();
        thread02.start();
        try {
            thread01.join();
            thread02.join();
        } catch (InterruptedException ex) {
        }
        timeMyOwnAtomicInteger = System.currentTimeMillis() - timeMyOwnAtomicInteger;
        System.out.println("");
        System.out.println("Zeit [s] für eigene Atomic-Integer-Klasse: "
                + timeMyOwnAtomicInteger / 1000.0);
        System.out.println(moAIRunnable.getIntegerValueOfMyOwnAtomicInteger());
        //
        // Jetzt das gleiche Spiel mit den Atomic-Integers
        //
        AtomicIntegerRunnable aIRunnable = new AtomicIntegerRunnable();
        aIRunnable.setIntegerValueOfMyOwnAtomicInteger(2000);
        aIRunnable.setSchleifenDurchlaeufe(schleifenDurchlaeufe);
        Thread thread03 = new Thread(aIRunnable);
        Thread thread04 = new Thread(aIRunnable);
        timeAtomicInteger = System.currentTimeMillis();
        thread03.start();
        thread04.start();
        try {
            thread03.join();
            thread04.join();
        } catch (InterruptedException ex) {
        }
        timeAtomicInteger = System.currentTimeMillis() - timeAtomicInteger;
        breakInSeconds(3);
        System.out.println("");
        System.out.println("Zeit [s] für Atomic-Integer-Klasse: "
                + timeAtomicInteger / 1000.0);
        System.out.println(aIRunnable.getIntegerValueOfMyOwnAtomicInteger());
//        // das ist nur die ID des (einzigartigen) Runnable-Objekts
//        System.out.println(aIRunnable.getMyID());
    }
}

class MyOwnAtomicInteger {

    static private boolean stateSaved;

    private Integer myInteger = 0;
    private Integer myOldInteger = 0;

    private int myTemp;

    public MyOwnAtomicInteger() {
    }

//    public MyOwnAtomicInteger(int myInteger) {
//        this(new Integer(myInteger));
//    }
    public MyOwnAtomicInteger(Integer myInteger) {
        this.myInteger = myInteger;
    }

    public Integer getAndIncrementAtomicWithMyOwnWay() {
        int tmp;
        int intToWrite;

        do {
            synchronized (this) {
                tmp = myInteger;
                intToWrite = tmp + 1;
            }
        } while (!compareAndWriteMyOwnWay(tmp, intToWrite));
        synchronized (this) {
            return myInteger;
        }
    }

//    public synchronized boolean compareAndWriteMyOwnWay(int tmp, int intToWrite) {
    public boolean compareAndWriteMyOwnWay(int tmp, int intToWrite) {
//        System.out.println("tmp:       " + tmp);
//        System.out.println("myInteger: " + myInteger);
        synchronized (this) {
            if (tmp == myInteger) {
                myInteger = intToWrite;
                return true;
            }
        }
        return false;
    }

    //    public synchronized Integer getAndIncrement() {
    public Integer getAndIncrement() {

        synchronized (this) {
            myTemp = myOldInteger = myInteger;
            while (!compareMyTempMyInteger());
        }
        synchronized (this) {
            return ++myInteger;
        }
    }

    private synchronized boolean compareMyTempMyInteger() {
        return (myTemp == myOldInteger);
    }

    public Integer getMyInteger() {
        return myInteger;
    }

    public void setMyInteger(Integer myInteger) {
        this.myInteger = myInteger;
    }

    public Integer getMyTemp() {
        return myTemp;
    }

    public void setMyTemp(Integer myTemp) {
        this.myTemp = myTemp;

    }

}

class MyOwnAtomicIntegerRunnable implements Runnable {

    private static int classID;

    private int schleifenDurchlaeufe;
    private MyOwnAtomicInteger moAI;
    final private int myID;

    public MyOwnAtomicIntegerRunnable() {
        myID = ++classID;
        moAI = new MyOwnAtomicInteger();
    }

    public MyOwnAtomicIntegerRunnable(MyOwnAtomicInteger moAI) {
        myID = ++classID;
        this.moAI = moAI;
    }

    @Override
    public void run() {
        for (int i = 0; i < schleifenDurchlaeufe; i++) {
//            System.out.println("ID:" + this.myID);
//            moAI.getAndIncrement();
            moAI.getAndIncrementAtomicWithMyOwnWay();
        }
    }

    public Integer getIntegerValueOfMyOwnAtomicInteger() {
        return moAI.getMyInteger();
    }

    public void setIntegerValueOfMyOwnAtomicInteger(Integer intValue) {
        moAI.setMyInteger(intValue);
    }

    public int getMyID() {
        return myID;
    }

    public void setSchleifenDurchlaeufe(int schleifenDurchlaeufe) {
        this.schleifenDurchlaeufe = schleifenDurchlaeufe;
    }
}

class AtomicIntegerRunnable implements Runnable {

    private static int classID;

    private AtomicInteger aI;
    private int myID;
    private int schleifenDurchlaeufe;

    public AtomicIntegerRunnable() {
        myID = classID++;
        aI = new AtomicInteger();
    }

    public AtomicIntegerRunnable(AtomicInteger aI) {
        myID = classID++;
        this.aI = aI;
    }

    @Override
    public void run() {
        for (int i = 0; i < schleifenDurchlaeufe; i++) {
//            System.out.println("Thread-ID: " + Thread.currentThread().getId());
            aI.getAndIncrement();
        }
    }

    public Integer getIntegerValueOfMyOwnAtomicInteger() {
        return aI.intValue();
    }

    public void setIntegerValueOfMyOwnAtomicInteger(Integer intValue) {
        aI.set(intValue);
    }

    public int getMyID() {
        return myID;
    }

    public void setSchleifenDurchlaeufe(int schleifenDurchlaeufe) {
        this.schleifenDurchlaeufe = schleifenDurchlaeufe;
    }

}
