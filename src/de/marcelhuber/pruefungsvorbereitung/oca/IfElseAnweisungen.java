package de.marcelhuber.pruefungsvorbereitung.oca;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class IfElseAnweisungen {
    
    private int zahl;
    private boolean ifChooser;
    
    public static void main(String[] args) {
        boolean assertionEnabled = false;
        assert assertionEnabled = true;
        if (assertionEnabled) {
            System.out.println("Assertions Enabled");
        } else {
            System.out.println("Assertions Disabled");
        }
        new IfElseAnweisungen().go();
    }
    
    private void go() {
        int[] zahlFeld = {13, 20, 23, 30, 33, 40, 45};
        String str;
        Marker.marker();
        System.out.println("Wir durchlaufen folgendes Zahlenfeld: " 
                + Arrays.toString(zahlFeld));
        Marker.marker();
        System.out.println("");
        for (int zahl : zahlFeld) {
            setIfChooser(false);
            if (!ifChooser) {
                System.out.println("Ergebnis der ersten  if-Abfragen:   ");
            } else {
                System.out.println("Ergebnis der zweiten if-Abfragen:   ");
            }
            if (zahl < 20) {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist kleiner als 20");
            } else if (zahl < 30) {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist nicht kleiner als 20, aber kleiner als 30");
            } else if (zahl < 40) {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist nicht kleiner als 30, aber kleiner als 40");
            } else {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist nicht kleiner als 40!");
            }
            //
            setIfChooser(true);
            // die folgenden Code-Zeilen geben exakt das Gleiche aus
            if (!ifChooser) {
                System.out.println("Ergebnis der ersten  if-Abfragen:   ");
            } else {
                System.out.println("Ergebnis der zweiten if-Abfragen:   ");
            }
            if (zahl < 20) {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist kleiner als 20");
            } else if (zahl >= 20 && zahl < 30) {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist nicht kleiner als 20, aber kleiner als 30");
            } else if (zahl >= 30 & zahl < 40) {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist nicht kleiner als 30, aber kleiner als 40");
            } else {
                System.out.println("zahl: " + zahl + ":  Diese Zahl ist nicht kleiner als 40!");
            }
            System.out.println("");
        }
    }
    
    public int getZahl() {
        return zahl;
    }
    
    public void setZahl(int zahl) {
        this.zahl = zahl;
    }
    
    public boolean isIfChooser() {
        return ifChooser;
    }
    
    public void setIfChooser(boolean ifChooser) {
        this.ifChooser = ifChooser;
    }
}
