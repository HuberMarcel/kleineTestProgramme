package de.marcelhuber.kleinetestprogramme;

import java.io.IOException;

/**
 *
 * @author Marcel Huber
 */
public class KleineTestprogramme {

    static private int fallSchalter;
// bei 0 wird durch kleineIntVariable=0 geteilt
// und wir erhalten eine entsprechende Exception
    static private Integer kleineIntegerVariable;
    static private int kleineIntVariable = 0;
    static private Object o;

    static {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Geben Sie im Idealfall den Wert für die Variable "
                + "'fallSchalter' beim Aufruf mit an (in args[0] | der "
                + "default-Wert ist 0)!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
        System.out.println("Der Wert von 'kleineIntegerVariable': "
                + kleineIntegerVariable);
        System.out.println("Der Wert von 'kleineIntVariable': "
                + kleineIntVariable);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int uebergabeWert = Integer.parseInt(args[0]);
            fallSchalter = uebergabeWert;
        } catch (NumberFormatException ex) {
            fallSchalter = 0;
        } catch (ArrayIndexOutOfBoundsException ex) {
            fallSchalter = 0;
        } finally {
            System.out.println("Wir betrachten den Fall für den Wert des "
                    + "'fallSchalter': " + fallSchalter);
        }

        KleineTestprogramme runObjekt = new KleineTestprogramme();
        KleineTestprogramme.go00();
//        wäre auch gegangen mit: 
//        new KleineTestprogramme().go00(); 
        try {
            runObjekt.go01();
        } catch (ArithmeticException ex) {
            System.out.println(
                    "\nDu wirst doch nicht durch 0 teilen wollen?!"
                    + " \nFehlermeldung: " + ex + "\n");
        };
    }

    static void go00() {
        System.out.println("Ich bin die statische Methode go00!");
    }

    void go01() throws ArithmeticException {
        int zaehler = 12;
//        System.out.println(zaehler + "/" + kleineIntVariable++ + " = "
//                + (zaehler / kleineIntVariable++));
        switch (fallSchalter) {
            case 0:
                break;
            case 1:
                ++kleineIntVariable;
            default:
                break;
        }

        System.out.println(zaehler + "/" + kleineIntVariable + "++ [Wert von "
                + "'kleineIntVariable': " + kleineIntVariable + "]= "
                + (zaehler / kleineIntVariable++) + "[Wert von 'kleineIntVariable': "
                + kleineIntVariable + "]");
        kleineIntVariable = 0;
        System.out.println("Jetzt hat die Variable 'kleineIntVariable' wieder den "
                + "Wert: ");
        System.out.println(zaehler + "/" + ++kleineIntVariable + " = "
                + (zaehler / ++kleineIntVariable));
        System.out.println("");
//        o = new Object();
        System.out.println("Unser Objekt hat den Wert: " + o);
    }

}
