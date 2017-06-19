package de.marcelhuber.pruefungsvorbereitung.ocp.suppressedexceptions;

import java.io.*;

/**
 *
 * @author Marcel Huber
 */
public class SuppressedExceptions {

    public static void main(String[] args) {
        new SuppressedExceptions().go();
    }

    private void go() {
//        Exception e;    // das geht so nicht
        try (One one1 = new One(); One one2 = new One(); Two two1 = new Two();
                One one3 = new One(); Two two2 = new Two()) {
            throw new Exception("Try");
        } catch (Exception e) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(SuppressedExceptions.class.getName()).log(Level.SEVERE, null, ex);
//            }
            System.out.println("Exception: " + e.getMessage());
            for (Throwable suppExc : e.getSuppressed()) {
                System.out.println("suppressed: " + suppExc);
//                System.err.println("suppressed: " + suppExc);
            }
        }
    }
}

class One implements AutoCloseable {

    static private int counter;
    private String str;

    @Override
    public void close() throws Exception {
        ++counter;
        str = "Closing One, Nr. " + counter;
        System.out.println(str);
        throw new IOException(str);
    }
}

class Two implements AutoCloseable {

    static private int counter;
    private String str;

    @Override
    public void close() throws Exception {
        ++counter;
        str = "Closing Two, Nr. " + counter;
        System.out.println(str);
        throw new IOException(str);
    }
}
