package de.marcelhuber.spielereien;

// Hinweis: Der finalize()-Aufruf des GC unterbricht sogar die 
//          Wartezeit, die eigentlich PressEnter.toContinue()
//          erzwingt

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.Pause;
import de.marcelhuber.systemtools.PressEnter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class GarbageCollectorDemo {

    public static void main(String[] args) {
        new GarbageCollectorDemo().go();
        new GarbageCollectorDemo().end();
    }

    private void go() {
        DatenMuell datenMuell01 = new DatenMuell();
        DatenMuell datenMuell02 = new DatenMuell();
        DatenMuell datenMuell03 = new DatenMuell();
        DatenMuell datenMuell04 = new DatenMuell();
        DatenMuell datenMuell05 = new DatenMuell();
        DatenMuell datenMuell06 = new DatenMuell();
        DatenMuell datenMuell07 = new DatenMuell();
        System.out.println("");
        Marker.marker();
        System.out.println("Finalize() Nr. 7");
        datenMuell07.finalize();
        Marker.marker();
        System.out.println("");
        System.out.println("datenmuell07: " + datenMuell07);
        System.out.println(DatenMuell.getCounter());
        System.out.println(DatenMuell.counterWas7);
        // Objekt Nr.07 wird vor GC gerettet, da finalize nur einmal
        // pro Objekt aufgerufen werden kann 
        // So steht es jedenfalls im Buch, ich kann aber nicht erkennen, 
        // dass das stimmt; das "Verweis setzen" (siehe finalize()-Methode)
        // scheint dies jedoch in der Tat zu tun
        DatenMuell datenMuell08 = new DatenMuell();
        DatenMuell datenMuell09 = new DatenMuell();
//        DatenMuell datenMuell10 = datenMuell07;
//        datenMuell10 = null;
        System.out.println("Gelöscht wird gleich:\n" + datenMuell01 + "\n");
        datenMuell01 = null;
        System.out.println("Gelöscht wird gleich:\n" + datenMuell03 + "\n");
        datenMuell03 = null;
        System.out.println("Gelöscht wird gleich:\n" + datenMuell05 + "\n");
        datenMuell05 = null;
        System.out.println("Gelöscht wird gleich:\n" + datenMuell07 + "\n");
        datenMuell07 = null;
        System.out.println("Gelöscht wird gleich:\n" + datenMuell09 + "\n");
        datenMuell09 = null;
        System.gc();
        System.out.println("GC ist gelaufen!".toUpperCase());
        Marker.marker();
        Marker.marker();
        System.out.println("");
        System.out.println(datenMuell01);
        System.out.println(datenMuell02);
        System.out.println(datenMuell03);
        System.out.println(datenMuell04);
        System.out.println(datenMuell05);
        System.out.println(datenMuell06);
        System.out.println(datenMuell07);
        System.out.println(datenMuell08);
        System.out.println(datenMuell09);
        System.out.println("");
        System.out.println("Statische DatenMuell-Variable dtm: "
                + DatenMuell.dtm);
     }

    private void end() {
        System.out.println("In ca. 5 Sekunden wird das Programm ganz beendet!");
        Pause.breakInSecondsWithPoints(5);
        System.out.println("");
        System.out.println(DatenMuell.dtm);
        Marker.marker();
        Marker.marker();
        System.out.println("end".toUpperCase());
        Marker.marker();
        Marker.marker();
    }
}

class DatenMuell {

    static private int counter;

    private String objektName;
    static DatenMuell dtm;
    static boolean counterWas7 = false;

    {
        ++counter;
        if (counterWas7) {
            if (counter == 7) {
                ++counter;
            }
        }
        objektName = "DatenMuell-Objekt-Nr.: " + counter;
        if (counter == 7) {
            counterWas7 = true;
        }
    }

    DatenMuell() {
        System.out.println("Erzeugung von Objekt Nr."
                + counter);
    }

    protected void finalize() {
        if (DatenMuell.counter == 7) {
            System.out.println(this);
            PressEnter.toContinue();
            dtm = this;    // wir retten hiermit Objekt Nr.7 vor dem GC
            System.out.println(dtm);
            PressEnter.toContinue();
        }
        System.out.println("Lösche Objekt mit Namen: " + objektName);
        System.out.println("Es gibt nur noch " + --counter + " Objekte!");
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(DatenMuell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getCounter() {
        return counter;
    }

    public String toString() {
        return objektName;
    }
}
