package de.marcelhuber.pruefungsvorbereitung.ocp.chapter10;

/**
 *
 * @author Marcel Huber
 */
public class Singleton02 {

    private Singleton02() {
    }

    static private final Singleton02 INSTANCE = new Singleton02();

    static public Singleton02 getInstance() {
        return INSTANCE;
    }
}
