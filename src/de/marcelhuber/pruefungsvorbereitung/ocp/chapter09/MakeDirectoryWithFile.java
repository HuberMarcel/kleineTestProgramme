// siehe Buch Seite 485...
package de.marcelhuber.pruefungsvorbereitung.ocp.chapter09;

import de.marcelhuber.systemtools.Marker;
import de.marcelhuber.systemtools.PressEnter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class MakeDirectoryWithFile {

    public static void main(String[] args) {
        MakeDirectoryWithFile dummyObject = new MakeDirectoryWithFile();
        dummyObject.go01();
    }

    private void go01() {
        String testOrdner = "TestOrdner";
        File file01 = new File(testOrdner);
        file01.mkdir();
        System.out.print("Existiert nun der Ordner " + testOrdner + "? ");
        System.out.println(file01.exists());
        System.out.print("Und das ist wirklich ein Ordner? ");
        System.out.println(file01.isDirectory());
        File file02 = new File(file01, "test.txt");
        try {
            file02.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(MakeDirectoryWithFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        PressEnter.toContinue();
        Marker.marker('_');
        Marker.marker('_');
        System.out.println("Okay, dann löschen wir den wieder!");
        boolean ordnerLoeschenHatGeklappt = file01.delete();
        System.out.println("Wurde der Ordner gelöscht? " + ordnerLoeschenHatGeklappt);
        // der Ordner war nicht leer, deswegen wird er nicht gelöscht worden sein
        PressEnter.toContinue();
        Marker.marker('_');
        Marker.marker('_');
        file02.delete();
        ordnerLoeschenHatGeklappt = file01.delete();
        System.out.println("Wurde der Ordner nun gelöscht? " + ordnerLoeschenHatGeklappt);
    }
}
