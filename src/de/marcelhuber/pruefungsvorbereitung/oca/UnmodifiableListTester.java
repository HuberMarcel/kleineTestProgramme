package de.marcelhuber.pruefungsvorbereitung.oca;

//import com.sun.javafx.*;
import java.util.*;

/**
 *
 * @author Marcel Huber
 */
public class UnmodifiableListTester {

    private List<Long> testListe = new ArrayList<>();

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
        List<Long> listeZumAuslesen = rueckgabeUnmodfiableList();
        try {
            //            ((List<Long>) listeZumAuslesen).add(27L); // bringt nix, da Polymorphie
            listeZumAuslesen.add(27L); // das geht nicht, da wir hier eine unmodifizierbare Liste bekommen 
            // rueckgabeUnmodfiableList() die erste Zeile einkommentiert ist
        } catch (UnsupportedOperationException ex) {
            System.out.println("Fehler:" + ex);
        }
        testListe.add(testListe.size(), 45L);  // Z2: // wenn Z1: einkommentiert, bleibt testListe modifizierbar
        Long[] longArray = new Long[testListe.size()];
        testListe.toArray(longArray);
        System.out.println(Arrays.toString(longArray));
        // Ausgabe von [45], wenn Zeile Z1:   einkommentiert, da dann in rueckgabeUnmodfiableList()
        // mit shadow-Variable für Liste gearbeitet wird
        // RuntimeError in Zeile, wenn Z1:   auskommentiert, da dann zwischendurch testListe unmodifiziertbar gesetzt wird
    }

    private List<Long> rueckgabeUnmodfiableList() {
        List<Long> testListe = new ArrayList<>(); // Z1:   läßt man diese Zeile weg, so knallt es in 
        // List<Long> listeZumAuslesen = rueckgabeUnmodfiableList(); bei der go()-Methode
        testListe.add(1L);
        testListe.add(3L);
        testListe.add(5L);
        testListe.add(7L);
        testListe.add(9L);
        testListe = Collections.unmodifiableList(testListe); // hier wird die globale Testliste unmodifizierbar
        return testListe;
    }
}
