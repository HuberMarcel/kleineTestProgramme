package de.marcelhuber.pruefungsvorbereitung.ocp.chapter13;

import de.marcelhuber.systemtools.Marker;
//import de.marcelhuber.systemtools.Pause;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel Huber; letzte Änderung: 13.08.2017
 */
class TwoDebitThreadsOnOneBancAccount {
//    // Standardkonstruktor - auskommentiert
//    public TwoDebitThreadsOnOneBancAccount(){}

    public static void main(String[] args) {
        TwoDebitThreadsOnOneBancAccount dummyObject = new TwoDebitThreadsOnOneBancAccount();
        dummyObject.go01();
        dummyObject.go02();
    }

    private void go01() {
        MyBancAccount meinKonto = MyBancAccount.INSTANCE;
//        meinKonto.setStartGuthaben(50);
        meinKonto.setStartGuthaben(53);
        System.out.println("Kontostand zu Beginn:");
        System.out.println(meinKonto.checkGuthaben() + " Euro");
        int abhebZaehler = 0;
        long abhebeBetrag = 10;
        long aktuellesGuthaben;
        while ((aktuellesGuthaben = meinKonto.checkGuthaben()) > 0) {
            if (aktuellesGuthaben - abhebeBetrag >= 0) {
                meinKonto.hebeAb(abhebeBetrag);
                abhebZaehler++;
            } else {
                break;
            }
        }
        System.out.println("Letzter Kontozustand nach " + abhebZaehler
                + " Abhebungen von jeweils " + abhebeBetrag + " Euro:");
        System.out.println(meinKonto.checkGuthaben() + " Euro");
    }

    private void go02() {
        MyBancAccount meinKonto = MyBancAccount.INSTANCE;
        while (MyBancAccount.INSTANCE.checkGuthaben() >= 0) {
            System.out.println("Kontostand zu Beginn der go02()-Methode:");
            System.out.println(meinKonto.checkGuthaben() + " Euro");
            meinKonto.setStartGuthaben(5_000);
            System.out.println("Kontostand jetzt (nach Einzahlung von 97 Euro):");
            System.out.println(meinKonto.checkGuthaben() + " Euro");
            RunnableAbheber runnable = new RunnableAbheber();
            Thread threadOfFred = new Thread(runnable, "Freds Thread");
            Thread threadOfLucy = new Thread(runnable, "Lucys Thread");
            threadOfFred.start();
            threadOfLucy.start();
            try {
                //            while (threadOfFred.isAlive() && threadOfLucy.isAlive()) {
//            }
                threadOfFred.join();
                threadOfLucy.join();
            } catch (InterruptedException ex) {
                System.err.println(ex);
                ex.printStackTrace();
            }
            if (meinKonto.checkGuthaben() < 0) {
                System.out.println("Kontostand am Ende der go02()-Methode:");
                System.out.println(meinKonto.checkGuthaben() + " Euro");
            } else {
                System.err.println("Kontostand am Ende der go02()-Methode:");
                System.err.println(meinKonto.checkGuthaben() + " Euro");
            }
            gebeDieAbhebungenAus(runnable);
            Marker.marker('_');
            Marker.marker('_');
            if (meinKonto.checkGuthaben() < 0) {
                System.out.println("Kontostand am Ende der go02()-Methode:");
                System.out.println(meinKonto.checkGuthaben() + " Euro");
            }
        }
    }

    private void gebeDieAbhebungenAus(RunnableAbheber runnable) {
        System.out.println("Anzahl der durchgeführten Abhebungen:");
        System.out.println(runnable.getAbheber().size());
        System.out.println(runnable.getAbhebZaehler());
        System.out.println("");
        System.out.println("Reihenfolge der Abhebungen: ");
        int counter = 1;
//        PressEnter.toContinue();
        for (String name : runnable.getAbheber()) {
            System.out.println(counter++ + ". Abhebung durchgeführt von "
                    + name);
        }
    }
}

class RunnableAbheber implements Runnable {

    private List<String> abheber;
    private int abhebZaehler;

    @Override
    public void run() {
        synchronized (this) {
            if (abheber == null) {
                abheber = new ArrayList<>();
            }
        }
        MyBancAccount meinKonto = MyBancAccount.INSTANCE;
        long abhebeBetrag = 10;
        long aktuellesGuthaben;
        while ((aktuellesGuthaben = meinKonto.checkGuthaben()) > 0) {
            // der alte Code war auch okay - WICHTIG: 
            // die Initialisierung der ArrayList sollte synchronisiert sein!!
            // alter Code - START
            if (aktuellesGuthaben - abhebeBetrag >= 0) {
                synchronized (this) {
                    abheber.add(Thread.currentThread().getName());
//                    Pause.breakInMillis(1);
                    meinKonto.hebeAb(abhebeBetrag);
                    abhebZaehler++;
                    if (abhebZaehler % 10 == 0) {
                        Thread.yield();
                    }
                }
            } else {
                break;
            }
            // alter Code - ENDE
////            // neuer Code, eigentlich unnötig: abheber = new ArrayList<>(); 
////            //                                 muss synchronized sein!!
//            synchronized (this) {
//                if (aktuellesGuthaben - abhebeBetrag >= 0) {
//                    abheber.add(Thread.currentThread().getName());
//                    meinKonto.hebeAb(abhebeBetrag);
//                    abhebZaehler++;
//                    if (abhebZaehler % 10 == 0) {
//                        Thread.yield();
//                    }
//                } else {
//                    break;
//                }
//            }
        }
    }

    public List<String> getAbheber() {
        return abheber;
    }

    public int getAbhebZaehler() {
        return abhebZaehler;

    }
}

enum MyBancAccount {
    INSTANCE() {
        @Override
        public long hebeAb(long betrag) {
            return guthaben -= betrag;
        }

        @Override
        public long checkGuthaben() {
            return guthaben;
        }

        @Override
        public long setStartGuthaben(long startGuthaben) {
            return guthaben = startGuthaben;
        }
    };
    static private long guthaben;

//    MyBancAccount() {
//    }
    abstract public long hebeAb(long betrag);

    abstract public long checkGuthaben();

    abstract public long setStartGuthaben(long startGuthaben);
}
