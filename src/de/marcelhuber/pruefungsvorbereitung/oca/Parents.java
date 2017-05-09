package de.marcelhuber.pruefungsvorbereitung.oca;

/**
 *
 * @author Marcel Huber
 */
public class Parents {

    private void getMeinVersteck(){
        System.out.println("Das hier sehe nur ich!");
    }
    
    static int getEinkommen() {
        return 10_000;
    }

    Parents getMe() {
        return this;
    }

    void callMyClassName() {
        System.out.println("(Parents) Ich bin ein Elternteil!");
    }

}
