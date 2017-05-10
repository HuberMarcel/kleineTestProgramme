package de.marcelhuber.pruefungsvorbereitung.oca;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel Huber
 */
public class ExceptionsBeispiele {

    {
        System.out.println("Hallo");
        try {
            throw new Exception();
        } catch (Exception ex) {
//            Logger.getLogger(ExceptionsBeispiele.class.getName()).log(Level.SEVERE, null, ex); // Achtung: separater Thread
            System.out.println("Fehler: " + ex);
        }
    }

    public ExceptionsBeispiele() throws Exception {
//        throw new Exception();
        System.out.println("Objekt erzeugt!");
    }

    public static void main(String[] args) throws Exception {
        new ExceptionsBeispiele().go();
    }

    void go() {
        int _ichBinEinGueltigerBezeichner = Integer.parseInt("4");
        try {
            _ichBinEinGueltigerBezeichner = Integer.parseInt("4L");       // NumberFormatException (unchecked)
        } catch (Exception ex) {
            System.out.println("Fehler: " + ex);
        } finally {
            try {
                _ichBinEinGueltigerBezeichner = Integer.parseInt(null);   // NumberFormatException (unchecked)
            } catch (Exception ex) {
                System.out.println("Fehler: " + ex);

            }
        }
    }
}
