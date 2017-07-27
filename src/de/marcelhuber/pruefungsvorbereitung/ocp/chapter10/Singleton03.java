package de.marcelhuber.pruefungsvorbereitung.ocp.chapter10;

/**
 *
 * @author Marcel Huber
 */
public class Singleton03 {

    private Singleton03() {
    }

    static private Singleton03 INSTANCE;

    static public Singleton03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton03();
        }
        return INSTANCE;
    }
}
