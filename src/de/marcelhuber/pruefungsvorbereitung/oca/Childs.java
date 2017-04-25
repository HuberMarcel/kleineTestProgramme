package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class Childs extends Parents{

    @Override
    Childs getMe() {
        return this;
    }
    
    @Override
    void callMyClassName() {
        System.out.println("(Child) Ich bin ein Kind!");
    }
}
