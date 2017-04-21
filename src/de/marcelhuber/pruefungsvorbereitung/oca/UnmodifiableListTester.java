package de.marcelhuber.pruefungsvorbereitung.oca;

import com.sun.javafx.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class UnmodifiableListTester {

    ArrayList<Long> testListe = new ArrayList<>();

    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new UnmodifiableListTester().go();
    }

    private void go() {
        UnmodifiableArrayList<Long> listeZumAuslesen = rueckgabeUnmodfiableList();
//        listeZumAuslesen.add(27L);    
    }

    private UnmodifiableArrayList<Long> rueckgabeUnmodfiableList() {
        UnmodifiableArrayList<Long> ichBinEineUnmodifizierbareListe;
        testListe = new ArrayList<>();
        testListe.add(1L);
        testListe.add(3L);
        testListe.add(5L);
        testListe.add(7L);
        testListe.add(9L);
        ichBinEineUnmodifizierbareListe = (UnmodifiableArrayList<Long>) Collections.unmodifiableList(testListe);
        return ichBinEineUnmodifizierbareListe;
    }

}
