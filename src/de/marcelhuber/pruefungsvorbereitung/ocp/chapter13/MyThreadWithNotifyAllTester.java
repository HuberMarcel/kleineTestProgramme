package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Marker;

/**
 *
 * @author Marcel Huber; letzte Änderung: 14.08.2017
 */
public class MyThreadWithNotifyAllTester {

    public static void main(String[] args) {
        MyThreadWithNotifyAllTester dummyObject = new MyThreadWithNotifyAllTester();
        dummyObject.go01();
        dummyObject.go02();
    }

    private void go01() {
        System.out.println("");
        System.out.println("---    go01()-Methode startet   ---");
        System.out.println("\n");
        CalculationForFakRunnable calcForFakRunnable
                = new CalculationForFakRunnable();
        calcForFakRunnable.setFakNumber(5);
        ReadMyCalculationResultRunnable myFakultaetReader01
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        ReadMyCalculationResultRunnable myFakultaetReader02
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        ReadMyCalculationResultRunnable myFakultaetReader03
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        ReadMyCalculationResultRunnable myFakultaetReader04
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        Thread thread01 = new Thread(myFakultaetReader01);
        Thread thread02 = new Thread(myFakultaetReader02);
        Thread thread03 = new Thread(myFakultaetReader03);
        Thread thread04 = new Thread(myFakultaetReader04);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        Thread calcThread = new Thread(calcForFakRunnable);
        calcThread.start();
        try {
            thread01.join();
            thread02.join();
            thread03.join();
            thread04.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
            ex.printStackTrace();
        }
    }

    private void go02() {
        System.out.println("");
        System.out.println("---    go02()-Methode startet   ---");
        System.out.println("\n");
        CalculationForFakRunnable calcForFakRunnable
                = new CalculationForFakRunnable();
        calcForFakRunnable.setUseNotifyAndNotNotifyAll(true);
        calcForFakRunnable.setFakNumber(5);
        ReadMyCalculationResultRunnable myFakultaetReader01
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        ReadMyCalculationResultRunnable myFakultaetReader02
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        ReadMyCalculationResultRunnable myFakultaetReader03
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        ReadMyCalculationResultRunnable myFakultaetReader04
                = new ReadMyCalculationResultRunnable(calcForFakRunnable);
        Thread thread01 = new Thread(myFakultaetReader01);
        Thread thread02 = new Thread(myFakultaetReader02);
        Thread thread03 = new Thread(myFakultaetReader03);
        Thread thread04 = new Thread(myFakultaetReader04);
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        Thread calcThread = new Thread(calcForFakRunnable);
        calcThread.start();
    }
}

class ReadMyCalculationResultRunnable implements Runnable {

    private final CalculationForFakRunnable calcRunnable;

    public ReadMyCalculationResultRunnable(CalculationForFakRunnable calcRunnable) {
        this.calcRunnable = calcRunnable;
    }

    @Override
    public void run() {
        synchronized (calcRunnable) {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName()
                        + "   ---   Waiting for calculation-result...");
                if (!calcRunnable.isRunIsFinished()) {
//                    calcRunnable.wait();
                    calcRunnable.wait(3_000);
                }
            } catch (InterruptedException ex) {
                System.err.println(ex);
                ex.printStackTrace();
            }
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " liest: "
                + "Es ist " + calcRunnable.getFakNumber() + "! = "
                + calcRunnable.getFakultaet());
    }
}

class CalculationForFakRunnable implements Runnable {

    private long fakultaet;
    private long fakNumber;
    private boolean useNotifyAndNotNotifyAll;
    private boolean runIsFinished;

    {
        fakultaet = 1;
    }

    @Override
    public void run() {
        long calcFakNumber = fakNumber;
        synchronized (this) {
            while (calcFakNumber > 1) {
                fakultaet *= calcFakNumber--;
            }
            System.out.println("");
            Marker.marker('_');
            System.out.println("Calculation is finished!");
            Marker.marker('_');
            Marker.marker('_');
            System.out.println("\n");
            if (useNotifyAndNotNotifyAll) {
                notify();
            } else {
                notifyAll();
            }
            runIsFinished = true;
        }
    }

    public long getFakultaet() {
        return fakultaet;
    }

    public long getFakNumber() {
        return fakNumber;
    }

    public void setFakNumber(long fakNumber) {
        this.fakNumber = fakNumber;
    }

    public boolean isUseNotifyAndNotNotifyAll() {
        return useNotifyAndNotNotifyAll;
    }

    public void setUseNotifyAndNotNotifyAll(boolean useNotifyAndNotNotifyAll) {
        this.useNotifyAndNotNotifyAll = useNotifyAndNotNotifyAll;
    }

    public boolean isRunIsFinished() {
        return runIsFinished;
    }
}
