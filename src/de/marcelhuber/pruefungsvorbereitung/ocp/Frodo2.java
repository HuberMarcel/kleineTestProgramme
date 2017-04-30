package de.marcelhuber.pruefungsvorbereitung.ocp;

import de.marcelhuber.pruefungsvorbereitung.oca.selftestseite75.*;

/**
 *
 * @author Marcel Huber
 */
public class Frodo2 extends Hobbit2 {

    public static void main(String[] args) {
        int myGold = 7;
        System.out.println(new Frodo2().countGold(myGold, 6));
    }
}
