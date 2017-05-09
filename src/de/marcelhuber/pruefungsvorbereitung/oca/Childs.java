// in einer Klasse und deren Kindklasse darf die gleiche Signatur bei statischen Methoden 
// stehen, nur nicht mehr bei Objekt-Methoden
package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class Childs extends Parents {

    static int getEinkommen() {       // das ist okay, aber kein Überschreiben 
        return 5000;
    }
    
//    int getEinkommen() {             // illegal
//        return 5000;
//    }

    @Override
    Childs getMe() {
        return this;
    }

    @Override
    void callMyClassName() {
        System.out.println("(Child) Ich bin ein Kind!");
    }
}
