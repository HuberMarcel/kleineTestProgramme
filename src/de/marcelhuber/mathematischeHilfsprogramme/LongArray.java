package de.marcelhuber.mathematischeHilfsprogramme;

/**
 *
 * @author Marcel Huber
 */
public class LongArray {

    static Long tauschHelfer;

    static public void MirrorTheArray(long[] longArray) {
        int arrayLaenge = longArray.length;
        for (int i = 0; i < arrayLaenge / 2; i++) {
//            System.out.println("vorher an Stelle " + i + ": " + longArray[i]);
//            System.out.println("vorher an Stelle " + (arrayLaenge - 1 - i) + ": "
//                    + longArray[arrayLaenge - 1 - i]);
            tauschHelfer = longArray[i];
            longArray[i] = longArray[arrayLaenge - 1 - i];
            longArray[arrayLaenge - 1 - i] = tauschHelfer;
//            System.out.println("nach dem Tausch an Stelle " + i + ": " + longArray[i]);
//            System.out.println("nach dem Tausch an Stelle " + (arrayLaenge - 1 - i) + ": "
//                    + longArray[arrayLaenge - 1 - i]);
        }
    }

    static public void MirrorTheArray(Long[] longArray) {
        int arrayLaenge = longArray.length;
        for (int i = 0; i < arrayLaenge / 2; i++) {
//            System.out.println("vorher an Stelle " + i + ": " + longArray[i]);
//            System.out.println("vorher an Stelle " + (arrayLaenge - 1 - i) + ": "
//                    + longArray[arrayLaenge - 1 - i]);
            tauschHelfer = longArray[i];
            longArray[i] = longArray[arrayLaenge - 1 - i];
            longArray[arrayLaenge - 1 - i] = tauschHelfer;
//            System.out.println("nach dem Tausch an Stelle " + i + ": " + longArray[i]);
//            System.out.println("nach dem Tausch an Stelle " + (arrayLaenge - 1 - i) + ": "
//                    + longArray[arrayLaenge - 1 - i]);

        }
    }
}
