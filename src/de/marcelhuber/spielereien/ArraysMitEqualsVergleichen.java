package de.marcelhuber.spielereien;

import de.marcelhuber.systemtools.Marker;
import java.util.Arrays;

/**
 *
 * @author Marcel Huber
 */
public class ArraysMitEqualsVergleichen {

    static byte counterVergleicheFelderInhaltlich;
    Long[] arrayOriginalLong = new Long[]{1L, 2L, 4L, 7L, 15L};
    Integer[] arrayOriginalInteger = {1, 2, 4, 7, 15};
    long[] longArray = new long[]{1, 1, 2, 3, 5, 8, 11, 128, 200};
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 11, 128, (byte) 200};  // nicht identisch zu intArray wegen Verlust beim Cast
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 11, 128, 200};           // identisch zu intArray
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 011, 128, 200};            // nicht identisch zu intArray, da 011 = 1*8+1=9
//    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 013, 128, 200};              // identisch zu intArray, da 013 = 1*8+3=11
    long[] longArrayManipulated = new long[]{1, 1, 2, 3, 5, 8, 0xB, 128, 200};                // identisch zu intArray, da 0xB = 11
    int[] intArray = new int[]{1, 1, 2, 3, 5, 8, 11, 128, 200};

    public static void main(String[] args) {
        new ArraysMitEqualsVergleichen().compareTheTwoArrays();
    }

    private void compareTheTwoArrays() {
        if (arrayOriginalLong.equals(arrayOriginalInteger)) {
            System.out.println("Die beiden Long- und Integer-Felder sind "
                    + "identisch!".toUpperCase());
        } else {
            System.out.println("Die beiden Long- und Integer Felder sind "
                    + "verschieden!".toUpperCase());
        }
        if (arrayOriginalLong.equals(arrayOriginalInteger)) {
            System.out.println("Die beiden long- und int-Felder sind "
                    + "identisch!".toUpperCase());
        } else {
            System.out.println("Die beiden long- und int-Felder sind "
                    + "verschieden!".toUpperCase());
        }
        System.out.println("\n\n");
        System.out.println("Fazit:".toUpperCase());
        System.out.println("Bei equals wird auch der Typ des Arrays beim "
                + "Vergleich benutzt!");
        boolean inhaltsVergleichWrapperFelder
                = vergleicheFelderInhaltlich(arrayOriginalInteger, arrayOriginalLong);
        System.out.println("Ist das Integer- mit dem Long-Feld inhaltlich "
                + "gleich? Unsere Berechnung sagt: " + inhaltsVergleichWrapperFelder);
        System.out.println("\n\n");
        boolean inhaltsVergleichElementarerDatentypFelder
                = vergleicheFelderInhaltlich(intArray, longArray);
        System.out.println("Ist das int- mit dem long-Feld inhaltlich "
                + "gleich? Unsere Berechnung sagt: " + inhaltsVergleichElementarerDatentypFelder);
        System.out.println("\n\n");
        inhaltsVergleichElementarerDatentypFelder
                = vergleicheFelderInhaltlich(intArray, longArrayManipulated);
        System.out.println("Ist das int- mit dem manipulated long-Feld inhaltlich "
                + "gleich? Unsere Berechnung sagt: " + inhaltsVergleichElementarerDatentypFelder);
        System.out.println("\n\n");
    }

    private boolean vergleicheFelderInhaltlich(Object feld01, Object feld02) {
        Marker.marker();
        Marker.marker();
        System.out.println(++counterVergleicheFelderInhaltlich + ". Aufruf der "
                + "Vergleichsmethode!");
        System.out.println("");
        boolean nurWrapper = true;
        boolean returnWert = true;
        if (feld01 == feld02) {
            returnWert = true;
            return returnWert;
        }
//        System.out.println(feld01.getClass().getName());
        int[] intFeld = new int[0];
        long[] longFeld = new long[0];
        if (feld01.getClass().getName().equals("[I")) {
            intFeld = (int[]) feld01;
        }
        if (feld02.getClass().getName().equals("[J")) {
            longFeld = (long[]) feld02;
        }
        if (intFeld.length > 0 || longFeld.length > 0) {
            nurWrapper = false;
        }
        if (!nurWrapper) {
            System.out.println("1. Array: " + Arrays.toString(intFeld));
            System.out.println("2. Array: " + Arrays.toString(longFeld));
            for (int k = 0; k < intFeld.length; k++) {
                if (!(intFeld[k] == longFeld[k])) {
                    System.out.println("");
                    Marker.marker();
                    System.out.println("Hinweis:".toUpperCase());
                    System.out.println("An der Stelle " + k + " hat das erste Feld "
                            + "den Wert " + intFeld[k] + ", das zweite aber "
                            + longFeld[k] + "!");
                    Marker.marker();
                    System.out.println("");
                    System.out.println("");
                    returnWert = false;
                    return returnWert;
                }
            }
        } else {
            Object[] feld1 = (Object[]) feld01;
            Object[] feld2 = (Object[]) feld02;
            if (feld1.length != feld2.length) {
                returnWert = false;
                return returnWert;
            }
            for (int k = 0; k < feld1.length; k++) {
                if (!((feld1[k].getClass().isAssignableFrom(feld2[k].getClass()))
                        || (feld2[k].getClass().isAssignableFrom(feld1[k].getClass())))) {
                    returnWert = false;
                    return returnWert;
                } else {
                    if (!(feld1[k].equals(feld2[k]))) {
                        returnWert = false;
                        return returnWert;
                    }
                }
//            System.out.println(Number.class.isAssignableFrom(Integer.class));   // Ist Number Superklasse von Integer?
                System.out.println(Number.class.isInstance(new Integer("1")));        // kann man ein Integer-Obj. in ein Number casten

            }
        }
        return returnWert;
    }
}
